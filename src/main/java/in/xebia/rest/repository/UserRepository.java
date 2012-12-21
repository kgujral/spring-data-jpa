package in.xebia.rest.repository;

import in.xebia.rest.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserNameAndPassword(String userName, String password);
	
	User findByUserName(String userName);
}
