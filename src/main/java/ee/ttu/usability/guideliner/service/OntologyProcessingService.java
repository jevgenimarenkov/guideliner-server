package ee.ttu.usability.guideliner.service;

import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import java.util.List;

/**
 * Service for queering usability guidelines defined by the mean of ontology in OWL/XML file
 */
public interface OntologyProcessingService {

    /**
     * Fills Ontology with the latest OWL/XML file
     * @throws OWLOntologyCreationException
     */
    void reloadOntology() throws OWLOntologyCreationException;

    /**
     * Returns all categories of usability guidelines
     */
    List<String> findAllCategoriesOfUsabilityGuidelines();

    /**
     * @param category Category of usability guidelines (e.g. MobileUsability)
     * @return All usability guidelines of certain category
     */
    List<UsabilityGuideline> findUsabilityGuidelinesByCategory(String category);

    /**
     * @param nameOfGuideline The unique name of usability guidelines
     * @return Usability guideline
     */
    UsabilityGuideline retrieveUsabilityGuidelineByName(String nameOfGuideline);
}
