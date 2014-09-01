package work.ken.tools;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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


}