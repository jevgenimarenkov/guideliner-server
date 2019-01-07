package ee.ttu.usability.guideliner.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.w3c.tidy.Tidy;
import org.w3c.tidy.TidyMessage;
import org.w3c.tidy.TidyMessageListener;

import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.FailedElement;
import ee.ttu.usability.guideliner.estimation.result.ResultType;

public class HtmlValidator {

	public EvaluationResult test(String html) {
		EvaluationResult result = new EvaluationResult();
		result.setResult(ResultType.SUCCESS);

		TidyCustomMessageListener listener = new TidyCustomMessageListener();

		Tidy tidy = new Tidy();
		tidy.setEmacs(true);
		tidy.setQuiet(true);
		tidy.setMessageListener(listener);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		InputStream stream = new ByteArrayInputStream(html.getBytes());
		tidy.parse(stream, out);

		result.setFailedElements(listener.getFailedElements());

		if (result.getFailedElements().size() == 0)
			result.setResult(ResultType.SUCCESS);
		else
			result.setResult(ResultType.FAIL);

		return result;
	}

	class TidyCustomMessageListener implements TidyMessageListener {

		private List<FailedElement> failedElements = new ArrayList<FailedElement>();

		@Override
		public void messageReceived(TidyMessage message) {
			if (message.getMessage().indexOf("unknown") < 0) {
				getFailedElements().add(prepareFailedElement("Html element", "", message.getMessage(), "NONE"));
			}
		}

		public List<FailedElement> getFailedElements() {
			return failedElements;
		}

		public void setFailedElements(List<FailedElement> failedElements) {
			this.failedElements = failedElements;
		}

	}

	FailedElement prepareFailedElement(String type, String text, String description, String path) {
		FailedElement element = new FailedElement();
		element.setType(type);
		element.setText(text);
		element.setDescription(description);
		element.setPathToElement(path);
		return element;
	}
}
