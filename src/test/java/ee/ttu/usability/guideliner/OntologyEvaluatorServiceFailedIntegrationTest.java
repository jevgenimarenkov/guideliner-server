package ee.ttu.usability.guideliner;


import ee.ttu.usability.guideliner.service.impl.OntologyEvaluatorService;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import ee.ttu.usability.guideliner.util.Screenshoter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

import java.io.File;
import java.io.IOException;

@Ignore
public class OntologyEvaluatorServiceFailedIntegrationTest extends OntologyEvaluatorServiceAbstractIntegrationTest {

    private static final String URL = "file:///C:/Users/jevgeni.marenkov/Desktop/yli/ontologyRepository/project/ontologyRepository-test-client/incorrect/index.html";

    @Autowired
    private OntologyEvaluatorService ontologyEvaluatorService;

    Screenshoter screenshoter;

    @Before
    public void setUp() throws IOException {
        screenshoter = Mockito.mock(Screenshoter.class);
        Mockito.doReturn(null).when(screenshoter).makeScreenshot(Mockito.<WebDriver>any());
        Mockito.doReturn(new File("test")).when(screenshoter).takeScreenshot(Mockito.any(), Mockito.any(), Mockito.any());
    }


//    @Test
//    public void test10_11_UseAppropriateTextLinkLengths() {
//        // given
//        String guideline = "10-11_UseAppropriateTextLinkLengths";
//
//        // when
//        EvaluationResult evaluationResult = ontologyEvaluatorService.evaluateByName(guideline, URL);
//
//        // then
//        Assert.assertEquals(ResultType.FAIL, evaluationResult.getResult());
//        Assert.assertEquals(1, evaluationResult.getFailedElements().size());
//        Assert.assertEquals(ElementType.LINK.name(), evaluationResult.getFailedElements().get(0).getType());
//        Assert.assertEquals("Amount of WORD was 36", evaluationResult.getFailedElements().get(0).getDescription());
//    }

}
