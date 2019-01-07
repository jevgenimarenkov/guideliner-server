package ee.ttu.usability.guideliner.domain.element.link;

import ee.ttu.usability.guideliner.domain.attribute.*;
import lombok.Getter;
import lombok.Setter;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;

@Getter
@Setter
public class Link extends UsabilityGuideline {

	private Href href;

	private Title title;

	private LinkType linkType;

	private AlternativeText alternativeText;

	private Width width;

	private Distance distance;

	private Color color;

	private Boolean isVisited;

	private Boolean hasText;

}
