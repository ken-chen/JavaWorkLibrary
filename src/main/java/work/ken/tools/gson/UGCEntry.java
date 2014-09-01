package work.ken.tools.gson;

import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

/**
 * @author kchen
 * * This class return as the json string
 *
 */
public class UGCEntry {
	private static final Gson parser = new Gson();
	private static final Log logger = LogFactory.getLog(UGCEntry.class);			
			
	
	/**
	 * this method forward the request  to the ISOBAR UGC entry which is supported by the .NET team, and return as the json string
	 * @param query
	 * @return
	 */
	public static String getJsonResponse(String query){
		   //String webServiceAddress = readIsobarServiceFromConfiguration();
		   String webServiceAddress ="";
		   HttpClient client = new HttpClient();
		   UGCResponse isobarResponse  = null;
		   
		   GetMethod method = new GetMethod(webServiceAddress);
		    
		   // Provide custom retry handler
		   method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

		    try {
		      // Execute the method.
		      int statusCode = client.executeMethod(method);

		      if (statusCode != HttpStatus.SC_OK) {
		        logger.error("Method failed: " + method.getStatusLine());
		      }

		      logger.debug("response object is " + method.getResponseBodyAsString());
		      
		      isobarResponse = parser.fromJson(method.getResponseBodyAsString(),UGCResponse.class);
		      
		      filterEmailForTheUGCResponse(isobarResponse);
		      		      
		    } catch (HttpException ex) {
		        logger.error("Method failed: " + method.getStatusLine());
		    } catch (IOException ex) {
		        logger.error("Fatal transport error: " + ex.getMessage());
		    } finally {
		      // Release the connection.
		      method.releaseConnection();
		    }
		    
		return null;//XStreamConversionTool.getJsonString(isobarResponse); 
	}



	
	/**
	 * Filter the email field of the UGC Response
	 * @param ugcResponse
	 */
	public static void filterEmailForTheUGCResponse(UGCResponse ugcResponse){
	      if(ugcResponse !=null && ugcResponse.getItems()!=null){
		      for(Items item: ugcResponse.getItems()){
		    	  EntryDetails entryDetails =  item.getEntryDetails();
		    	  entryDetails.setEmail(null);
		    	  
		      }
	      }
	}
	
	
	
}
