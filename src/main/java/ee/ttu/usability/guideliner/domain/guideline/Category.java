package ee.ttu.usability.guideliner.domain.guideline;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    AllGuidelines,
    WCAGGuideline,
    UsabilityGuideline,
    MobileUsabilityGuideline;

    public static List<Category> getAllCategories() {
        return Arrays.stream(Category.values())
                .collect(Collectors.toList());
    }
}
