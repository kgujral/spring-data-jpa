package in.xebia.rest.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;



public class UserDto implements Serializable {

	private Long id;
	
	@NotEmpty(message="User Id cannot be empty.")
	private String userId;
	
	@NotEmpty(message="First Name cannot be empty.")
	private String firstName;
	
	@NotEmpty(message="Last Name cannot be empty.")
	private String lastName;
	
	@NotEmpty(message="Screen Name cannot be empty.")
	private String screenName;
	
	@NotEmpty(message="Email Address cannot be empty.")
	private String emailAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userId=" + userId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", screenName="
				+ screenName + ", emailAddress=" + emailAddress + "]";
	}

	private static final long serialVersionUID = -4888146323736335456L;
}
