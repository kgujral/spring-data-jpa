package in.xebia.rest.exception;

public class CustomException extends Exception {
	
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public CustomException() {
	}
	
	public CustomException(String message) {
		this.message = message;
	}

	private static final long serialVersionUID = 1333382120222351244L;
}
