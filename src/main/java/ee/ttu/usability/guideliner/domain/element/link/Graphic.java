package ee.ttu.usability.guideliner.domain.element.link;

import lombok.Data;
import ee.ttu.usability.guideliner.domain.attribute.AlternativeText;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;

@Data
public class Graphic extends UsabilityGuideline {

	private AlternativeText alternativeText;
	
}
