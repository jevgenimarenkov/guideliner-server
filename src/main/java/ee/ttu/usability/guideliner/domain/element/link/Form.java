package ee.ttu.usability.guideliner.domain.element.link;

import lombok.Data;
import ee.ttu.usability.guideliner.domain.attribute.AlternativeText;
import ee.ttu.usability.guideliner.domain.attribute.Label;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;

@Data
public class Form extends UsabilityGuideline {
	
	private AlternativeText alternativeText;
	
	private Label label;
	
}
