package ee.ttu.usability.guideliner.domain.element.form;

import ee.ttu.usability.guideliner.domain.attribute.Label;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class AbstractForm extends UsabilityGuideline {

	private Label label;

	List<String> precededElements;

}
