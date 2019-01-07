package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.attribute.AlternativeText;
import ee.ttu.usability.guideliner.domain.element.link.Applet;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service("AppletAdaptor")
public class AppletAdaptor extends AbstractAdaptor {

	public EvaluationResult execute(Applet applet) throws IOException {
		if (applet.getAlternativeText() != null) {
			return evaluateAlternativeText(applet.getAlternativeText());
		}
		return null;
	}

	private EvaluationResult evaluateAlternativeText(AlternativeText alt) throws IOException {
		if (BooleanUtils.isTrue(alt.getIsValued())) {
			return evaluateAlternativeText("applet", ElementType.APPLET);
		}
		throw new RuntimeException("Cannot perform evaluation");
	}
}
