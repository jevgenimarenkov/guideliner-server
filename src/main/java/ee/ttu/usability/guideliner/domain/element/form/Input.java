package ee.ttu.usability.guideliner.domain.element.form;

import ee.ttu.usability.guideliner.domain.attribute.AlternativeText;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import ee.ttu.usability.guideliner.domain.page.Layout;
import lombok.Data;

@Data
public class Input extends UsabilityGuideline {

	private AlternativeText alternativeText;

	private Boolean isSelected;

	private Layout layout;

}
