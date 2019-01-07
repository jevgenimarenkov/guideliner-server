package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.element.form.Select;
import ee.ttu.usability.guideliner.domain.element.form.Text;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

public class TextAdaptor extends AbstractFormAdaptor {
    public EvaluationResult execute(Text element) {
        if (element.getLabel() != null && element.getLabel().getIsValued()!= null) {
            return evaluateThatInputHasLabel("text", "Text element.", "Text element should have label.");
        } else  if (element.getLabel() != null && element.getLabel().getHasText() != null) {
            return evaluateThatInputHasValuedLabel("text", "Text element.", "Text element label should have value.");
        }
        throw new RuntimeException("Do not know what to evaluate ");
    }
}
