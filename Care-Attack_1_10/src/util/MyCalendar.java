/*===================================================================
Program Name:	MyCalendar.java
Description:	A class to perform date functions
Done by:		Phoon Lee Kien
Admin No:		001234A
Module Group:	IT1204-99
=====================================================================*/
package util;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * This utility class is tailored to perform data functions
 * 
 * @author Aaron Goy Ding Xian
 * @category Utility
 * @version 1.10
 * @since 2011-10-23
 * 
 */
public class MyCalendar {

	/**
	 *Get the number of days for first date minus second date
	 *
	 * @param date1(GregorianCalendar)
	 * @param date2(GregorianCalendar)
	 * @return difference(long)
	 */
	public long getDifference (GregorianCalendar date1, 
								GregorianCalendar date2){
									
		long firstDate = date1.getTimeInMillis();
		long secDate = date2.getTimeInMillis();
		
		return (firstDate - secDate)/(24*60*60*1000);
	}
	
	/**
	 * 
	 * @param d1(GregorianCalendar)
	 * @return String
	 */
	public String formatDateforDisplay (GregorianCalendar d1){
		int day = d1.get(Calendar.DATE);
		int month = d1.get(Calendar.MONTH)+ 1 ;
		int year = d1.get(Calendar.YEAR);
		return day + "/" + month + "/" + year;
	}
	
	/**
	 * 
	 * @param d1(GregorianCalendar)
	 * @return String
	 */
	public String formatDate (GregorianCalendar d1)
	{
		int day = d1.get(Calendar.DATE);
		int month = d1.get(Calendar.MONTH) + 1;
		int year = d1.get(Calendar.YEAR);
		return year + "-" + month + "-" + day;
	}
	
	/**
	 * 
	 * @param d1(GregorianCalendar)
	 * @return String
	 */
	public String formatTime (GregorianCalendar d1)
	{
		int hour = d1.get(Calendar.HOUR_OF_DAY);
		int min = d1.get(Calendar.MINUTE);
		int sec = d1.get(Calendar.SECOND);
		return hour + "::" + min + "::" + sec;
	}
	
	/**
	 * This method convertDate takes in a date as a String
	 * and calculates the date and returns it in a GregorianCalendar format
	 * @param str
	 * @return GregorianCalendar
	 */
	public GregorianCalendar convertDate(String str) //	str as placeholder
	{
		int day,month,year;
		
		Scanner sc = new Scanner(str); // Calls an instance of Scanner
		sc.useDelimiter("/"); // use the delimiter to split the str into three int.
		day = sc.nextInt();
		month = sc.nextInt()-1;
		year = sc.nextInt();
		GregorianCalendar gc1 = new GregorianCalendar(year, month, day);
		return gc1;		
	}
	
	public String getCurrentDate()
	{
		String date;
		int day = Calendar.DAY_OF_MONTH;
		int month = Calendar.MONTH;
		int year = Calendar.YEAR;
		date = year + "-" + month + "-" + day;
		return date;
	}
	@SuppressWarnings("unused")
	public String getCurrentGCMonth(String date)
	{
		String monthStr;
		Scanner sc = new Scanner(date);
		sc.useDelimiter("/");
		int day = sc.nextInt();
		int month = sc.nextInt();
		int year = sc.nextInt();
		monthStr = processMonth(month);
		return monthStr;
	}
	

	public String getCurrentGCMonth(int month)
	{
		String monthStr = processMonth(month);
		return monthStr;
	}
	
	private String processMonth(int month) {
		String monthStr;
		switch(month)
		{
		case 1: monthStr = "January"; break;
		case 2: monthStr = "Febuary"; break;
		case 3: monthStr = "March"; break;
		case 4: monthStr = "April"; break;
		case 5: monthStr = "May"; break;
		case 6: monthStr = "June"; break;
		case 7: monthStr = "July"; break;
		case 8: monthStr = "August"; break;
		case 9: monthStr = "September"; break;
		case 10: monthStr = "October"; break;
		case 11: monthStr = "November"; break;
		case 12: monthStr = "December"; break;
		default : monthStr = "Err"; break;
		}
		return monthStr;
	}
}

