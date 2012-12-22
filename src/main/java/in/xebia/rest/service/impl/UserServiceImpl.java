package in.xebia.rest.service.impl;

import in.xebia.rest.domain.User;
import in.xebia.rest.exception.CustomException;
import in.xebia.rest.repository.UserRepository;
import in.xebia.rest.service.UserService;
import in.xebia.rest.util.RestConstants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final String ID = "id";

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.ASC, ID);
		return userRepository.findAll(pageable).getContent();
	}
	
	@Override
	public void delete(Long id) throws CustomException {
		try {
			userRepository.delete(id);
		} catch(Exception ex) {
			throw new CustomException(RestConstants.NO_SUCH_USER_EXISTS + id);
		}
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public long count() {
		return userRepository.count();
	}
	
	@Override
	public boolean exists(long id) {
		return userRepository.exists(id);
	}
	
	@Override
	public void edit(Long id, User user) throws CustomException {
		User oldUser = findById(id);
		if(oldUser != null) {
			copyUser(oldUser, user);
			userRepository.save(oldUser);
		} else {
			throw new CustomException(RestConstants.NO_SUCH_USER_EXISTS + id);
		}
	}

	private void copyUser(User oldUser, User newUser) {
		oldUser.setEmailAddress(newUser.getEmailAddress());
		oldUser.setFirstName(newUser.getFirstName());
		oldUser.setLastName(newUser.getLastName());
		oldUser.setUserId(newUser.getUserId());
		oldUser.setScreenName(newUser.getScreenName());
		oldUser.setEmailAddress(newUser.getEmailAddress());
	}
}
