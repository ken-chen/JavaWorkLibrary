package work.ken.tools.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class TimeUtils {

		
	/*
	 * get the current time as the string format
	 * 
	 */
	public static String getCurrentTimeAsSting(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'");
		String time = dateFormat.format(GregorianCalendar.getInstance().getTime());
		return time;
	}
	
	

	
	
	/**
	 * @param filter the MicroSoft Special characters
	 */
	public static String filterMSSpecialCharacters(String s){
		  if(s==null){
			  return null;
		  }
		  
		  s = s.replace( (char)145, (char)'\'');
		  s = s.replace( (char)8216, (char)'\''); // left single quote
		  s = s.replace( (char)146, (char)'\'');
		  s = s.replace( (char)8217, (char)'\''); // right single quote
		  s = s.replace( (char)147, (char)'\"');
		  s = s.replace( (char)148, (char)'\"');
		  s = s.replace( (char)8220, (char)'\"'); // left double
		  s = s.replace( (char)8221, (char)'\"'); // right double
		  s = s.replace( (char)8211, (char)'-' ); // em dash??    
		  s = s.replace( (char)150, (char)'-' );
		  return s;
	}
}
