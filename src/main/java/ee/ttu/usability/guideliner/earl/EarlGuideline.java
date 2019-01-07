package ee.ttu.usability.guideliner.earl;

import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.FailedElement;
import ee.ttu.usability.guideliner.estimation.result.Guideline;
import ee.ttu.usability.guideliner.estimation.result.ResultType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EarlGuideline {


    public static String generateEarlResult(List<EvaluationResult> results, String url) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(getHeader());
        stringBuilder.append(getTestSubject(url));
        stringBuilder.append(getSoftware(url));
        stringBuilder.append(createAssertion(results));
        stringBuilder.append(getFooter());
        return stringBuilder.toString();
    }

    public static String getHeader() {
        return "<rdf:RDF xmlns:earl=\"http://www.w3.org/WAI/ER/EARL/nmg-strawman#\"\n" +
                "         xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
                "         xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n" +
                "         xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n" +
                "         xmlns:dct=\"http://purl.org/dc/terms/\"\n" +
                "         xmlns:foaf=\"http://xmlns.com/foaf/0.1/\">";
    }

    public static String getFooter() {
        return "</rdf:RDF>";
    }

    public static String getTestSubject(String url) {
        return "    <earl:TestSubject rdf:ID=\"evaluatedWebPages\">\n" +
                "        <dct:title xml:lang=\"en\">Web Page being evaluated</dct:title>\n" +
                "        <dct:hasPart rdf:resource=\"" + url + "\"/>\n" +
                "    </earl:TestSubject>";
    }

    public static String getSoftware(String url) {
        return "    <earl:Software rdf:about=\"http://validator.w3.org/about.html#\" rdf:ID=\"automatedUsabilityAssertor\">\n" +
                "        <dct:title xml:lang=\"en\">Automated Web Usability Evaluation Tool</dct:title>\n" +
                "        <dct:hasVersion>1.9.1</dct:hasVersion>\n" +
                "        <dct:description xml:lang=\"en\">A tool for automated usability evaluation checking the the conformance of web UI to the predefined set of guidelines\n" +
                "        </dct:description>\n" +
                "    </earl:Software>";
    }

    public static String createAssertion(List<EvaluationResult> results) {
        StringBuilder builder = new StringBuilder("");
        for (EvaluationResult result : results) {
            String testCaseId = UUID.randomUUID().toString();
            String resultId = UUID.randomUUID().toString();

            String assertion = createAssertion(result, testCaseId, resultId);
            String testCase = createTestCase(null, testCaseId);
            String evalautionResult = createResult(result, resultId);
            builder.append(assertion)
                    .append(testCase)
                    .append(evalautionResult);
        }
        return builder.toString();
    }

    private static String createAssertion(EvaluationResult result, String testCaseId, String resultId) {
        return "<earl:Assertion rdf:ID=\""+UUID.randomUUID().toString()+"\">\n" +
                "        <earl:assertedBy rdf:resource=\"#automatedUsabilityAssertor\" />\n" +
                "        <earl:subject rdf:resource=\"#evaluatedWebPages\" />\n" +
                "        <earl:testcase rdf:resource=\"#"+testCaseId+"\" />\n" +
                "        <earl:result rdf:resource=\"#"+resultId+"\" />\n" +
                "    </earl:Assertion>";
    }

    private static String createTestCase(Guideline guideline, String testCaseId) {
        return "    <earl:TestCase rdf:about=\"http://www.w3.org/TR/WCAG20-TECHS/H36\" rdf:ID=\""+testCaseId+"\">\n" +
                "        <dct:title xml:lang=\"en\">"
               +  guideline.getCode() + "->" + guideline.getName() +
                "</dct:title>\n" +
                "        <dct:description xml:lang=\"en\">" + guideline.getDescription() + "</dct:description>\n" +
                "    </earl:TestCase>";
    }

    private static String createResult(EvaluationResult result, String resultId) {
        if (result.getResult() == ResultType.SUCCESS) {
            return getSuccessResult(resultId);
        }
        String description = getFailedDescription(result.getFailedElements());
        return getFailedResult(description, resultId);
    }

    private static String getFailedResult(String description, String resultId) {
        return "    <earl:TestResult rdf:ID=\""+resultId+"\">\n" +
                "        <earl:validity\n" +
                "                rdf:resource=\"http://www.w3.org/WAI/ER/EARL/nmg-strawman#fail\" />\n" +
                "        <dc:description rdf:parseType=\"Literal\">\n" +
                "            <div xml:lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "                <p>\n" +
                "                   "+description+"\n" +
                "                </p>\n" +
                "            </div>\n" +
                "        </dc:description>\n" +
                "    </earl:TestResult>";
    }

    private static String getSuccessResult(String resultId) {
        return "    <earl:TestResult rdf:ID=\"" + resultId + "\">\n" +
                "        <earl:validity\n" +
                "                rdf:resource=\"http://www.w3.org/WAI/ER/EARL/nmg-strawman#pass\" />\n" +
                "    </earl:TestResult>";
    }

    private static String getFailedDescription(List<FailedElement> failedElements) {
        StringBuilder stringBuilder = new StringBuilder();
        int problemNr = 0;

        List<String> elements = new ArrayList<>();
        for (FailedElement failedElement : failedElements) {
            String element =
                    "Element violating guideline nr. : " + (++problemNr) + "\n" +
                            "Element Text: " + failedElement.getText() + "\n" +
                            "Element type: " + failedElement.getType() + "\n" +
                            "Violation reason " + failedElement.getDescription() + "\n";

            stringBuilder.append(element + "\n");
        }

        return stringBuilder.toString();
    }

}
