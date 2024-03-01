package ee.ttu.usability.guideliner.guidelines;

import core.AbstractTest;
import ee.ttu.usability.guideliner.domain.dataproperty.DistanceType;
import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import ee.ttu.usability.guideliner.domain.element.content.Paragraph;
import ee.ttu.usability.guideliner.domain.element.form.*;
import ee.ttu.usability.guideliner.domain.element.link.*;
import ee.ttu.usability.guideliner.domain.element.navigation.Navigation;
import ee.ttu.usability.guideliner.domain.page.LayoutType;
import ee.ttu.usability.guideliner.domain.page.UIPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class OntologyEvaluatorServiceIntegrationTest extends AbstractTest {

	@BeforeClass
	public static void setUp() throws OWLOntologyCreationException {
		setUpClasses();
	}

	@Test
	public void testThatAnnotationsAreExtractedSuccessfullyFromGuidelines() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("03-03_LinksShouldHaveProperContrastRate");

		// when
		String comment = ontologyRepository.getAnnotationValueByAnnotationName(guideline, "comment");
		String guide = ontologyRepository.getAnnotationValueByAnnotationName(guideline, "guideline");
	
		// then
		Assert.assertNotNull(comment);
		Assert.assertNotNull(guide);
	}
	
	@Test
	public void testThatConstructionWorksForRule03_03() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("03-03_LinksShouldHaveProperContrastRate");

		// when
		Link guidelineElement = (Link) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement.getContrast());
		Assert.assertNotNull(guidelineElement.getContrast().getContrast());
	}
	
	@Test
	public void testThatConstructionWorksForRule05_07() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("05-07_LimitHomePageLength");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement.getContentLength());
		Assert.assertNotNull(guidelineElement.getUnit());
	}
	
	@Test
	public void testThatConstructionWorksForRule11_01() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("11-01_UseBlackTextonPlainHighContrastBackgrounds");
		
		// when
		Paragraph guidelineElement = (Paragraph) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement.getContrast());
		Assert.assertNotNull(guidelineElement.getContrast().getContrast());
	}
	
	@Test
	public void testThatConstructionWorksForRule10_11() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("10-11_UseAppropriateTextLinkLengths");
		
		// when
		Link guidelineElement = (Link) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement.getUnit());
		Assert.assertNotNull(guidelineElement.getContentLength());
		Assert.assertEquals(guidelineElement.getUnit(), Unit.WORD);
	}
	
	@Test
	public void testThatConstructionWorksForRule08_01() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("08-01_EliminateHorizontalScrolling");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		System.out.println(guidelineElement.getHorizontalScroll().getValue());
	}
	
	@Test
	public void testThatConstructionWorksForRule03_02() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("03-02_FormInputsShouldHaveLabels");
		
		// when
		Form guidelineElement = (Form) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getLabel());
		Assert.assertTrue(guidelineElement.getLabel().getIsValued());
	}
	
	@Test
	public void testThatConstructionWorksForRule14_09() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("14-09_LimitTheUseOfImages");
		
		// when
		Graphic guidelineElement = (Graphic) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getContentLength());
		Assert.assertEquals(guidelineElement.getUnit(), Unit.KBYTE);
	}
	
	@Test
	public void testThatConstructionWorksForRule15_07() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("15-07_LimitTheNumberOfWordsAndSentences");
		
		// when
		Paragraph guidelineElement = (Paragraph) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getContentLength());
		Assert.assertEquals(guidelineElement.getUnit(), Unit.WORDS_IN_SENTENCE);
	}
	
	@Test
	public void testThatConstructionWorksForRule16_05() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("16-05_NavigationShouldBeVisibleWithoutScrolling");
		
		// when
		Navigation guidelineElement = (Navigation) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getId());
		Assert.assertNotNull(guidelineElement.getHorizontalScroll());
		Assert.assertNotNull(guidelineElement.getHorizontalScroll().getValue());
		Assert.assertNotNull(guidelineElement.getId().getValue());
	}
	
	@Test
	public void testThatConstructionWorksForRule03_05() {
		// given
		OWLClass guideline = ontologyRepository
				.loadClass("03-05_ProvideTextEquivalentsForNonTextElements");
		
		// when
		Multimedia guidelineElement = (Multimedia) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getAlternativeText());
		Assert.assertTrue(guidelineElement.getAlternativeText().getIsValued());
	}
	
	@Test
	public void testThatConstructionWorksForRule06_10() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("06-10_SetAppropriatePageLengths");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getHeight());
		Assert.assertNotNull(guidelineElement.getHeight().getContentLength());
		Assert.assertNotNull(guidelineElement.getHeight().getUnit());
	}

	@Test
	public void testThatConstructionWorksForRule06_08() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("06-08_UseFluidLayouts");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getLayout());
		Assert.assertNotNull(guidelineElement.getLayout().getLayoutType());
	}
	
	@Test
	public void testThatConstructionWorksForRule07_08() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("07-08_VerticalScrollingIsNotAllowed");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getVerticalScroll());
		Assert.assertNotNull(guidelineElement.getVerticalScroll().getValue());
	}

	@Test
	public void testThatConstructionWorksForRule03_09() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("03-09_ProvideClientSideImageMaps");
		
		// when
		Button guidelineElement = (Button) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getAlternativeText());
	}
	
	@Test
	public void testThatConstructionWorksForRule04_04() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("04-04_PageShouldBeLoadedQuickly");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getLoadTime());
		Assert.assertNotNull(guidelineElement.getLoadTime().getValue());
		Assert.assertNotNull(guidelineElement.getLoadTime().getUnit());
	}

	@Test
	public void testThatConstructionWorksForRule05_03() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("05-03_DoNotUsedProhibitedGeneralPurposeWords");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getProhibitedWords());
		Assert.assertNotNull(guidelineElement.getProhibitedWords().getValue());
	}

	@Test
	public void testThatConstructionWorksForRule05_06() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("05-06_EnsureThatNumberedListsContainMoreThenOneElement");

		// when
		NumberedList guidelineElement = (NumberedList) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getContentLength());
		Assert.assertNotNull(guidelineElement.getUnit());
	}

	@Test
	public void testThatConstructionWorksForRule08_04() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("08-04_NumberOfWordsInParagraphShouldBeLimited");
		
		// when
		Paragraph guidelineElement = (Paragraph) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getContentLength());
		Assert.assertNotNull(guidelineElement.getUnit());
	}
	
	@Test
	public void testThatConstructionWorksForRule11_05() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("11-05_UseBoldTextSparingly");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getText());
		Assert.assertNotNull(guidelineElement.getText().getCaseType());
		Assert.assertNotNull(guidelineElement.getText().getContentLength());
	}

	// TODO implement
	@Test
	public void test1wcag_8_01_CheckHtmlStyle() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("1wcag-8-01_CheckHtmlStyle");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getHtml());
		Assert.assertNotNull(guidelineElement.getHtml().isValid());
	}

	@Test
	public void test1wcag_8_10_CheckOnClickIsUsedWithOnKeyDown() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("1wcag-8-10_CheckOnClickIsUsedWithOnKeyDown");
		
		// when
		Button guidelineElement = (Button) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getOnKeyPress());
		Assert.assertNotNull(guidelineElement.getOnClick());
	}
	
	@Test
	public void test3wcag_8_15_CheckThatPageHasLinkToFrontPage() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("3wcag-8-15_CheckThatPageDoesNotHaveLinkToItself");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getHref());
		Assert.assertNotNull(guidelineElement.getHref().getValue());
	}
	
	@Test
	public void test4wcag_8_16_CheckThatEveryPageHasTitle() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("4wcag-8-16_CheckThatEveryPageHasTitle");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getTitle());
		Assert.assertNotNull(guidelineElement.getTitle().getIsValued());
	}
	
	@Test
	public void test5wcag_8_19_CheckThatLanguageIsIncludedToHtmlTag() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("5wcag-8-19_CheckThatLanguageIsIncludedToHtmlTag");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getHtml());
		Assert.assertNotNull(guidelineElement.getHtml().getLang());
		Assert.assertNotNull(guidelineElement.getHtml().getLang().getIsValued());
	}

	@Test
	public void test6wcag_1_1_AreaShouldHaveAltAttribute() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("6wcag-1-1_AreaShouldHaveAltAttribute");
		
		// when
		Area guidelineElement = (Area) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getAlternativeText());
		Assert.assertNotNull(guidelineElement.getAlternativeText().getIsValued());
	}
	
	@Test
	public void test7wcag_1_1_ImageShouldHaveAltAttribute() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("7wcag-1-1_ImageShouldHaveAltAttribute");
		
		// when
		Graphic guidelineElement = (Graphic) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getAlternativeText());
		Assert.assertNotNull(guidelineElement.getAlternativeText().getIsValued());
	}

	@Test
	public void test8wcag_1_1_AlternativeTextShouldNotHaveProhibitedWords() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("8wcag-1-1_AlternativeTextShouldNotHaveProhibitedWords");
		
		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getHtml());
		Assert.assertNotNull(guidelineElement.getHtml().getAlternativeText());
		Assert.assertNotNull(guidelineElement.getHtml().getAlternativeText().getProhibitedWords());
		Assert.assertNotNull(guidelineElement.getHtml().getAlternativeText().getProhibitedWords().getValue());
	}

	@Test
	public void test11wcag_1_1_LinkAltTextShouldBeDifferentFromText() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("11wcag-1-1_LinkAltTextShouldBeDifferentFromText");
		
		// when
		Link guidelineElement = (Link) ontologyEvaluatorService.fillGuidelines(guideline);
		
		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getAlternativeText());
		Assert.assertNotNull(guidelineElement.getAlternativeText().getProhibitedWords());
		Assert.assertNotNull(guidelineElement.getAlternativeText().getProhibitedWords().getUnit());
		Assert.assertNotNull(guidelineElement.getAlternativeText().getProhibitedWords().getUnitAction());
	}

	@Test
	public void test9wcag_1_1_TextShouldNotContainMultipleSpace() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("9wcag-1-1_TextShouldNotContainMultipleSpace");

		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getText());
		Assert.assertNotNull(guidelineElement.getText().getUnit());
		Assert.assertNotNull(guidelineElement.getText().getContentLength());
	}


	@Test
	public void test17_01_PlaceLabelsAboveTheInput() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("17-PlaceLabelsAboveTheInput");

		// when
		FormElementLabel guidelineElement = (FormElementLabel) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getPositionType());
		Assert.assertEquals(PositionType.ABOVE, guidelineElement.getPositionType());
	}

	@Test
	public void test18_01_ScrollIsOneDirectional() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("18-01_ScrollIsOneDirectional");

		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getScroll());
		Assert.assertEquals(true, guidelineElement.getScroll().getIsOneDirectional());
	}

	@Test
	public void test19_01_LinkShouldBeWideEnough() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("19-01_LinkShouldBeWideEnough");

		// when
		Link guidelineElement = (Link) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getWidth());
		Assert.assertEquals(new Integer(48), guidelineElement.getWidth().getContentLength());
		Assert.assertEquals(Unit.PIXCEL, guidelineElement.getWidth().getUnit());
	}


	@Test
	public void test20_01_LinkShouldBeHeighEnough() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("20-01_LinkShouldBeHeighEnough");

		// when
		Link guidelineElement = (Link) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getHeight());
		Assert.assertEquals(new Integer(48), guidelineElement.getHeight().getContentLength());
		Assert.assertEquals(Unit.PIXCEL, guidelineElement.getHeight().getUnit());
	}

	@Test
	public void test21_01_DistanceBetweenLinksShouldBeEnough() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("21-01_DistanceBetweenLinksShouldBeEnough");

		// when
		Link guidelineElement = (Link) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getDistance());
		Assert.assertEquals(new Integer(48), guidelineElement.getDistance().getContentLength());
		Assert.assertEquals(Unit.PIXCEL, guidelineElement.getDistance().getUnit());
		Assert.assertEquals(DistanceType.CLICKABLEELEMENT, guidelineElement.getDistance().getDistanceType());
	}

	@Test
	public void test22_01_UseSameColorSchemaWithinAllLinks() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("22-01_UseSameColorSchemaWithinAllLinks");

		// when
		Link guidelineElement = (Link) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getColor());
		Assert.assertTrue(guidelineElement.getColor().getIsSame());
	}

	@Test
	public void test24_01_IdentifySelectedInput() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("24-01_IdentifySelectedInput");

		// when
		Input guidelineElement = (Input) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getColor());
		Assert.assertFalse(guidelineElement.getColor().getIsSame());
		Assert.assertTrue(guidelineElement.getIsSelected());
	}

	@Test
	public void test25_01_ViewportShouldBeConfigured() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("25-01_ViewportShouldBeConfigured");

		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getHtml());
		Assert.assertNotNull(guidelineElement.getHtml().getViewport());
		Assert.assertTrue(guidelineElement.getHtml().getViewport().getIsValued());
	}

	@Test
	public void test26_01_DoNotUseIncompatiblePlugins() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("26-01_DoNotUseIncompatiblePlugins");

		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getHtml());
		Assert.assertNotNull(guidelineElement.getHtml().getFlash());
		Assert.assertTrue(guidelineElement.getHtml().getFlash().getIsValued());
	}

	@Test
	public void test27_01_RadioButtonsShouldBeVerticallyStacked() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("27-01_RadioButtonsShouldBeVerticallyStacked");

		// when
		Radio guidelineElement = (Radio) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getLayout());
		Assert.assertEquals(LayoutType.VERTICAL, guidelineElement.getLayout().getLayoutType());
		Assert.assertEquals(LayoutType.VERTICAL, guidelineElement.getLayout().getLayoutType());
	}

	@Test
	public void test28_01_ButtonShouldBeWideEnough() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("28-ButtonShouldBeWideEnough");

		// when
		Button guidelineElement = (Button) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getWidth());
		Assert.assertEquals(new Integer(48), guidelineElement.getWidth().getContentLength());
		Assert.assertEquals(Unit.PIXCEL, guidelineElement.getWidth().getUnit());
	}

	@Test
	public void test29_01_ButtonShouldBeHeighEnough() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("29-01_ButtonShouldBeHeighEnough");

		// when
		Button guidelineElement = (Button) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getHeight());
		Assert.assertEquals(new Integer(48), guidelineElement.getHeight().getContentLength());
		Assert.assertEquals(Unit.PIXCEL, guidelineElement.getHeight().getUnit());
	}

	@Test
	public void test30_01_DistanceBetweenButtonsShouldBeEnough() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("30-01_DistanceBetweenButtonsShouldBeEnough");

		// when
		Button guidelineElement = (Button) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getDistance());
		Assert.assertEquals(new Integer(48), guidelineElement.getDistance().getContentLength());
		Assert.assertEquals(Unit.PIXCEL, guidelineElement.getDistance().getUnit());
		Assert.assertEquals(DistanceType.CLICKABLEELEMENT, guidelineElement.getDistance().getDistanceType());
	}

	@Test
	public void test31_01_CheckMinimumNumberOfInputs() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("31-01_CheckMinimumNumberOfInputs");

		// when
		UIPage guidelineElement = (UIPage) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getMaxNumberOfInputs());
		Assert.assertEquals(new Integer(5), guidelineElement.getMaxNumberOfInputs());
	}

	@Test
	public void test32_01_CheckButtonsShouldBeVerticallyStacked() {
		// given
		OWLClass guideline = ontologyRepository.loadClass("32-01_CheckButtonsShouldBeVerticallyStacked");

		// when
		CheckBox guidelineElement = (CheckBox) ontologyEvaluatorService.fillGuidelines(guideline);

		// then
		Assert.assertNotNull(guidelineElement);
		Assert.assertNotNull(guidelineElement.getLayout());
		Assert.assertEquals(LayoutType.VERTICAL, guidelineElement.getLayout().getLayoutType());
	}


//	@Test
//	public void testSmth() {
//
//		System.out.println("eeeeee");
//		ontologyService.getAllWcagUsabilityGuidelines();
//
//		ontologyService
//				.getAllWcagUsabilityGuidelines()
//				.forEach(
//						t -> {
//							System.out.println("1.1" + t);
//							NodeSet<OWLClass> superClasses = OntologyRepository.reasoner
//									.getSuperClasses(t, true);
//							superClasses.entities().forEach(g -> {
//								System.out.println("1.2" +g);
//							});
//						});
//
//	}

}
