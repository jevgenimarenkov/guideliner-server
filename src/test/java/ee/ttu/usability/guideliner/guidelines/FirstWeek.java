package ee.ttu.usability.guideliner.guidelines;

import core.AbstractTest;
import ee.ttu.usability.guideliner.domain.element.form.*;
import ee.ttu.usability.guideliner.domain.page.UIPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class FirstWeek extends AbstractTest {

    @BeforeClass
    public static void setUp() throws OWLOntologyCreationException {
        setUpClasses();
    }

    @Test
    public void test12wcag_1_1_BoldTagIsNotAllowed() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("12wcag-1-1_BoldTagIsNotAllowed");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getBolt());
        Assert.assertFalse(guidelineElement.getHtml().getBolt().getIsValued());
    }

    @Test
    public void test15wcag_1_1_BaseFontTagIsNotAllowed() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("15wcag-1-1_BaseFontTagIsNotAllowed");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getBaseFont());
        Assert.assertFalse(guidelineElement.getHtml().getBaseFont().getIsValued());
    }

    @Test
    public void test13wcag_1_1_ItalicsTagIsNotAllowed() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("13wcag-1-1_ItalicsTagIsNotAllowed");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getItalics());
        Assert.assertFalse(guidelineElement.getHtml().getItalics().getIsValued());
    }

    @Test
    public void test14wcag_1_1_FontTagIsNotAllowed() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("14wcag-1-1_FontTagIsNotAllowed");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getFont());
        Assert.assertFalse(guidelineElement.getHtml().getFont().getIsValued());
    }


    @Test
    public void test16wcag_1_1_PasswordShouldHaveLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("16wcag-1-1_PasswordShouldHaveLabel");

        // when
        Password guidelineElement = (Password) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertTrue(guidelineElement.getLabel().getIsValued());
    }

    @Test
    public void test17wcag_1_1_CheckboxShouldHaveLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("17wcag-1-1_CheckboxShouldHaveLabel");

        // when
        CheckBox guidelineElement = (CheckBox) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertTrue(guidelineElement.getLabel().getIsValued());
    }

    @Test
    public void test18wcag_1_1_FileShouldHaveLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("18wcag-1-1_FileShouldHaveLabel");

        // when
        File guidelineElement = (File) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertTrue(guidelineElement.getLabel().getIsValued());
    }

    @Test
    public void test19wcag_1_1_TextAreaShouldHaveLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("19wcag-1-1_TextAreaShouldHaveLabel");

        // when
        TextArea guidelineElement = (TextArea) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertTrue(guidelineElement.getLabel().getIsValued());
    }

    @Test
    public void test20wcag_1_1_TextShouldHaveLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("20wcag-1-1_TextShouldHaveLabel");

        // when
        Text guidelineElement = (Text) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertTrue(guidelineElement.getLabel().getIsValued());
    }

    @Test
    public void test21wcag_1_1_SelectShouldHaveLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("21wcag-1-1_SelectShouldHaveLabel");

        // when
        Select guidelineElement = (Select) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertTrue(guidelineElement.getLabel().getIsValued());
    }

    @Test
    public void test22wcag_1_1_RadioShouldHaveLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("22wcag-1-1_RadioShouldHaveLabel");

        // when
        Radio guidelineElement = (Radio) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertTrue(guidelineElement.getLabel().getIsValued());
    }

}
