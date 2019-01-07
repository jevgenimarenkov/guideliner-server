package ee.ttu.usability.guideliner.domain.element.form;

import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class FormElementLabel extends UsabilityGuideline {

    private PositionType positionType;
}
