package ee.ttu.usability.guideliner.domain.page;

import ee.ttu.usability.guideliner.domain.attribute.AbstractAttribute;
import ee.ttu.usability.guideliner.domain.dataproperty.Case;
import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import lombok.Data;

@Data
public class Text extends AbstractAttribute {
	
	private Case caseType;
	
	private Integer contentLength;
	
	private Unit unit;
	
}
