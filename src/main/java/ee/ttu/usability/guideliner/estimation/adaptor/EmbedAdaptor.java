package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.attribute.AlternativeText;
import ee.ttu.usability.guideliner.domain.element.link.Applet;
import ee.ttu.usability.guideliner.domain.element.link.Embed;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service("EmbedAdaptor")
public class EmbedAdaptor extends AbstractAdaptor<Embed> {

	public EvaluationResult execute(Embed applet) throws IOException {
		if (applet.getAlternativeText() != null) {
			return evaluateAlternativeText(applet.getAlternativeText());
		} else {
			return EvaluationResult.EMPTY_RESULT;
		}
	}

	private EvaluationResult evaluateAlternativeText(AlternativeText alt) throws IOException {
		if (BooleanUtils.isTrue(alt.getIsValued())) {
			return evaluateAlternativeText("embed", ElementType.EMBED);
		}
		throw new RuntimeException("Cannot perform evaluation");
	}
}
