package util;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.text.SimpleDateFormat;

import blog.archive;

public class Cal{
	public static String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

	public String dated() {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	return sdf.format(cal.getTime());
	
	}

	

}