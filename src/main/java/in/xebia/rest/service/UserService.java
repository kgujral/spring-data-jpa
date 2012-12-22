package in.xebia.rest.service;

import java.util.List;

import in.xebia.rest.domain.User;
import in.xebia.rest.exception.CustomException;

public interface UserService {

	User findByUserId(String userId);
	
	User save(User user);

	List<User> findAll(int pageNumber, int pageSize);
	
	void delete(Long id) throws CustomException;
	
	User findById(Long id);
	
	long count();
	
	boolean exists(long id);
	
	void edit(Long id, User user) throws CustomException;
}
