package ee.ttu.usability.guideliner.domain.element.link;

import ee.ttu.usability.guideliner.domain.attribute.Title;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import lombok.Data;

@Data
public class Frame extends UsabilityGuideline {
    private Title title;
}
