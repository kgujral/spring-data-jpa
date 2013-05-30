package in.xebia.rest.controller;

import in.xebia.rest.exception.CustomException;
import in.xebia.rest.util.RestConstants;
import in.xebia.rest.util.RestResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class BaseController {
	
	@Autowired
	protected Validator validator;
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	
	@ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse handleErrors(Exception error) {
		return new RestResponse(Boolean.FALSE, getErrorMessage(error), null);
	}
	
	private List<String> getErrorMessage(Exception error) {
		if(error instanceof CustomException) {
			return ((CustomException) error).getMessages();
		}
		String message = error.getMessage();
		message = message.split(";")[0];
		message = message.split("\n")[0];
		if(message.length() > 250) {
			message = RestConstants.GLOBAL_ERROR;
		}
		List<String> messages = new ArrayList<String>();
		messages.add(message);
		return messages;
	}
	
	protected <T> void validateDto(T dto) throws CustomException {
		Set<ConstraintViolation<T>> s = validator.validate(dto);
		List<String> errorMessages = new ArrayList<String>();
		for(ConstraintViolation<T> c:s) {
			errorMessages.add(c.getMessage());
		}
		if(!errorMessages.isEmpty()) {
			throw new CustomException(errorMessages);
		}
	}
}
