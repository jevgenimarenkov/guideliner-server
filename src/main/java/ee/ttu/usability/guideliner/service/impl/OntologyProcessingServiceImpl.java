package ee.ttu.usability.guideliner.service.impl;

import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import ee.ttu.usability.guideliner.service.OntologyProcessingService;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.util.List;

/**
 * Created by jevgeni.marenkov on 6/21/2017.
 */
public class OntologyProcessingServiceImpl implements OntologyProcessingService {
    @Override
    public void reloadOntology() throws OWLOntologyCreationException {
        reloadOntology();
    }

    @Override
    public List<String> findAllCategoriesOfUsabilityGuidelines() {
        return null;
    }

    @Override
    public List<UsabilityGuideline> findUsabilityGuidelinesByCategory(String category) {
        return findUsabilityGuidelinesByCategory(category);
    }

    @Override
    public UsabilityGuideline retrieveUsabilityGuidelineByName(String nameOfGuideline) {
        return retrieveUsabilityGuidelineByName(nameOfGuideline);
    }
}
