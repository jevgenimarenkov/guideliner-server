package ee.ttu.usability.guideliner.domain.dataproperty;

public enum DistanceType {
    CLICKABLEELEMENT,
    UNKNOWN;

    public static DistanceType convertToDistanceType(String layout) {
        if (layout.equalsIgnoreCase(CLICKABLEELEMENT.name())) {
            return DistanceType.CLICKABLEELEMENT;
        }
        return DistanceType.UNKNOWN;
    }
}
