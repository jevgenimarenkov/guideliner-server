package ee.ttu.usability.guideliner.domain.element.navigation;

import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import ee.ttu.usability.guideliner.domain.dataproperty.UnitAction;
import lombok.Data;

@Data
public class ProhibitedWords {

	private String value;

	private Unit unit;

	private UnitAction unitAction;
	
}
