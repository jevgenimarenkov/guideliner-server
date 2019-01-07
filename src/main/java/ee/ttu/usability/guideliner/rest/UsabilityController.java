package ee.ttu.usability.guideliner.rest;

import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.Guideline;
import ee.ttu.usability.guideliner.service.impl.OntologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jevgeni.marenkov
 */
@RestController
@CrossOrigin(maxAge = 3600)
public class UsabilityController {
    
    private OntologyService ontologyService;

    @Autowired
    public UsabilityController(OntologyService ontologyService) {
    	this.ontologyService = ontologyService;
    }

    @RequestMapping("/retrieve")
    public List<Guideline> retrieveAllGuidelines() {	
        return null;
    }

    @RequestMapping("/results")
    public List<EvaluationResult> getAllResults() {	
        return null;
    }

    @RequestMapping("/usability/categories")
    public List<String> getAllCategories() {
        return Arrays.asList("AllGuidelines", "WCAGGuideline", "UsabilityGuideline", "MobileUsabilityGuideline");
    }

    @RequestMapping("/usability/categories/{category}")
    public List<Guideline> getByCategory(@PathVariable("category") String category) {
        return ontologyService.findUsabilityGuidelinesByCategory(category);
    }

    @RequestMapping("/usability/categories2/{category}")
    public List<String> getListByCategory(@PathVariable("category") String category) {
        return ontologyService.findUsabilityGuidelinesByCategory(category).stream().map(Guideline::getCode).collect(Collectors.toList());
    }

}
