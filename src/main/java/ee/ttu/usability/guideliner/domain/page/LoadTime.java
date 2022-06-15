package ee.ttu.usability.guideliner.domain.page;

import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import lombok.Data;

@Data
public class LoadTime {

	private Unit unit;
	
	private Integer timeInSeconds;
	
}
