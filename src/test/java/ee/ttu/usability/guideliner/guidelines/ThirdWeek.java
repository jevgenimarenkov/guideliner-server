package ee.ttu.usability.guideliner.guidelines;

import core.AbstractTest;
import ee.ttu.usability.guideliner.domain.element.form.CheckBox;
import ee.ttu.usability.guideliner.domain.element.form.Radio;
import ee.ttu.usability.guideliner.domain.element.link.Frame;
import ee.ttu.usability.guideliner.domain.element.link.Link;
import ee.ttu.usability.guideliner.domain.page.UIPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;


public class ThirdWeek extends AbstractTest {

    @BeforeClass
    public static void setUp() throws OWLOntologyCreationException {
        setUpClasses();
    }

    @Test
    public void test60wcag_1_1_RadioShouldBeAfterFielset() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("60wcag-1-1_RadioShouldBeAfterFielset");

        // when
        Radio guidelineElement = (Radio) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getPrecededElements());
        Assert.assertEquals("fieldset", guidelineElement.getPrecededElements().get(0));
    }

    @Test
    public void test60wcag_1_1_CheckboxShouldBeAfterFielset() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("60wcag-1-1_CheckboxShouldBeAfterFielset");

        // when
        CheckBox guidelineElement = (CheckBox) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getPrecededElements());
        Assert.assertEquals("fieldset", guidelineElement.getPrecededElements().get(0));
    }

    @Test
    public void test64wcag_1_1_MarqueeTagIsNotAllowed() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("64wcag-1-1_MarqueeTagIsNotAllowed");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getMarquee());
        Assert.assertFalse(guidelineElement.getHtml().getMarquee().getIsValued());
    }

    @Test
    public void test63wcag_1_1_BlinkTagIsNotAllowed() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("63wcag-1-1_BlinkTagIsNotAllowed");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getBlink());
        Assert.assertFalse(guidelineElement.getHtml().getBlink().getIsValued());
    }


    @Test
    public void test70wcag_1_1_IdShouldBeUnique() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("70wcag-1-1_IdShouldBeUnique");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getId());
        Assert.assertTrue(guidelineElement.getHtml().getId().getIsUnique());
    }


    @Test
    public void test76wcag_8_10_CheckOnMouseOverIsUsedWithOnFocus() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("76wcag-8-10_CheckOnMouseOverIsUsedWithOnFocus");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getOnMouseOver());
        Assert.assertTrue(guidelineElement.getOnMouseOver().getIsValued());
        Assert.assertNotNull(guidelineElement.getOnFocus());
        Assert.assertTrue(guidelineElement.getOnFocus().getIsValued());
    }

    @Test
    public void test75wcag_8_10_CheckOnMouseOutIsUsedWithOnBlur() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("75wcag-8-10_CheckOnMouseOutIsUsedWithOnBlur");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getOnMouseOut());
        Assert.assertTrue(guidelineElement.getOnMouseOut().getIsValued());
        Assert.assertNotNull(guidelineElement.getOnblur());
        Assert.assertTrue(guidelineElement.getOnblur().getIsValued());
    }

    @Test
    public void test74wcag_8_10_CheckOnMouseDownIsUsedWithOnKeyDown() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("74wcag-8-10_CheckOnMouseDownIsUsedWithOnKeyDown");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getOnMouseDown());
        Assert.assertTrue(guidelineElement.getOnMouseDown().getIsValued());
        Assert.assertNotNull(guidelineElement.getOnKeyDown());
        Assert.assertTrue(guidelineElement.getOnKeyDown().getIsValued());
    }


    @Test
    public void test65wcag_1_1_FrameHasTitleDefined() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("65wcag-1-1_FrameHasTitleDefined");

        // when
        Frame guidelineElement = (Frame) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getTitle());
        Assert.assertNotNull(guidelineElement.getTitle().getIsValued());
    }

    @Test
    public void test70wcag_1_1_LinkTextShouldBeDefined() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("70wcag-1-1_LinkTextShouldBeDefined");

        // when
        Link guidelineElement = (Link) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertTrue(guidelineElement.getHasText());
    }

}
