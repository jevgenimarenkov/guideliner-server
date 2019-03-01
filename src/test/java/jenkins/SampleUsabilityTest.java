package jenkins;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.test.context.TestContextManager;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

public class SampleUsabilityTest extends AbstractUsabilityTest {

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
    public static Object[][] usabilityGuidelines() {
        return new Object[][]{
                {"08-04_UsePagingRatherThanScrolling"},
                {"29-01_ButtonShouldBeHeighEnough"},
                {"30-01_DistanceBetweenButtonsShouldBeEnough"},
                {"03-03_LinksShouldHaveProperContrastRate"},
                {"10-11_UseAppropriateTextLinkLengths"},
                {"08-01_EliminateHorizontalScrolling"},
                {"1wcag-8-10_CheckOnClickIsUsedWithOnKeyDown"},
                {"27-01_RadioButtonsShouldBeVerticallyStacked"},
                {"30_SelectListShouldContainMoreThenFiveOptions"},
                {"86wcag-1-1_AltTextShouldBeUnique"},
                {"12wcag-1-1_BoldTagIsNotAllowed"}
        };
    }

    @DataProvider
    public static Object[][] usabilityGuidelinesTest() {
        return new Object[][]{
                {"38-01_PageHeightShouldBeDefined"}
        };
    }

    @Test
    @UseDataProvider("usabilityGuidelines")
    public void testUsabilityGuidelines1(String guidelines) {
        // given
        OWLClass guideline = ontologyRepository
                .loadClass(guidelines);

        // when
        EvaluationResult result = ontologyEvaluatorService.evaluate(guideline, "http://www.delfi.ee", driver);

        //then
        assertEvaluationResult(result);
    }

    @Test
    @UseDataProvider("usabilityGuidelines")
    public void testUsabilityGuidelines2(String guidelines) {
        // given
        OWLClass guideline = ontologyRepository
                .loadClass(guidelines);

        // when
        EvaluationResult result = ontologyEvaluatorService.evaluate(guideline, "https://www.nasa.gov/", driver);

        //then
        assertEvaluationResult(result);
    }

    @Test
    @UseDataProvider("usabilityGuidelines")
    public void testUsabilityGuidelines3(String guidelines) {
        // given
        OWLClass guideline = ontologyRepository
                .loadClass(guidelines);

        // when
        EvaluationResult result = ontologyEvaluatorService.evaluate(guideline, "http://edition.cnn.com/", driver);

        //then
        assertEvaluationResult(result);
    }

    @Test
    @UseDataProvider("usabilityGuidelines")
    public void testUsabilityGuidelines4(String guidelines) {
        // given
        OWLClass guideline = ontologyRepository
                .loadClass(guidelines);

        // when
        EvaluationResult result = ontologyEvaluatorService.evaluate(guideline, "https://www.bbc.co.uk/", driver);

        //then
        assertEvaluationResult(result);
    }

    @Test
    @UseDataProvider("usabilityGuidelines")
    public void testUsabilityGuidelines5(String guidelines) {
        // given
        OWLClass guideline = ontologyRepository
                .loadClass(guidelines);

        // when
        EvaluationResult result = ontologyEvaluatorService.evaluate(guideline, "http://www.itk.ee/en", driver);

        //then
        assertEvaluationResult(result);
    }

    @Test
    @UseDataProvider("usabilityGuidelines")
    public void testUsabilityGuidelines6(String guidelines) {
        // given
        OWLClass guideline = ontologyRepository
                .loadClass(guidelines);

        // when
        EvaluationResult result = ontologyEvaluatorService.evaluate(guideline, "http://www.rkas.ee/en", driver);

        //then
        assertEvaluationResult(result);
    }

    @Test
    @UseDataProvider("usabilityGuidelines")
    public void testUsabilityGuidelines7(String guidelines) {
        // given
        OWLClass guideline = ontologyRepository
                .loadClass(guidelines);

        // when
        EvaluationResult result = ontologyEvaluatorService.evaluate(guideline, "https://www.eesti.ee/en/", driver);

        //then
        assertEvaluationResult(result);
    }

    @Test
    @UseDataProvider("usabilityGuidelines")
    public void testUsabilityGuidelines8(String guidelines) {
        // given
        OWLClass guideline = ontologyRepository
                .loadClass(guidelines);

        // when
        EvaluationResult result = ontologyEvaluatorService.evaluate(guideline, "https://www.mnt.ee/eng", driver);

        //then
        assertEvaluationResult(result);
    }
}
