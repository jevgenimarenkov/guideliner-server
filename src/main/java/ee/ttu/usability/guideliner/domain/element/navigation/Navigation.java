package ee.ttu.usability.guideliner.domain.element.navigation;


import lombok.Getter;
import lombok.Setter;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import ee.ttu.usability.guideliner.domain.pageattributes.HorizontalScroll;
import ee.ttu.usability.guideliner.domain.structure.Position;

@Getter@Setter
public class Navigation extends UsabilityGuideline {

	private Position position;
	
	private HorizontalScroll horizontalScroll;
	
	private ID id;
	
}
