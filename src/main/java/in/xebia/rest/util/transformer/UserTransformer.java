package in.xebia.rest.util.transformer;

import java.util.ArrayList;
import java.util.List;

import in.xebia.rest.domain.User;
import in.xebia.rest.dto.UserDto;

public class UserTransformer {
	
	public static User dtoToUser(UserDto dto) {
		User user = new User();
		user.setEmailAddress(dto.getEmailAddress());
		user.setFirstName(dto.getFirstName());
		user.setId(dto.getId());
		user.setLastName(dto.getLastName());
		user.setScreenName(dto.getScreenName());
		user.setUserId(dto.getUserId());
		return user;
	}

	public static List<User> dtosToUsers(List<UserDto> dtos) {
		List<User> users = new ArrayList<User>();
		for(UserDto dto : dtos) {
			users.add(dtoToUser(dto));
		}
		return users;
	}

	
	public static UserDto userToDto(User user) {
		if(user == null)
			return null;
		UserDto dto = new UserDto();
		dto.setEmailAddress(user.getEmailAddress());
		dto.setFirstName(user.getFirstName());
		dto.setId(user.getId());
		dto.setLastName(user.getLastName());
		dto.setScreenName(user.getScreenName());
		dto.setUserId(user.getUserId());
		return dto;
	}
	
	public static List<UserDto> usersToDtos(List<User> users) {
		List<UserDto> dtos = new ArrayList<UserDto>();
		for(User user : users) {
			dtos.add(userToDto(user));
		}
		return dtos;
	}
}
