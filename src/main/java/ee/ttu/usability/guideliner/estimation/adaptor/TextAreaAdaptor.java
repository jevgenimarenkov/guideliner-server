package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.element.form.TextArea;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

public class TextAreaAdaptor extends AbstractFormAdaptor {

    public EvaluationResult execute(TextArea element) {
        if (element.getLabel() != null && element.getLabel().getIsValued()!= null) {
            return evaluateThatInputHasLabel("textarea", "Textarea element.", "Textarea element should have label.");
        } else  if (element.getLabel() != null && element.getLabel().getHasText() != null) {
            return evaluateThatInputHasValuedLabel("textarea", "Textarea element.", "Textarea element label should have value.");
        }
        throw new RuntimeException("Do not know what to evaluate ");
    }

}
