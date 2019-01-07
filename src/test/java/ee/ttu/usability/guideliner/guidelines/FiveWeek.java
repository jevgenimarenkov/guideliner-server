package ee.ttu.usability.guideliner.guidelines;

import core.AbstractTest;
import ee.ttu.usability.guideliner.domain.dataproperty.DistanceType;
import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import ee.ttu.usability.guideliner.domain.element.form.CheckBox;
import ee.ttu.usability.guideliner.domain.element.form.Input;
import ee.ttu.usability.guideliner.domain.element.form.Radio;
import ee.ttu.usability.guideliner.domain.element.form.Select;
import ee.ttu.usability.guideliner.domain.page.LayoutType;
import ee.ttu.usability.guideliner.domain.page.UIPage;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.repository.OntologyRepository;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class FiveWeek extends AbstractTest {

    @BeforeClass
    public static void setUp() throws OWLOntologyCreationException {
        setUpClasses();
    }

    @Test
    public void test36_01_InputsShouldBeVerticallyStacked() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("36-01_InputsShouldBeVerticallyStacked");

        // when
        Input guidelineElement = (Input) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLayout());
        Assert.assertEquals(LayoutType.VERTICAL, guidelineElement.getLayout().getLayoutType());
    }

    //
    @Test
    public void test33_01_DistanceBetweenInputsShouldBeEnough() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("33-01_DistanceBetweenInputsShouldBeEnough");

        // when
        Input guidelineElement = (Input) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getDistance());
        Assert.assertEquals(new Integer(40), guidelineElement.getDistance().getContentLength());
        Assert.assertEquals(Unit.PIXCEL, guidelineElement.getDistance().getUnit());
        Assert.assertEquals(DistanceType.CLICKABLEELEMENT, guidelineElement.getDistance().getDistanceType());
    }


    @Test
    public void test35_01_InputShouldBeHeightEnough() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("35-01_InputShouldBeHeightEnough");

        // when
        Input guidelineElement = (Input) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHeight());
        Assert.assertEquals(new Integer(25), guidelineElement.getHeight().getContentLength());
        Assert.assertEquals(Unit.PIXCEL, guidelineElement.getHeight().getUnit());
    }

    @Test
    public void test34_01_InputShouldBeWideEnough() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("34-01_InputShouldBeWideEnough");

        // when
        Input guidelineElement = (Input) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getWidth());
        Assert.assertEquals(new Integer(60), guidelineElement.getWidth().getContentLength());
        Assert.assertEquals(Unit.PIXCEL, guidelineElement.getWidth().getUnit());
    }

//
    @Test
    public void test26_CheckboxShouldContainMoreThanOneOption() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("26_CheckboxShouldContainMoreThanOneOption");

        // when
        CheckBox guidelineElement = (CheckBox) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNull(guidelineElement.getContentLength());
        Assert.assertEquals(new Integer(1), guidelineElement.getMinNumberOfInputs());
        Assert.assertEquals(Unit.ELEMENT, guidelineElement.getUnit());
    }

    @Test
    public void test27_CheckboxShouldNotContainMoreThanTenOptions() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("27_CheckboxShouldNotContainMoreThanTenOptions");

        // when
        CheckBox guidelineElement = (CheckBox) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNull(guidelineElement.getContentLength());
        Assert.assertEquals(new Integer(10), guidelineElement.getMaxNumberOfInputs());
        Assert.assertEquals(Unit.ELEMENT, guidelineElement.getUnit());
    }

    @Test
    public void test28_RadioButtonShouldNotContainMoreThanSevenOptions() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("28_RadioButtonShouldNotContainMoreThanSevenOptions");

        // when
        Radio guidelineElement = (Radio) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNull(guidelineElement.getContentLength());
        Assert.assertEquals(new Integer(7), guidelineElement.getMaxNumberOfInputs());
        Assert.assertEquals(Unit.ELEMENT, guidelineElement.getUnit());
    }

    @Test
    public void test29_RadioShouldContainMoreThanOneOption() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("29_RadioShouldContainMoreThanOneOption");

        // when
        Radio guidelineElement = (Radio) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNull(guidelineElement.getContentLength());
        Assert.assertEquals(new Integer(1), guidelineElement.getMinNumberOfInputs());
        Assert.assertEquals(Unit.ELEMENT, guidelineElement.getUnit());
    }

//
    @Test
    public void test30_SelectListShouldContainMoreThenFiveOptions() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("30_SelectListShouldContainMoreThenFiveOptions");

        // when
        Select guidelineElement = (Select) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNull(guidelineElement.getContentLength());
        Assert.assertEquals(new Integer(5), guidelineElement.getMinNumberOfInputs());
        Assert.assertEquals(Unit.ELEMENT, guidelineElement.getUnit());
    }

    @Test
    public void test38_01_PageHeightShouldBeDefined() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("38-01_PageHeightShouldBeDefined");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHeight());
        Assert.assertEquals(new Integer(3000), guidelineElement.getHeight().getContentLength());
        Assert.assertNotNull(guidelineElement.getHeight().getUnit());
    }

    @Test
    public void test() {
        OntologyRepository.reasoner.getSubClasses(ontologyRepository.loadClass("TEST_GuidelinesConcernedOnlyWithLinks"))
                .entities()
                .filter(c -> !c.getIRI().getShortForm().equals("Nothing"))
                .forEach(c -> {
                    System.out.println(c.getIRI().getIRIString());
               });

    }
//
//
//
//

}
