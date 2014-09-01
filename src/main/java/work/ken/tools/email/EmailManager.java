package work.ken.tools.email;

import java.util.List;

import javax.mail.internet.MimeBodyPart;

/**
 * Abstraction for sending email messages. Behind the scenes this manager may use FatWire mail API's
 */
public interface EmailManager {

	/**
	 * Primary method for sending email in various forms and optionally with attachments
	 */
	public boolean sendMail(String to, String from, String replyTo, String subject, String body, String contentType,
			List<Attachment> attachments);

	/**
	 * 
	 */
	public boolean sendMail(String[] to, String subject, String body, String from, String contentType, boolean isHtml);

	public boolean sendMail(String to, String subject, String body, String from, String contentType, boolean isHtml);

	public boolean sendMail(String to, String from, String replyTo, String subject, String body, String contentType,
			boolean isHtml);

	public boolean sendMail(String[] tos, String from, String replyTo, String subject, String body, String contentType,
			boolean isHtml);


	/**
	 * Mail sender for Multi-MIME type emails
	 * 
	 * @param to e-mail address of the person to send to
	 * @param from e-mail address to be sent from
	 * @param cc e-mail address to CC to
	 * @param subject subject
	 * @param body ordered List of configured parts to be compiled
	 * @return <b>True:</b> if required data is present
	 *	<br> <b>False:</b> Otherwise
	 */
	public boolean sendMailMultiMimeType(String to, String from, String cc, String subject, List<MimeBodyPart> body);

	/**
	 * Mail sender for Multi-MIME type emails for multiple recipients
	 * 
	 * @param to e-mail address of the person to send to
	 * @param from e-mail address to be sent from
	 * @param cc e-mail address to CC to
	 * @param subject subject
	 * @param body ordered List of configured parts to be compiled
	 * @return <b>True:</b> if required data is present
	 *	<br> <b>False:</b> Otherwise
	 */
	public boolean sendMailMultiMimeType(String[] to, String from, String[] cc, String subject, List<MimeBodyPart> body);
	/**
	 * Convenience method for sending administrator email notification messages
	 */
	// public void sendAdministratorMail(String subject, String message);
}
