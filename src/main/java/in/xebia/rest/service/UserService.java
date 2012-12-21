package in.xebia.rest.service;

import java.util.List;

import in.xebia.rest.domain.User;

public interface UserService {

	User findByUserId(String userId);
	
	User saveOrUpdate(User user);

	List<User> findAll(int pageNumber, int pageSize);
	
	void delete(Long id);
	
	User findById(Long id);
	
	long count();
	
	boolean exists(long id);
	
	void edit(Long id, User user);
}
