package ee.ttu.usability.guideliner.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import ee.ttu.usability.guideliner.repository.OntologyRepository;
import ee.ttu.usability.guideliner.estimation.result.Guideline;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.FailedElement;


/**
 * @author jevgeni.marenkov
 */
@Service
public class OntologyService {

	private final String USABILITY_GUIDELINES = "UsabilityGuideline";
	
	private final OntologyRepository ontology;
	
	@Autowired
	public OntologyService (OntologyRepository ontology) {
		this.ontology = ontology;
	}
	
	public Stream<OWLClass> getAllUsabilityGuidelines() {
		OWLClass guidelines = ontology.loadClass(USABILITY_GUIDELINES);
		return OntologyRepository.reasoner.getSubClasses(guidelines).entities();
	}

	public Stream<OWLClass> getAllWcagUsabilityGuidelines() {
		OWLClass guidelines = ontology.loadClass("WcagGuideline");
		return OntologyRepository.reasoner.getSubClasses(guidelines).entities();
	}

	public List<Guideline> findUsabilityGuidelinesByCategory(String category) {
		List<Guideline> guidelines = new ArrayList<>();

		if (category.equals("AllGuidelines")) {
			OntologyRepository.reasoner.getSubClasses(ontology.loadClass("WcagGuideline"))
					.entities()
					.filter(c -> !c.getIRI().getShortForm().equals("Nothing"))
					.forEach(c -> {
						guidelines.add(createGuideline(c));
					});

			OntologyRepository.reasoner.getSubClasses(ontology.loadClass("UsabilityGuideline"))
					.entities()
					.filter(c -> !c.getIRI().getShortForm().equals("Nothing"))
					.forEach(c -> {
						guidelines.add(createGuideline(c));
					});

			OntologyRepository.reasoner.getSubClasses(ontology.loadClass("MobileUsabilityGuideline"))
					.entities()
					.filter(c -> !c.getIRI().getShortForm().equals("Nothing"))
					.forEach(c -> {
						guidelines.add(createGuideline(c));
					});



			return guidelines;
		}

		OntologyRepository.reasoner.getSubClasses(ontology.loadClass(category))
				.entities()
				.filter(c -> !c.getIRI().getShortForm().equals("Nothing"))
				.forEach(c -> {
					guidelines.add(createGuideline(c));
				});

		return guidelines;
	}

	public Guideline createGuideline(OWLClass clazz) {
		String shortIri = clazz.getIRI().getIRIString().substring(clazz.getIRI().getIRIString().lastIndexOf("#") + 1);
		Guideline guideline = new Guideline();
		guideline.setCode(shortIri);
		guideline.setName(ontology.getAnnotationValueByAnnotationName(clazz, "guideline"));
		guideline.setDescription(ontology.getAnnotationValueByAnnotationName(clazz, "comment"));
		return guideline;
	}
	
//	public List<Guideline> getAllUsabilityGuidelinesHardCoded() {
//		List<Guideline> guidelines = new ArrayList<Guideline>();
//		List<String> guidelineCodes = Arrays.asList(
//				"05-07_LimitHomePageLength",
//				"03-03_DoNotUseColorAloneToConveyInformation",
//				"11-01_UseBlackTextonPlainHighContrastBackgrounds",
//				"10-11_UseAppropriateTextLinkLengths",
//				"08-01_EliminateHorizontalScrolling");
//		for (String code : guidelineCodes) {
//			OWLClass clazz = ontology.loadClass(code);
//			Guideline guide = new Guideline();
//			guide.setCode(code);
//			guide.setName(ontology.getAnnotationValueByAnnotationName(clazz, "guideline"));
//			guide.setDescription(ontology.getAnnotationValueByAnnotationName(clazz, "comment"));
//			guidelines.add(guide);
//		}
//		return guidelines;
//	}
//

	
//	public List<EvaluationResult> getAllUsabilityGuidelinesHardCodedWithResults() {
//		List<EvaluationResult> results = new ArrayList<EvaluationResult>();
//		List<Guideline> guidelines = new ArrayList<Guideline>();
//		List<String> guidelineCodes = Arrays.asList(
//				"05-07_LimitHomePageLength",
//				"03-03_DoNotUseColorAloneToConveyInformation",
//				"08-01_EliminateHorizontalScrolling",
//				"11-01_UseBlackTextonPlainHighContrastBackgrounds",
//				"10-11_UseAppropriateTextLinkLengths");
//		for (String code : guidelineCodes) {
//			OWLClass clazz = ontology.loadClass(code);
//			Guideline guide = new Guideline();
//			guide.setCode(code);
//			guide.setName(ontology.getAnnotationValueByAnnotationName(clazz, "guideline"));
//			guide.setDescription(ontology.getAnnotationValueByAnnotationName(clazz, "comment"));
//			guidelines.add(guide);
//
//			if (code.equals("03-03_DoNotUseColorAloneToConveyInformation")) {
//		    	EvaluationResult result = new EvaluationResult();
//		    	result.setResult(ResultType.FAIL);
//		    	results.add(result);
//
//		    	List<FailedElement> elements = new ArrayList<FailedElement>();
//		    	FailedElement elmnt = new FailedElement();
//		    	elmnt.setPathToElement("old_news.jpg");
//		    	elmnt.setDescription("Required contrast is 4.50. Actual contrast is 4.17");
//		    	elmnt.setText("News Achieve");
//		    	elmnt.setType("Link");
//		    	elements.add(elmnt);
//
//		    	 elmnt = new FailedElement();
//		    	elmnt.setPathToElement("ligin_to_etis.JPG");
//		    	elmnt.setDescription("Required contrast is 4.50. Actual contrast is 3.45");
//		    	elmnt.setText("LOG IN");
//		    	elmnt.setType("Link");
//		    	elements.add(elmnt);
//
//
//
//		    	elmnt = new FailedElement();
//		    	elmnt.setPathToElement("aaa.jpg");
//		    	elmnt.setDescription("Required contrast is 4.50. Actual contrast is 4.45");
//		    	elmnt.setText("A+");
//		    	elmnt.setType("Link");
//		    	elements.add(elmnt);
//
//		    	result.setFailedElements(elements);
//		    	result.setGuideline(guide);
//			}
//
//			if (code.equals("08-01_EliminateHorizontalScrolling")) {
//		    	EvaluationResult result = new EvaluationResult();
//		    	results.add(result);
//		    	result.setResult(ResultType.FAIL);
//		    	List<FailedElement> elements = new ArrayList<FailedElement>();
//		    	FailedElement elmnt = new FailedElement();
//		    	elmnt.setPathToElement("NONE");
//		    	elmnt.setDescription("Horizontal scrol value is bigger then defined. Real value is 2563");
//		    	elmnt.setText("Home page");
//		    	elmnt.setType("Page");
//		    	elements.add(elmnt);
//		    	result.setFailedElements(elements);
//		    	result.setGuideline(guide);
//			}
//
//			if (code.equals("10-11_UseAppropriateTextLinkLengths")) {
//		    	EvaluationResult result = new EvaluationResult();
//		    	results.add(result);
//		    	result.setResult(ResultType.SUCCESS);
//		    	List<FailedElement> elements = new ArrayList<FailedElement>();
//		    	result.setFailedElements(elements);
//		    	result.setGuideline(guide);
//			}
//
//			if (code.equals("05-07_LimitHomePageLength")) {
//		    	EvaluationResult result = new EvaluationResult();
//		    	results.add(result);
//		    	result.setResult(ResultType.FAIL);
//		    	List<FailedElement> elements = new ArrayList<FailedElement>();
//		    	FailedElement elmnt = new FailedElement();
//		    	elmnt.setPathToElement("NONE");
//		    	elmnt.setDescription("Amount of WORD was 991. Expected value was 800.");
//		    	elmnt.setText("Home page");
//		    	elmnt.setType("Page");
//		    	elements.add(elmnt);
//		    	result.setFailedElements(elements);
//		    	result.setGuideline(guide);
//			}
//
//			if (code.equals("11-01_UseBlackTextonPlainHighContrastBackgrounds")) {
//		    	EvaluationResult result = new EvaluationResult();
//		    	results.add(result);
//		    	result.setResult(ResultType.SUCCESS);
//		    	List<FailedElement> elements = new ArrayList<FailedElement>();
//		    	result.setFailedElements(elements);
//		    	result.setGuideline(guide);
//			}
//
//		}
//		return results;
//	}
//
}
