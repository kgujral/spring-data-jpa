package in.xebia.rest.controller;

import in.xebia.rest.dto.UserDto;
import in.xebia.rest.exception.CustomException;
import in.xebia.rest.service.UserService;
import in.xebia.rest.util.RestResponse;
import in.xebia.rest.util.transformer.UserTransformer;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/users")
public class RestController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public RestResponse getAllUsers(@RequestParam int pageNumber, @RequestParam int pageSize, HttpServletResponse  httpResponse) {
		List<UserDto> dtos = UserTransformer.usersToDtos(userService.findAll(pageNumber, pageSize));
		RestResponse response = new RestResponse(Boolean.TRUE, null, dtos);
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "GET");
		httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type");
		httpResponse.setHeader("Access-Control-Max-Age", "86400");
		return response;
	}

	@RequestMapping(value="/page/{pageNumber}", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse getAllUsersPaginated(@PathVariable int pageNumber) {
		List<UserDto> dtos = UserTransformer.usersToDtos(userService.findAll(pageNumber, 10));
		RestResponse response = new RestResponse(Boolean.TRUE, null, dtos);
		return response;
	}

	@RequestMapping(value="/page/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse getAllUsersPaginatedF(@PathVariable int pageNumber, @PathVariable int pageSize) {
		List<UserDto> dtos = UserTransformer.usersToDtos(userService.findAll(pageNumber, pageSize));
		RestResponse response = new RestResponse(Boolean.TRUE, null, dtos);
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable Long id) throws CustomException {
		userService.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void editUser(@PathVariable Long id, @RequestBody UserDto dto) throws CustomException {
		validateDto(dto);
		userService.edit(id, UserTransformer.dtoToUser(dto));
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody RestResponse addNewUser(@RequestBody UserDto dto) throws CustomException {
		validateDto(dto);
		dto = UserTransformer.userToDto(userService.save(UserTransformer.dtoToUser(dto)));
		RestResponse response = new RestResponse(Boolean.TRUE, null, dto);
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody RestResponse getOne(@PathVariable Long id) {
		UserDto dto = UserTransformer.userToDto(userService.findById(id));
		RestResponse response = new RestResponse(Boolean.TRUE, null, dto);
		return response;
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody RestResponse getCount() {
		Long count = userService.count();
		RestResponse response = new RestResponse(Boolean.TRUE, null, count);
		return response;
	}
}
