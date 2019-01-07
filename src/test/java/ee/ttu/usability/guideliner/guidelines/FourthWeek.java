package ee.ttu.usability.guideliner.guidelines;

import core.AbstractTest;
import ee.ttu.usability.guideliner.domain.element.link.Applet;
import ee.ttu.usability.guideliner.domain.element.link.Embed;
import ee.ttu.usability.guideliner.domain.element.link.Object;
import ee.ttu.usability.guideliner.domain.element.link.TableHeader;
import ee.ttu.usability.guideliner.domain.page.UIPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;


public class FourthWeek extends AbstractTest {

    @BeforeClass
    public static void setUp() throws OWLOntologyCreationException {
        setUpClasses();
    }

    @Test
    public void test78wcag_8_10_CheckOnKeyPressIsUsedWithOnClick() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("78wcag-8-10_CheckOnKeyPressIsUsedWithOnClick");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getOnKeyPress());
        Assert.assertTrue(guidelineElement.getOnKeyPress().getIsValued());
        Assert.assertNotNull(guidelineElement.getOnClick());
        Assert.assertTrue(guidelineElement.getOnClick().getIsValued());
    }

    @Test
    public void test77wcag_8_10_CheckOnKeyIsUsedWithOnDbClick() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("77wcag-8-10_CheckOnKeyIsUsedWithOnDbClick");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getOnKey());
        Assert.assertTrue(guidelineElement.getOnKey().getIsValued());
        Assert.assertNotNull(guidelineElement.getOnDbClick());
        Assert.assertTrue(guidelineElement.getOnDbClick().getIsValued());
    }

    @Test
    public void test80wcag_ParagraphShouldNotContainLongText() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("80wcag-ParagraphShouldNotContainLongText");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getP());
        Assert.assertNotNull(guidelineElement.getHtml().getP().getContentLength());
        Assert.assertEquals(new Integer(500), guidelineElement.getHtml().getP().getContentLength());
    }

    @Test
    public void test81wcag_DivShouldNotContainLongText() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("81wcag-DivShouldNotContainLongText");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getDiv());
        Assert.assertNotNull(guidelineElement.getHtml().getDiv().getContentLength());
        Assert.assertEquals(new Integer(500), guidelineElement.getHtml().getDiv().getContentLength());
    }

    @Test
    public void test82wcag_TdShouldNotContainLongText() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("82wcag-TdShouldNotContainLongText");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getTd());
        Assert.assertNotNull(guidelineElement.getHtml().getTd().getContentLength());
        Assert.assertEquals(new Integer(500), guidelineElement.getHtml().getTd().getContentLength());
    }

    @Test
    public void test87wcag_1_1_ObjectShouldHaveAltAttribute() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("87wcag-1-1_ObjectShouldHaveAltAttribute");

        // when
        Object guidelineElement = (Object) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getAlternativeText());
        Assert.assertTrue(guidelineElement.getAlternativeText().getIsValued());
    }

    @Test
    public void test88wcag_1_1_AppletShouldHaveAltAttribute() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("88wcag-1-1_AppletShouldHaveAltAttribute");

        // when
        Applet guidelineElement = (Applet) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getAlternativeText());
        Assert.assertTrue(guidelineElement.getAlternativeText().getIsValued());
    }

    @Test
    public void test89wcag_1_1_EmbedShouldHaveAltAttribute() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("89wcag-1-1_EmbedShouldHaveAltAttribute");

        // when
        Embed guidelineElement = (Embed) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getAlternativeText());
        Assert.assertTrue(guidelineElement.getAlternativeText().getIsValued());
    }

    @Test
    public void test85wcag_1_1_ThTextShouldBeDefined() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("85wcag-1-1_ThTextShouldBeDefined");

        // when
        TableHeader guidelineElement = (TableHeader) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertTrue(guidelineElement.getHasText());
    }

    @Test
    public void test86wcag_1_1_AltTextShouldBeUnique() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("86wcag-1-1_AltTextShouldBeUnique");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getAlternativeText());
        Assert.assertTrue(guidelineElement.getHtml().getAlternativeText().getIsUnique());
    }

}
