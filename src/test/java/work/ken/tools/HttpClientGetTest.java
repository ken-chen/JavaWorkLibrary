package work.ken.tools;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Before;
import org.junit.Test;

import work.ken.tools.gson.UGCEntry;
import work.ken.tools.gson.UGCResponse;
import work.ken.tools.xstream.XStreamConversionTool;

import com.google.gson.Gson;

public class HttpClientGetTest {
	@Before
	public void setUp() throws Exception {

	}
	private static final Gson parser = new Gson();
	
	@Test
	public void testSuccessfulSubmit() {
		   // Create an instance of HttpClient.
	    HttpClient client = new HttpClient();

	    String url = "http://001.entrysubmission.isobar.uat.visualjazz.com.au/api/Campaign/GetEntries?campaignId=CF3ADD79-0D07-4526-81E1-6184601D0B27";
		// Create a method instance.
	    GetMethod method = new GetMethod(url);
	    
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
	      System.out.println("response object is " + method.getResponseBodyAsString());
	      
	      
	      UGCResponse ugcResponse = parser.fromJson(method.getResponseBodyAsString(),UGCResponse.class);
	      assertNotNull(ugcResponse.getNextPageLink());
	      assertNotNull(ugcResponse.getItems());
	      
	      System.out.println(ugcResponse);
	      
	      UGCEntry.filterEmailForTheUGCResponse(ugcResponse);
	      
	      
	      System.out.println(XStreamConversionTool.getJsonString(ugcResponse));
	      if(XStreamConversionTool.getJsonString(ugcResponse).contains("Email")){
	    	  fail("no email field should be exposed to the API");
	      }
	      
	      
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
