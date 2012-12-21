package in.xebia.rest.controller;

import in.xebia.rest.domain.User;
import in.xebia.rest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		User user = new User("karan", "karan");
		userService.save(user);
		return "index";
	}

}
