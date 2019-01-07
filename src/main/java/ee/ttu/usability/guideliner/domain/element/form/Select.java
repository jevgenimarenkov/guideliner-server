package ee.ttu.usability.guideliner.domain.element.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Select extends AbstractForm {

    private Integer minNumberOfInputs;

    private Integer maxNumberOfInputs;

}
