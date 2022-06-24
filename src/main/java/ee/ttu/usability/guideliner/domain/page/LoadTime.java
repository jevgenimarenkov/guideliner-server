package ee.ttu.usability.guideliner.domain.page;

import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import lombok.Data;

import java.time.Duration;

@Data
public class LoadTime {
	private Unit unit;
	
	private Duration timeInSeconds;
}
