package in.xebia.rest.service;

import in.xebia.rest.domain.User;

public interface UserService {

	User findByUserNameAndPassword(String userName, String password);
	
	User findByUserName(String userName);
	
	User save(User user);

}
