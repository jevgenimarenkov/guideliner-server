package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.element.form.Password;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.domain.attribute.Label;
public class PasswordAdaptor extends AbstractFormAdaptor {

    public EvaluationResult execute(Password element) {
        // Assuming getLabel() returns a Label object that could be null
        if (element.getLabel() == null) {
            throw new RuntimeException("Password element does not have a label.");
        }

        Label label = element.getLabel(); // Use a local variable to avoid multiple calls to getLabel()

        // Combine checks for isValued and hasText to simplify logic
        if (Boolean.TRUE.equals(label.getIsValued())) {
            return evaluateThatInputHasLabel("password", "Password element.", "Password element should have a label.");
        } else if (Boolean.TRUE.equals(label.getHasText())) {
            return evaluateThatInputHasValuedLabel("password", "Password element.", "Password element label should have value.");
        }

        throw new RuntimeException("Password element label does not have a value or text.");
    }
}
