package ee.ttu.usability.guideliner.domain.element;

import ee.ttu.usability.guideliner.domain.attribute.*;
import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import ee.ttu.usability.guideliner.domain.pageattributes.Height;
import lombok.Data;

@Data
public class UsabilityGuideline {

	private Contrast contrast;
	
	private Distance distance;
	
	private ProhibitedWordType prohibitedWordType;
	
	private Height height;
	
	private Width width;
	
	private Unit unit;
	
	private Integer contentLength;
	
	private String url;

	private Color color;

}
