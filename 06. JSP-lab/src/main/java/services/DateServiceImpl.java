package services;


import java.text.SimpleDateFormat;
import java.util.Date;


public class DateServiceImpl implements DateService {

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	
	@Override
	public String getCurrentDate() {
	
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String date = sdf.format(new Date());
		return date;
	}

}
