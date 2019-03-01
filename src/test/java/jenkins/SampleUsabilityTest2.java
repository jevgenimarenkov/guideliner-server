package jenkins;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.test.context.TestContextManager;

public class SampleUsabilityTest2 extends AbstractUsabilityTest {

    @Before
    public void configureDriver() throws Exception {
        if (this.testContextManager == null) {
            this.testContextManager = new TestContextManager(getClass());
            this.testContextManager.prepareTestInstance(this);
        }
//        ontologyEvaluatorService.initialiseDriverIfNotInitialised(URL);
    }

    @After
    public void tearDown() throws Exception {
        ontologyEvaluatorService.closeDriver(driver);
    }
    @DataProvider
    public static Object[][] usabilityGuidelinesTest() {
        return new Object[][]{
                {"50wcag-1-1_Heading1ShouldBeFollowedByMaxH2"},
                {"50wcag-1-1_Heading2ShouldBeFollowedByMaxH3"},
                {"50wcag-1-1_Heading3ShouldBeFollowedByMaxH4"},
                {"50wcag-1-1_Heading4ShouldBeFollowedByMaxH5"},
                {"50wcag-1-1_Heading5ShouldBeFollowedByMaxH6"}
        };
    }

    @Test
    @UseDataProvider("usabilityGuidelinesTest")
    public void testUsabilityGuidelines(String guidelines) {
        // given
        OWLClass guideline = ontologyRepository
                .loadClass(guidelines);

        // when
        EvaluationResult result = ontologyEvaluatorService.evaluate(guideline, null, driver);

        //then
        assertEvaluationResult(result);
    }
}
