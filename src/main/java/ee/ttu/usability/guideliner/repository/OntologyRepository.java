package ee.ttu.usability.guideliner.repository;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.search.EntitySearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import uk.ac.manchester.cs.jfact.JFactFactory;
import uk.ac.manchester.cs.owl.owlapi.OWLLiteralImplString;

import javax.annotation.PostConstruct;

/**
 * @author jevgeni.marenkov
 */
@Slf4j
@Repository
public class OntologyRepository {

	//TODO move to file or give as a parameter
//	private static String ontologyFile = "C:\\Users\\jevge\\university\\ontology\\project\\protege-ontology\\usability-guidelines-ontology_v1.1.owl";
//	private static String ontologyFile = "..\\protege-ontology\\usability-guidelines-ontology_v1.1.owl";
	public static String ontologyFile = "classpath:usability-guidelines-ontology_v1.1.owl";

	//private static String ontologyFile = "C:\\Users\\jevge\\university\\ontology\\project\\protege-ontology\\usability-guidelines-ontology_v1.1.owl";
	//private static String ontologyFile2 = "C:\\Users\\jevge\\university\\ontology\\files\\conference\\usability-guidelines-ontology_v1.1.owl";
	private static String nameSpace = "http://www.semanticweb.org/tarmo/ontologies/2016/3/wug-ont#";
	public static OWLOntology ontology;
	public static OWLReasoner reasoner;


	private ResourceLoader resourceLoader;

	@Autowired
	public OntologyRepository(ResourceLoader resourceLoader) throws OWLOntologyCreationException {
		this.resourceLoader = resourceLoader;
	}

	@PostConstruct
	public void initialise() throws OWLOntologyCreationException {
		reloadOntology();
		initialiseReasoner();
	}
	
	public void reloadOntology() throws OWLOntologyCreationException {
		try {
			OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
//			System.out.println(resourceLoader);
//			System.out.println(resourceLoader.getResource(ontologyFile));
//			System.out.println();
			ontology = ontologyManager.loadOntologyFromOntologyDocument(resourceLoader.getResource(ontologyFile).getInputStream());
//			ontology = ontologyManager.loadOntologyFromOntologyDocument(new File(ontologyFile));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void initialiseReasoner() {
        OWLReasonerFactory reasonerFactory = new JFactFactory();
        ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
        OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
        reasoner = reasonerFactory.createReasoner(ontology, config);
        boolean consistent = reasoner.isConsistent();
        log.debug("Reasoner initialised successfully. Consistance of ontology: " + consistent);
	}

	public OWLClass loadClass(String shortName) {
		return ontology.getOWLOntologyManager().getOWLDataFactory().getOWLClass(composeIRI(shortName));
	}
	
	public OWLDataProperty laodOWLDataProperty(String shortName) {
		return ontology.getOWLOntologyManager().getOWLDataFactory().getOWLDataProperty(composeIRI(shortName));
	}

	public IRI composeIRI(String shortName) {
		return IRI.create(nameSpace + shortName);
	}
	
	public NodeSet<OWLNamedIndividual> getIndividuals(OWLClass owlClass) {
		return reasoner.getInstances(owlClass, true);
	}
	
	public Optional<OWLClassExpression> getEntityTypeOfIndividual(OWLIndividual individual) {
		return EntitySearcher.getTypes(individual, ontology).findAny();
	}

	public String getAnnotationValueByAnnotationName(OWLClass clazz, String property) {
		Optional<OWLAnnotationAssertionAxiom> assertionAxiom = EntitySearcher.getAnnotationAssertionAxioms(clazz, ontology).filter(assertion ->
			property.equals(assertion.getProperty().getIRI().getShortForm())).findFirst();
		if (assertionAxiom.isPresent()) {
			OWLAnnotationAssertionAxiom axiom = assertionAxiom.get();
			if (axiom.getValue() instanceof OWLLiteralImplString) {
				return ((OWLLiteralImplString) axiom.getValue()).getLiteral(); 
			}
		}
		return null;
	}

}
