package work.ken.tools.email;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Attachment {

	private String filename;
	private String contentType;
	private InputStream data;

	public Attachment(String filename, String contentType, InputStream data) {
		this.filename = filename;
		this.contentType = contentType;
		this.data = data;
	}

	public Attachment(String filename, String contentType, byte[] data) {
		this.filename = filename;
		this.contentType = contentType;
		this.data = new ByteArrayInputStream(data);
	}

	public String getFilename() {
		return filename;
	}

	public String getContentType() {
		return contentType;
	}

	public InputStream getData() {
		return data;
	}
}
