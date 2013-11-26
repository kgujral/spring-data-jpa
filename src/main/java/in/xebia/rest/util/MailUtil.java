package in.xebia.rest.util;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.multipart.FormDataMultiPart;

public class MailUtil {

    public static ClientResponse sendMail(String from, String to, String message, String subject) {
		String endPoint = "https://api.mailgun.net/v2/prontoapps.com";
		String key = "key-8k0pa4wfw5l0--zjoz25mvb4c6kw5jd4";
		Client client = Client.create();
	       client.addFilter(new HTTPBasicAuthFilter("api", key));
	       WebResource webResource = client.resource(endPoint + "/messages");
	       
	       FormDataMultiPart formData = new FormDataMultiPart();
	       formData.field("from", from);
	       formData.field("to", to);
	       formData.field("subject", subject);
	       formData.field("text", message);
	       
	       return webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class, formData);
	}
	
	public static void main(String[] args) {
		sendMail("Karan Gujral <kgujral@gmail.com>", "prontodiner@gmail.com", "test message", "TEST");
	}
}
