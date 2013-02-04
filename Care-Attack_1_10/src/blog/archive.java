package blog;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import database.MySQLController;

public class archive {

	private final static String dsn = "careattack";
	private String year = null;
	private String month = null;
	private String date = null;
	
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public archive(){}
	
	public archive(String month,String year){
		super();
		this.month = month;
		this.year= year;
	}
	
	public archive(String date){
		super();
		this.date = date;
	}
	
	public ArrayList<archive> getTheYearMonth(){
		ArrayList<archive> retrieveYearMonth = new ArrayList<archive>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery ="select distinct MONTHNAME(substring(blog.date,1,10)),substring(blog.date,1,4) from careattack.blog";
		
		try {
			rs = mysql.readRequest(dbQuery);
			while(rs.next()){
				month = rs.getString("MONTHNAME(substring(blog.date,1,10))");
				year = rs.getString("substring(blog.date,1,4)");
				String date = month + " " +  year;
				archive a1 = new archive(date);
				retrieveYearMonth.add(a1);
			}
		}
		catch(Exception e){e.printStackTrace();}
		return retrieveYearMonth;
}
	
	public ArrayList<archive> getTheBlogArchive(){
		ArrayList<archive> retrieveYearMonth = new ArrayList<archive>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery ="select distinct MONTHNAME(substring(blog.date,1,10)),substring(blog.date,1,4) from careattack.blog";
		
		try {
			rs = mysql.readRequest(dbQuery);
			while(rs.next()){
				month = rs.getString("MONTHNAME(substring(blog.date,1,10))");
				year = rs.getString("substring(blog.date,1,4)");
				String date = month + " " +  year;
				archive a1 = new archive(date);
				retrieveYearMonth.add(a1);
			}
		}
		catch(Exception e){e.printStackTrace();}
		return retrieveYearMonth;
}
}
	