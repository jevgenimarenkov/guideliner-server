package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.attribute.Label;
import ee.ttu.usability.guideliner.domain.element.form.CheckBox;
import ee.ttu.usability.guideliner.domain.element.form.File;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

public class FileAdaptor extends AbstractFormAdaptor {

    public EvaluationResult execute(File element) {
        // Early exit if the element's label is null to simplify further logic
        if (element.getLabel() == null) {
            throw new RuntimeException("File element does not have a label.");
        }

        Label label = element.getLabel(); // Use a local variable to avoid multiple calls to getLabel()

        // Check for isValued first. Assuming getIsValued() returns a Boolean, use Boolean.TRUE.equals to avoid NullPointerException
        if (Boolean.TRUE.equals(label.getIsValued())) {
            return evaluateThatInputHasLabel("file", "File element.", "File element should have a label.");
        }
        // Then check for hasText. This assumes getHasText() also returns a Boolean.
        else if (Boolean.TRUE.equals(label.getHasText())) {
            return evaluateThatInputHasValuedLabel("file", "File element.", "File element label should have value.");
        }

        // If neither condition is met, throw an exception with a more helpful message.
        throw new RuntimeException("File element's label lacks a valued attribute or text.");
    }

}
