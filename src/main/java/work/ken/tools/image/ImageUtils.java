package work.ken.tools.image;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtils {
	/**
	 * Get the string Base64 value of the image
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String getImageBase64AsString(MultipartFile file) throws IOException {
		String imageBase64 = null;
		if (!file.isEmpty()) {

			byte[] apacheBytes = null;   
			apacheBytes = org.apache.commons.codec.binary.Base64.encodeBase64(file.getBytes());
			imageBase64 = new String(apacheBytes);
		}
		return imageBase64;
		
	}
	
	/**
	 * check the image type is jpg jpeg or pjpeg
	 * @param contentType
	 * @return
	 */
	public static boolean checkImageTypeIsJPG(String contentType){		
		
		if(contentType==null){
			return false;
		}
		
		String pattern = "((?i)(image)(\\/(?i)(jpg|jpeg|pjpeg))$)";
		Pattern r = Pattern.compile(pattern);
		//create the matcher object.  
	    Matcher m = r.matcher(contentType);
		if(m.find()){
			return true;
		}else{
			return false;
		} 
	}
}
