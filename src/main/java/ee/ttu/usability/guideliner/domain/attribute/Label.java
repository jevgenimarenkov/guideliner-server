package ee.ttu.usability.guideliner.domain.attribute;

import lombok.Getter;
import lombok.Setter;
import org.apache.xpath.operations.Bool;

@Getter@Setter
public class Label extends AbstractAttribute {

	private Boolean isValued;

	private Boolean hasText;
	
}
