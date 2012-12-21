package in.xebia.rest.service.impl;

import in.xebia.rest.domain.User;
import in.xebia.rest.repository.UserRepository;
import in.xebia.rest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByUserNameAndPassword(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
}
