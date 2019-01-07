package ee.ttu.usability.guideliner.domain.attribute;

import ee.ttu.usability.guideliner.domain.dataproperty.DistanceType;
import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import lombok.Data;

@Data
public class Distance extends AbstractAttribute {

    private Unit unit;

    private Integer contentLength;

    private DistanceType distanceType;

}
