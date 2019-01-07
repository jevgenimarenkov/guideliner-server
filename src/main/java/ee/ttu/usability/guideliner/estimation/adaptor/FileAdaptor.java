package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.element.form.CheckBox;
import ee.ttu.usability.guideliner.domain.element.form.File;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

public class FileAdaptor extends AbstractFormAdaptor {

    public EvaluationResult execute(File element) {
        if (element.getLabel() != null && element.getLabel().getIsValued()!= null) {
            return evaluateThatInputHasLabel("file", "File element.", "File element should have label.");
        } else  if (element.getLabel() != null && element.getLabel().getHasText() != null) {
            return evaluateThatInputHasValuedLabel("file", "File element.", "File element label should have value.");
        }
        throw new RuntimeException("Do not know what to evaluate ");
    }

}
