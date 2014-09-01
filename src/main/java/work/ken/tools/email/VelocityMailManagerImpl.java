package work.ken.tools.email;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;


/*
 * Class that holds Velocity Engine and JavaMailSender (from Spring) to send mails
 * with Velocity template
 * 
 */
public class VelocityMailManagerImpl implements VelocityMailManager {

	/* Spring MailSender */
	@Autowired
	private JavaMailSender mailSender;

	/* Velocity Engine */
	@Autowired
	private VelocityEngine velocityEngine;
    
	/*
	 * Holds the logic to send the email. First, a MimeMessagePreparator is instantied, according to the campaign passed
	 * and then the email has sent through Spring implementation
	 * 
	 * @param campaignFormBean - bean holding data from form
	 * 
	 * @param campaignId - name of the campaign
	 * 
	 * @see
	 * au.com.holden.mail.VelocityMailManager#sendVelocityTemplateEmail(au.com.holden.web.mvc.bean.CampaignFormBean,
	 * java.lang.String)
	 */
//	public void sendVelocityTemplateEmail(CampaignFormBean campaignFormBean, String campaignId) {
//
//		MimeMessagePreparator preparator = MimeMessagePreparatorFactory.getMimeMessagePreparator(campaignFormBean,
//				campaignId, velocityEngine);
//
//		this.mailSender.send(preparator);
//	}

}
