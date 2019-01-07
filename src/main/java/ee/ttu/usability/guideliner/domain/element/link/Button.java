package ee.ttu.usability.guideliner.domain.element.link;

import ee.ttu.usability.guideliner.domain.attribute.OnClick;
import ee.ttu.usability.guideliner.domain.attribute.OnKeyPress;
import lombok.Data;
import ee.ttu.usability.guideliner.domain.attribute.AlternativeText;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;

@Data
public class Button extends UsabilityGuideline {

	private AlternativeText alternativeText;

    private OnKeyPress onKeyPress;
    
    private OnClick onClick;

}
