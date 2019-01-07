package ee.ttu.usability.guideliner.guidelines;

import core.AbstractTest;
import ee.ttu.usability.guideliner.domain.element.form.*;
import ee.ttu.usability.guideliner.domain.page.UIPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class SecondWeek extends AbstractTest {

    @BeforeClass
    public static void setUp() throws OWLOntologyCreationException {
        setUpClasses();
    }

    // NEW GUIDELINES (TO TEST)
    @Test
    public void test46wcag_1_1_TextareaInputShouldNotContainEmptyLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("46wcag-1-1_TextareaInputShouldNotContainEmptyLabel");

        // when
        TextArea guidelineElement = (TextArea) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertNull(guidelineElement.getLabel().getIsValued());
		Assert.assertTrue(guidelineElement.getLabel().getHasText());
    }

    @Test
    public void test45wcag_1_1_SelectInputShouldNotContainEmptyLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("45wcag-1-1_SelectInputShouldNotContainEmptyLabel");

        // when
        Select guidelineElement = (Select) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertNull(guidelineElement.getLabel().getIsValued());
        Assert.assertTrue(guidelineElement.getLabel().getHasText());
    }

    @Test
    public void test44wcag_1_1_FileInputShouldNotContainEmptyLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("44wcag-1-1_FileInputShouldNotContainEmptyLabel");

        // when
        File guidelineElement = (File) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertNull(guidelineElement.getLabel().getIsValued());
        Assert.assertTrue(guidelineElement.getLabel().getHasText());
    }

    @Test
    public void test43wcag_1_1_TextInputShouldNotContainEmptyLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("43wcag-1-1_TextInputShouldNotContainEmptyLabel");

        // when
        Text guidelineElement = (Text) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertNull(guidelineElement.getLabel().getIsValued());
        Assert.assertTrue(guidelineElement.getLabel().getHasText());
    }

    //

    @Test
    public void test42wcag_1_1_CheckboxInputShouldNotContainEmptyLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("42wcag-1-1_CheckboxInputShouldNotContainEmptyLabel");

        // when
        CheckBox guidelineElement = (CheckBox) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertNull(guidelineElement.getLabel().getIsValued());
        Assert.assertTrue(guidelineElement.getLabel().getHasText());
    }

    //

    @Test
    public void test41wcag_1_1_PasswordInputShouldNotContainEmptyLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("41wcag-1-1_PasswordInputShouldNotContainEmptyLabel");

        // when
        Password guidelineElement = (Password) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertNull(guidelineElement.getLabel().getIsValued());
        Assert.assertTrue(guidelineElement.getLabel().getHasText());
    }

    @Test
    public void test40wcag_1_1_RadioInputShouldHaveNotContainEmptyLabel() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("40wcag-1-1_RadioInputShouldHaveNotContainEmptyLabel");

        // when
        Radio guidelineElement = (Radio) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getLabel());
        Assert.assertNull(guidelineElement.getLabel().getIsValued());
        Assert.assertTrue(guidelineElement.getLabel().getHasText());
    }

    @Test
    public void test50wcag_1_1_Heading1ShouldBeFollowedByMaxH2() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("50wcag-1-1_Heading1ShouldBeFollowedByMaxH2");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getH1());
        Assert.assertNotNull(guidelineElement.getHtml().getH1().getFollowedByElements());
        Assert.assertEquals("h1", guidelineElement.getHtml().getH1().getFollowedByElements().get(0));
        Assert.assertEquals("h2", guidelineElement.getHtml().getH1().getFollowedByElements().get(1));
    }

    @Test
    public void test50wcag_1_1_Heading2ShouldBeFollowedByMaxH3() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("50wcag-1-1_Heading2ShouldBeFollowedByMaxH3");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getH2());
        Assert.assertNotNull(guidelineElement.getHtml().getH2().getFollowedByElements());
        Assert.assertEquals("h1", guidelineElement.getHtml().getH2().getFollowedByElements().get(0));
        Assert.assertEquals("h2", guidelineElement.getHtml().getH2().getFollowedByElements().get(1));
        Assert.assertEquals("h3", guidelineElement.getHtml().getH2().getFollowedByElements().get(2));
    }


    @Test
    public void test50wcag_1_1_Heading3ShouldBeFollowedByMaxH4() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("50wcag-1-1_Heading3ShouldBeFollowedByMaxH4");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getH3());
        Assert.assertNotNull(guidelineElement.getHtml().getH3().getFollowedByElements());
        Assert.assertEquals("h1", guidelineElement.getHtml().getH3().getFollowedByElements().get(0));
        Assert.assertEquals("h2", guidelineElement.getHtml().getH3().getFollowedByElements().get(1));
        Assert.assertEquals("h3", guidelineElement.getHtml().getH3().getFollowedByElements().get(2));
        Assert.assertEquals("h4", guidelineElement.getHtml().getH3().getFollowedByElements().get(3));
    }

    @Test
    public void test50wcag_1_1_Heading4ShouldBeFollowedByMaxH5() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("50wcag-1-1_Heading4ShouldBeFollowedByMaxH5");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getH4());
        Assert.assertNotNull(guidelineElement.getHtml().getH4().getFollowedByElements());
        Assert.assertEquals("h1", guidelineElement.getHtml().getH4().getFollowedByElements().get(0));
        Assert.assertEquals("h2", guidelineElement.getHtml().getH4().getFollowedByElements().get(1));
        Assert.assertEquals("h3", guidelineElement.getHtml().getH4().getFollowedByElements().get(2));
        Assert.assertEquals("h4", guidelineElement.getHtml().getH4().getFollowedByElements().get(3));
        Assert.assertEquals("h5", guidelineElement.getHtml().getH4().getFollowedByElements().get(4));
    }

    @Test
    public void test50wcag_1_1_Heading5ShouldBeFollowedByMaxH6() {
        // given
        OWLClass guideline = ontologyRepository.loadClass("50wcag-1-1_Heading5ShouldBeFollowedByMaxH6");

        // when
        UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

        // then
        Assert.assertNotNull(guidelineElement);
        Assert.assertNotNull(guidelineElement.getHtml());
        Assert.assertNotNull(guidelineElement.getHtml().getH5());
        Assert.assertNotNull(guidelineElement.getHtml().getH5().getFollowedByElements());
        Assert.assertEquals("h1", guidelineElement.getHtml().getH5().getFollowedByElements().get(0));
        Assert.assertEquals("h2", guidelineElement.getHtml().getH5().getFollowedByElements().get(1));
        Assert.assertEquals("h3", guidelineElement.getHtml().getH5().getFollowedByElements().get(2));
        Assert.assertEquals("h4", guidelineElement.getHtml().getH5().getFollowedByElements().get(3));
        Assert.assertEquals("h5", guidelineElement.getHtml().getH5().getFollowedByElements().get(4));
        Assert.assertEquals("h6", guidelineElement.getHtml().getH5().getFollowedByElements().get(5));
    }


}


