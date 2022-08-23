package ee.ttu.usability.guideliner.rest;

import ee.ttu.usability.guideliner.Kristi2Repository;
import ee.ttu.usability.guideliner.TestRepository;
import ee.ttu.usability.guideliner.TotalTimeRepository;
import ee.ttu.usability.guideliner.domain.guideline.Category;
import ee.ttu.usability.guideliner.estimation.result.OtherResult;
import ee.ttu.usability.guideliner.estimation.result.TimeUrlEvaluiation;
import ee.ttu.usability.guideliner.repository.OntologyRepository;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.service.impl.OntologyEvaluatorService;
import ee.ttu.usability.guideliner.service.impl.OntologyService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;

@RestController
@CrossOrigin(maxAge = 3600)
public class UsabilityEvaluationController {

    private OntologyEvaluatorService evaluatorService;

    private OntologyRepository ontologyRepository;

    private OntologyService ontologyService;

//    List<String> URLS = Arrays.asList(
//            "29-01_ButtonShouldBeHeighEnough",
//            "30-01_DistanceBetweenButtonsShouldBeEnough",
//            "03-03_LinksShouldHaveProperContrastRate",
//            "10-11_UseAppropriateTextLinkLengths",
//            "08-01_EliminateHorizontalScrolling",
//            "1wcag-8-10_CheckOnClickIsUsedWithOnKeyDown",
//            "27-01_RadioButtonsShouldBeVerticallyStacked",
//            "30_SelectListShouldContainMoreThenFiveOptions",
//            "86wcag-1-1_AltTextShouldBeUnique",
//            "12wcag-1-1_BoldTagIsNotAllowed"
//    );

    List<String> URLS = Arrays.asList(
    "http://web.mit.edu/",
    "http://gradadmissions.mit.edu/",
    "http://student.mit.edu/catalog/archive/fall/extsearch.cgi",
    "https://www.stanford.edu/",
    "https://www.stanford.edu/academics/",
    "https://www.gsb.stanford.edu/faculty-research/centers-initiatives/ces/research/search-funds/primer",
    "https://www.harvard.edu/",
    "https://www.harvard.edu/students",
    "https://connects.catalyst.harvard.edu/profiles/search/people",
    "http://www.caltech.edu/",
    "http://www.caltech.edu/content/undergrad-education",
    "https://directory.caltech.edu/search/advanced_search",
    "https://www.cam.ac.uk/",
    "https://www.undergraduate.study.cam.ac.uk/applying",
    "https://www.student-funding.cam.ac.uk",
    "http://www.ox.ac.uk/",
    "https://www.ox.ac.uk/research/divisions?wssl=1",
    "https://www.ox.ac.uk/funnelback/search?wssl=1",
    "https://www.ucl.ac.uk/",
    "http://www.ucl.ac.uk/research/excellence/funding",
    "https://ucl-primo.hosted.exlibrisgroup.com/primo-explore/search?vid=UCL_VU2&mode=advanced&sortby=rank",
    "https://www.imperial.ac.uk/",
    "http://www.imperial.ac.uk/clinical-trials-unit/collaborations/",
    "http://www.imperial.ac.uk/collegedirectory/",
    "https://www.uchicago.edu/",
    "https://www.uchicago.edu/academics/",
    "https://directory.uchicago.edu/",
    "https://www.ethz.ch/en.html",
    "https://www.ethz.ch/en/doctorate/registration-admission.html",
    "https://wohnen.ethz.ch/index.php?act=searchoffer",
    "https://www.epfl.ch/",
    "https://studying.epfl.ch/student_desk",
    "https://infoscience.epfl.ch/search?ln=en&p=test&f=title&ext=collection%3AARTICLE",
    "https://www.ed.ac.uk/",
    "https://www.ed.ac.uk/staff",
    "https://www.ed.ac.uk/student-funding/search-scholarships?field_study_level_tid=1&term_node_tid_depth=All&term_node_tid_depth_1=All",
    "https://www.kcl.ac.uk/",
    "https://www.kcl.ac.uk/innovation/research/index.aspx",
    "https://www.kcl.ac.uk/study/Search-results.aspx",
    "http://www.lse.ac.uk/",
    "http://www.lse.ac.uk/accounting/Home.aspx",
    "http://www.lse.ac.uk/student-life/accommodation/search-accommodation?from_serp=1",
    "http://www.ens.fr/",
    "http://www.ens.fr/en/academics/admissions",
    "http://www.ens.fr/en/les-laboratoires-sciences",
    "https://www.ttu.ee/",
    "https://www.ttu.ee/teaduskond/infotehnoloogia-teaduskond/doktoriope-33/",
    "https://www.ttu.ee/?id=30052",
    "https://www.tlu.ee/en",
    "https://www.tlu.ee/en/research/Scholars",
    "http://www.tlu.ee/en/Conference-Centre/Inquiry-for-organising-an-event",
    "https://www.artun.ee/en/admissions/welcome/",
    "https://www.artun.ee/en/studies/",
    "https://www.artun.ee/en/oppimine/kalender/",
    "https://www.emu.ee/en/",
    "http://pk.emu.ee/en/",
    "https://www.emu.ee/about-the-university/events/kalender/2017-11",
    "https://www.ut.ee/et",
    "https://www.ut.ee/en/research",
    "https://elurikkus.ut.ee/search_er2.php?lang=eng",
    "http://www.ema.edu.ee/en/",
    "http://www.ema.edu.ee/en/continuing-education/organisation-of-courses/",
    "http://www.ema.edu.ee/en/studies/curricula/courses-subject-catalogue/");

//    List<String> URLS = Arrays.asList(
//   "https://infoscience.epfl.ch/search?ln=en&p=test&f=title&ext=collection%3AARTICLE",
//   "https://www.ethz.ch/en.html"
//    );

//        List<String> URLS = Arrays.asList(
//                "https://www.eesti.ee/en/",
//            "http://www.rkas.ee/en",
//            "https://riha.eesti.ee/riha/main",
//            "https://www.etis.ee/?lang=ENG",
//            "https://www.ria.ee/en/",
//            "http://www.delfi.ee/",
//            "https://www.nasa.gov/",
//            "http://edition.cnn.com/",
//            "https://www.bbc.co.uk/",
//            "https://www.mnt.ee/eng"
//    );

//    List<String> URLS = Arrays.asList(
//                "https://www.example.com"
//    );


    @Autowired
    private TestRepository testRepository;

    @Autowired
    private Kristi2Repository kristi2Repository;

    @Autowired
    private TotalTimeRepository totalTimeRepository;

    @Autowired
    public UsabilityEvaluationController(OntologyEvaluatorService evaluatorService, OntologyRepository ontologyRepository, OntologyService ontologyService) {
        this.evaluatorService = evaluatorService;
        this.ontologyRepository = ontologyRepository;
        this.ontologyService = ontologyService;
    }

    @RequestMapping("/usability/enormous-evaluation")
    public List<EvaluationResult> performEnormouseEvlauation(String webURL) {

        List<EvaluationResult> wcagGuideline = evaluatorService.evaluate(Category.WCAGGuideline, webURL);
        wcagGuideline.forEach(t -> testRepository.save(t));
        return null;
    }

    @RequestMapping("/usability/evaluation/{category}")
    public List<EvaluationResult> evaluateByCategory(@PathVariable("category") Category category,
                                                     @RequestParam(value="url", defaultValue="http://www.etis.ee") String webURL) throws InterruptedException, ExecutionException {
        if (category.equals(Category.AllGuidelines)) {
            ExecutorService executor = Executors.newFixedThreadPool(3);

            Callable<List<EvaluationResult>> WCAGGuideline = () -> {
                return evaluatorService.evaluate(Category.WCAGGuideline, webURL);
            };

            Callable<List<EvaluationResult>> UsabilityGuideline = () -> {
                return evaluatorService.evaluate(Category.UsabilityGuideline, webURL);
            };

            Callable<List<EvaluationResult>> MobileUsabilityGuideline = () -> {
                return evaluatorService.evaluate(Category.MobileUsabilityGuideline, webURL);
            };

            List<Future<List<EvaluationResult>>> futureInsurerQuotes = executor.invokeAll(Arrays.asList(WCAGGuideline,UsabilityGuideline,MobileUsabilityGuideline));

            List<EvaluationResult> results = new ArrayList<>();
            for (Future<List<EvaluationResult>> futureQuote : futureInsurerQuotes) {
                results.addAll(futureQuote.get());
            }

            Collections.sort(results, Comparator.comparing(o -> o.getResult().name()));
            return results;
        }
        return evaluatorService.evaluate(category, webURL);
    }

    @GetMapping("/usability/multiple-evaluation")
    public List<EvaluationResult> multipleEvaluation() {
        URLS.forEach(url -> {
            try {
                LocalDateTime startTime = LocalDateTime.now();
                TimeUrlEvaluiation evaluiation = new TimeUrlEvaluiation();
                evaluiation.setUrl(url);
                evaluate(url);
                evaluiation.setTotal(new Integer(Math.toIntExact(startTime.until(LocalDateTime.now(), ChronoUnit.SECONDS))));
                totalTimeRepository.save(evaluiation);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return null;
    }

    @GetMapping("/usability/guideline-evaluation")
    public List<EvaluationResult> multipleEvaluationByGuidelines() {
        URLS.forEach(url -> {
            try {
                evaluate(url);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return null;
    }

    @Transactional
    public void evaluate(String URL) throws ExecutionException, InterruptedException {
        List<EvaluationResult> allGuidelines = evaluateByCategory("AllGuidelines", URL);
//        List<EvaluationResult> guidelines = evaluatorService.evaluate("WcagGuideline", "https://www.etis.ee/Portal/Projects/Index?searchType=detailed");
//        allGuidelines.forEach(t -> testRepository.save(t));
    }

    WebDriver driver;

    @GetMapping("/usability/other-evaluation")
    public List<EvaluationResult> otherEvaluation() {
        URLS.forEach(url -> {
            try {
                otherEvaluation(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return null;
    }

    @Transactional
    public void otherEvaluation(String URL) throws InterruptedException {
        driver = evaluatorService.initialiseDriver();
        WebDriverWait wait = new WebDriverWait(driver, 60);

        driver.get("https://achecker.ca/checker/index.php");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkuri")));
        driver.findElement(By.id("checkuri")).sendKeys(URL);
        driver.findElement(By.linkText("Options")).click();
        driver.findElement(By.id("option_rpt_line")).click();
        driver.findElement(By.id("checkbox_gid_2")).click();
        driver.findElement(By.id("checkbox_gid_7")).click();
        driver.findElement(By.id("enable_css_validation")).click();
        driver.findElement(By.id("enable_html_validation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("validate_uri")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AC_menu_errors")));

//        System.out.println("HTML" + );
//        System.out.println("Validation" );

        OtherResult result = new OtherResult();
        result.setUrl(URL);
        result.setKnownProblems(driver.findElement(By.id("AC_num_of_errors")).getText());
        result.setPotentialProblems(driver.findElement(By.id("AC_num_of_likely")).getText());
        result.setHtml(driver.findElement(By.id("AC_num_of_html_errors")).getText());
        result.setCss(driver.findElement(By.id("AC_num_of_css_errors")).getText());
        kristi2Repository.save(result);
        driver.close();
    }

}
