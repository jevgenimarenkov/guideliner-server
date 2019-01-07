package usability;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.w3c.tidy.Tidy;
import org.w3c.tidy.TidyMessage;
import org.w3c.tidy.TidyMessageListener;

public class TidyExample {

	public static void main(String[] args) {
		TestMessageListenet listnere = new TestMessageListenet();
		
		String htmlData = "<html><head></head><div>Hello Java </div></body></html>";  
		Tidy tidy = new Tidy();
		tidy.setEmacs(true);

		tidy.setQuiet(true);
		tidy.setMessageListener(listnere);
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
//
		InputStream stream = new ByteArrayInputStream(htmlData.getBytes());
		tidy.parse(stream, out);
		
	//	System.out.println(tidy.getParseWarnings());
	//	tidy.getStderr().println();
	//	tidy.getErrout().println();

	}
	

	
}

class TestMessageListenet implements TidyMessageListener {

	@Override
	public void messageReceived(TidyMessage message) {
		System.out.println("message" + message.getMessage());
		System.out.println(message.getErrorCode());
		
		
	}
	
}