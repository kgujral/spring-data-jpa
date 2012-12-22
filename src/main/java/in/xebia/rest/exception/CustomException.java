package in.xebia.rest.exception;

import java.util.ArrayList;
import java.util.List;

public class CustomException extends Exception {
	
	private List<String> messages;

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public CustomException(List<String> messages) {
		this.messages = messages;
	}

	public CustomException(String message) {
		this.messages = getErrorMessages(message);
	}
	
	private List<String> getErrorMessages(String message) {
		List<String> messages = new ArrayList<String>();
		messages.add(message);
		return messages;
	}

	public CustomException() {
	}
	
	private static final long serialVersionUID = 1333382120222351244L;
}
