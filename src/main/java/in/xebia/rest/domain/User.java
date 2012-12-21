package in.xebia.rest.domain;

import in.xebia.rest.util.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Represents a User entity
 */
@Entity
public class User extends AbstractEntity<Long> {

	@Column(unique = true, nullable = false)
	private String userId;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String emailAddress;
	
	@Column(unique = true, nullable = false)
	private String screenName;

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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public User(String userId, String firstName, String lastName, String emailAddress, String screenName) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.screenName = screenName;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [Id=" + getId() + ", userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", screenName=" + screenName + ", getDateCreated()="
				+ getDateCreated() + ", getLastModified()=" + getLastModified() + "]";
	}

	private static final long serialVersionUID = 6652150399106080309L;
}
