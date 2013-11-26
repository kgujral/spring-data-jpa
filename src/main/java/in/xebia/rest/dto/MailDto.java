package in.xebia.rest.dto;

import java.io.Serializable;


public class MailDto implements Serializable {
	
	private static final long serialVersionUID = -6617962643740099973L;

	private String name;
	
	private String from;

	private String email;
	
	private String subject;
	
	private String message;
	
	private String to;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MailDto [name=" + name + ", from=" + from + ", email=" + email
				+ ", subject=" + subject + ", message=" + message + ", to="
				+ to + "]";
	}
}
