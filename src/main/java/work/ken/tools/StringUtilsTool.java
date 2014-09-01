package work.ken.tools;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtilsTool {
	private final static Log logger = LogFactory.getLog(StringUtilsTool.class); 
	
	/**
	 * @param params
	 */
	public static void isValideFWassetId(String ... params )  {
		
		for(int count = 0 ; count < params.length; count++){
			
			String temp = params[count];
			if (StringUtils.isEmpty(temp)){
				logger.error("the id cannot be blank [ " + temp + " ]");
				throw new IllegalArgumentException("the id cannot be blank [ " + temp + " ]");
			}

			if (temp.length() !=13) {		
				logger.error("the id input is not 13 characters length [ " + temp + " ]");
				throw new IllegalArgumentException("the id input is not 13 characters length [ " + temp + " ]");
			
			}
			if (!StringUtils.isNumeric(temp) ) {	
				logger.error("the id input can only be numeric [ " + temp + " ]");
				throw new IllegalArgumentException("the id input can only be numeric [ " + temp + " ]");			
			}
		}
	}
}
