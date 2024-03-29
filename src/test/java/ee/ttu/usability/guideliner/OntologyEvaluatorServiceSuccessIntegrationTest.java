package ee.ttu.usability.guideliner;

import ee.ttu.usability.guideliner.service.impl.OntologyEvaluatorService;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestContextManager;

@Ignore
public class OntologyEvaluatorServiceSuccessIntegrationTest extends OntologyEvaluatorServiceAbstractIntegrationTest {

    private static final String URL = "file:///C:/Users/jevgeni.marenkov/Desktop/yli/ontologyRepository/project/ontologyRepository-test-client/correct/index.html";

    @Autowired
    private OntologyEvaluatorService ontologyEvaluatorService;

    WebDriver driver;
    @Before
    public void configureDriver() throws Exception {
        driver = ontologyEvaluatorService.initialiseDriverIfNotInitialised(URL, driver);
    }

    @Test
    public void test10_11_UseAppropriateTextLinkLengths() {
        // given
        String guideline = "10-11_UseAppropriateTextLinkLengths";
        
        // when
        EvaluationResult evaluationResult = ontologyEvaluatorService.evaluateByName(guideline, URL, driver);

        // then
        Assert.assertEquals(ResultType.SUCCESS, evaluationResult.getResult());
        Assert.assertEquals(0, evaluationResult.getFailedElements().size());
    }

    @Test
    public void test() {
        // given
        String guideline = "14-09_LimitTheUseOfImages";

        // when
        EvaluationResult evaluationResult = ontologyEvaluatorService.evaluateByName(guideline, "https://www.etis.ee/", driver);

        // then
        System.out.println(evaluationResult.toString());
        System.out.println(evaluationResult.getFailedElements().size());
    }

}
