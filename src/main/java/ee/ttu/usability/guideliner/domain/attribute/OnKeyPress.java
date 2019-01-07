package ee.ttu.usability.guideliner.domain.attribute;

import lombok.Data;
import org.apache.xpath.operations.Bool;

@Data
public class OnKeyPress extends AbstractAttribute {

	private Boolean isValued = false;
	
}
