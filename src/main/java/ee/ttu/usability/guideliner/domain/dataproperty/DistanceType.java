package ee.ttu.usability.guideliner.domain.dataproperty;

public enum DistanceType {
    CLICKABLE_ELEMENT,
    UNKNOWN;
    public static DistanceType convertToDistanceType(String layout) {
        if (layout.equalsIgnoreCase(CLICKABLE_ELEMENT.name())) {
            return DistanceType.CLICKABLE_ELEMENT;
        }
        return DistanceType.UNKNOWN;
    }
}
