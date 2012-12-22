package in.xebia.rest.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RestResponse implements Serializable {

	private Boolean success;
	
	private List<String> messages;
	
	private Object data;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public RestResponse(Boolean success, List<String> messages, Object data) {
		this.success = success;
		this.messages = messages;
		this.data = data;
	}

	public RestResponse(Boolean success, String message, Object data) {
		this(success, getMsg(message), data);
	}

	private static List<String> getMsg(String message) {
		List<String> temp = new ArrayList<String>();
		temp.add(message);
		return temp;
	}
	
	public RestResponse() {
	}
	
	private static final long serialVersionUID = -9055827565548755880L;
	
}
