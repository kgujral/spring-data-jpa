package in.xebia.rest.domain;

import in.xebia.rest.util.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Represents a person entity
 * 
 * @author  
 */
@Entity
public class User extends AbstractEntity<Long> {

	@Column(unique = true, nullable = false)
	private String userName;
	
	@Column(unique = true, nullable = false)
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	public User() {
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	private static final long serialVersionUID = 9050485683260637270L;
}
