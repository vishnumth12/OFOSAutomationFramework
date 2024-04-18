package GenericUtilitiesPackage;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * @author Dudes co
	 * @return
	 * this method is used to return a random number to append
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int random = ran.nextInt();
		return random;
		
	}
	
	/**
	 * @author Dudes co
	 * @return
	 * this method is used to return the current date from the system in original format
	 */
	public String getSystemDate() {
		
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * @author Dudes co
	 * @return
	 * this method is used to return a formatted date (yyyy-MM-dd-HH-mm-ss) for use
	 */
	public String getSystemDateInFormat() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("(yyyy-MM-dd)(HH-mm-ss)");
		Date d = new Date();
		String syDateFormat = sdf.format(d);
		return syDateFormat;
		
	}
	
	/**
	 * @author Dudes co
	 * @return
	 * this method returns the system date and time
	 */
	public String getSystemDateAndTime() {
		
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		return timeStamp;
				
	}
}
