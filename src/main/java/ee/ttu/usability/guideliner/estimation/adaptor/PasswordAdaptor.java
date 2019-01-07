package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.element.form.Password;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

public class PasswordAdaptor extends AbstractFormAdaptor {

    public EvaluationResult execute(Password element) {
        if (element.getLabel() != null && element.getLabel().getIsValued()!= null) {
            return evaluateThatInputHasLabel("password", "Password element.", "Password element should have label.");
        } else  if (element.getLabel() != null && element.getLabel().getHasText() != null) {
            return evaluateThatInputHasValuedLabel("password", "Password element.", "Password element label should have value.");
        }
        throw new RuntimeException("Do not know what to evaluate ");
    }

}
