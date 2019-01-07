package jenkins;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import ee.ttu.usability.guideliner.service.impl.OntologyEvaluatorService;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.FailedElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jevgeni.marenkov on 7/6/2017.
 */
public class AbstractUsabilityGuidelineTest {

    @Autowired
    protected OntologyEvaluatorService ontologyEvaluatorService;

    protected void assertEvaluationResult(List<EvaluationResult> results) {
        for (EvaluationResult result : results) {
            Assert.assertEquals(null, verifyEvaluationResults(result));
        }
    }

    protected void assertEvaluationResult(EvaluationResult results) {

    }


    protected String verifyEvaluationResults(EvaluationResult result) {
        if (CollectionUtils.isEmpty(result.getFailedElements())) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int problemNr = 0;

        List<String> elements = new ArrayList<>();
        for (FailedElement failedElement : result.getFailedElements()) {
            String element =
                    "Problem: " + (++problemNr) + "\n" +
                            "Text: " + failedElement.getText() + "\n" +
                            "Description: " + failedElement.getDescription() + "\n" +
                            "Type: " + failedElement.getType();
            stringBuilder.append(element + "\n");
        }

        return stringBuilder.toString();
    }
}
