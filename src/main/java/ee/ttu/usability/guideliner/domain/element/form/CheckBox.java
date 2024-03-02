package ee.ttu.usability.guideliner.domain.element.form;

import ee.ttu.usability.guideliner.domain.page.Layout;
import lombok.Data;

@Data
public class CheckBox extends AbstractForm {

    private Layout layout;

    private Integer minNumberOfInputs;

    private Integer maxNumberOfInputs;
}
