package work.ken.tools.email;

import java.util.List;

public abstract class AbstractEmailManager implements EmailManager {

	public String getDefaultFromAddress() {
		return "";
	}

	public String getAdministratorEmailAddress() {
		return "";
	}

	/**
	 * Convenience method, simply delegates to the primary mail sending method
	 */
	public void sendAdministratorMail(String subject, String message) {
		sendMail(getAdministratorEmailAddress(), subject, message, getDefaultFromAddress(), "");
	}

	public abstract boolean sendMail(String to, String subject, String body, String from, String contentType,
			String charset, List<Attachment> attachments);

	public abstract boolean sendMail(String to, String subject, String body, String from, String contentType);
}
