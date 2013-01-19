package blog;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import database.MySQLController;

public class archive {

	private final static String dsn = "CareAttack";
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
		String dbQuery ="select MONTHNAME(substring(blog.date,1,10)),substring(blog.date,1,4) from careattack.blog";
		
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
	
	public ArrayList<archive> getTheMonth(){
		ArrayList<archive> retrieveMonth = new ArrayList<archive>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery ="SELECT MONTHNAME(substring(blog.date,1,10)) from careattack.blog ";
		
		try {
			rs = mysql.readRequest(dbQuery);
			while(rs.next()){
				archive month = new archive(rs.getString("substring(blog.date,6,2)"));
				retrieveMonth.add(month);
			}
		}
		catch(Exception e){e.printStackTrace();}
		return retrieveMonth;
}
	
	public ArrayList <archive> tryout(){
		ArrayList<archive> tried = new ArrayList<archive>();
		archive bp = new archive();
		tried = bp.getTheYearMonth();
		
		ArrayList<archive> nonDupList = new ArrayList<archive>();

        Iterator<archive> dupIter = tried.iterator();
        while(dupIter.hasNext())
        {
        archive dupWord = dupIter.next();
        if(nonDupList.contains(dupWord))
        {
            dupIter.remove();
        }else
        {
            nonDupList.add(dupWord);
        }
        }
        return nonDupList;
	}
	
	public ArrayList <archive> trytry(){
		ArrayList<archive> duplicateList = new ArrayList<archive>();
		archive bp = new archive();
		duplicateList = bp.getTheYearMonth();
		LinkedHashSet<archive> listToSet = new LinkedHashSet<archive> (duplicateList);
		ArrayList<archive> listWithoutDuplicates = new ArrayList<archive> (listToSet);
		return listWithoutDuplicates;
	}
	
}
