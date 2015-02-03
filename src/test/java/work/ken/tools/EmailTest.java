package work.ken.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.com.holden.web.forms.common.FormType;
import au.com.holden.web.forms.common.beans.FormBean;

import work.ken.tools.email.EmailManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class EmailTest {
	
	@Autowired
	private EmailManager emailManager;
	
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testSuccessfulSendEamil() {

	
		StringBuilder subject = new StringBuilder();
		subject.append(" - ").append("Test Application");
		
		StringBuilder textMessage = new StringBuilder();
		textMessage.append("\n\nTopic : " + subject);
		
		boolean emailSent = true;

		// need to append environment
		List<String> emails = new ArrayList<String>();
		
		for(String email: emails){
			email = "kchen@visualjazz.com.au";
			emailSent = emailManager.sendMail(email, subject.toString(), textMessage.toString(), "jwchen0208@gmail.com", "text/html", false);	
			System.out.println("emailSent is " + emailSent);
		}	
}
	
	@Test
	public void test(){
		String a = StringUtils.defaultIfEmpty("", "sadsa");
		System.out.println(a);
		
		a = StringUtils.defaultIfEmpty(null, "??");
		System.out.println(a);
		a = String.format("%s %s %s","sadd21d21d21d21d21");
		System.out.println(a);
		
	}	

	@Test
	public void testSendData2() {
		for (int i=1; i<10000;i++){
			run(i);
		}

	}
	
	private void run(int query){
		 // Create an instance of HttpClient.
	    HttpClient client = new HttpClient();

	    // Create a method instance.
	    GetMethod method = new GetMethod("http://www.holden.com.au/Satellite?c=Page&cid=1236974800984&pagename=Holden.co.nz/HLDPageDispatch&rendermode="+query);
	    
	    // Provide custom retry handler is necessary
	    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    		new DefaultHttpMethodRetryHandler(3, false));

	    try {
	      // Execute the method.
	      int statusCode = client.executeMethod(method);

	      if (statusCode != HttpStatus.SC_OK) {
	        System.err.println("Method failed: " + method.getStatusLine());
	      }

	      // Read the response body.
	      byte[] responseBody = method.getResponseBody();

	      // Deal with the response.
	      // Use caution: ensure correct character encoding and is not binary data
	      System.out.println(new String(responseBody));

	    } catch (HttpException e) {
	      System.err.println("Fatal protocol violation: " + e.getMessage());
	      e.printStackTrace();
	    } catch (IOException e) {
	      System.err.println("Fatal transport error: " + e.getMessage());
	      e.printStackTrace();
	    } finally {
	      // Release the connection.
	      method.releaseConnection();
	    } 
	}
	

}