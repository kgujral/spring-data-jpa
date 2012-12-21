package in.xebia.rest.repository;

import in.xebia.rest.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserId(String userId);

}
