package in.xebia.rest.controller;

import in.xebia.rest.dto.MailDto;
import in.xebia.rest.exception.CustomException;
import in.xebia.rest.util.MailUtil;
import in.xebia.rest.util.RestResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController extends BaseController {

	@ResponseBody
	@RequestMapping(value = "/contact-us-mail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse verifyForMerchant(MailDto mailDto, HttpServletResponse  httpResponse, HttpServletRequest request) throws CustomException {
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		validateDto(mailDto);
		String domain = request.getHeader("Referer");
		Boolean success = checkDomain(domain);
		if(success) {
			sendMail(mailDto, domain);
		}
		
		RestResponse response = new RestResponse(success, null, null);
		return response;
	}

	private void sendMail(MailDto mailDto, String domain) {
		MailUtil.sendMail(	mailDto.getName()+" <"+mailDto.getEmail()+">", mailDto.getTo(), 
							mailDto.getMessage() +"\n\nContact query from "+domain, mailDto.getSubject());
	}

	private Boolean checkDomain(String domain) {
		if(domain == null) {
			return Boolean.FALSE;
		}
		for(String validDomain : VALID_DOMAINS) {
			if(domain.contains(validDomain)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
}
