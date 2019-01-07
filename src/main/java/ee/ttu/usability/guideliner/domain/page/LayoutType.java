package ee.ttu.usability.guideliner.domain.page;

public enum LayoutType {
	FLUID,
	VERTICAL;
	
	public static LayoutType convertToLayoutType(String layout) {
		if (layout.equalsIgnoreCase(FLUID.name())) {
			return LayoutType.FLUID;
		} else if (layout.equalsIgnoreCase(VERTICAL.name())) {
			return LayoutType.VERTICAL;
		}
		return null;
	}
}
