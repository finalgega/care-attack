package blog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Cal;

import database.MySQLController;

public class auntieSarah {
	private final static String dsn = "careattack";
	private String topic = null;
	private String subject = null;
	private String question = null;
	private String date = null;
	private String username = null;
	private String tipperday = null;
	private String auntieSarahComment = null;
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTipperday() {
		return tipperday;
	}

	public void setTipperday(String tipperday) {
		this.tipperday = tipperday;
	}

	public String getAuntieSarahComment() {
		return auntieSarahComment;
	}

	public void setAuntieSarahComment(String auntieSarahComment) {
		this.auntieSarahComment = auntieSarahComment;
	}

	public auntieSarah(){}
	
	public auntieSarah(String tipperday){
		this.tipperday = tipperday;
	}
	
	public auntieSarah(String topic, String subject,String question,String username){
		this.topic = topic;
		this.subject = subject;
		this.question = question;
		this.username = username;
	}
	
	
	public auntieSarah(String auntieSarahComment,String topic, String subject,String question,String username,String date){
		this.auntieSarahComment = auntieSarahComment;
		this.topic = topic;
		this.subject = subject;
		this.question = question;
		this.username = username;
		this.date =date;
	}
	
public boolean createAQuestion(String topic,String subject, String question,String username){
		
		boolean success = false;
		ResultSet rs = null;
		MySQLController mysql = new MySQLController();
		String owner = null;
		Cal date = new Cal();
		mysql.setUp(dsn);
		String dbQuery ="select accID from account where username = '"+username+"'";
		try {
			rs = mysql.readRequest(dbQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if(rs.next()){
				 owner= rs.getString("accID");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			}
		try{
			String sql ="INSERT INTO auntieSarah(topic,subject,question, accID,date)";
			sql += "VALUES('" + topic + "','" + subject + "','" + question + "','" + owner + "','" + date.dated() + "')";
		
			try{
				rs = mysql.readRequest(sql);
				if(mysql.updateRequest(sql) == 1)
				{
					success = true;
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
	}finally
	{
		mysql.terminate();
	
	}
		return success;
}
	
	public ArrayList<auntieSarah> retrieveQuestion()
	{
		ArrayList<auntieSarah> retrieveAQuestion = new ArrayList<auntieSarah>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "select auntieSarahComment,topic,subject,question,date,account.username from auntieSarah inner join account on account.accID = auntieSarah.accID";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					auntieSarah raq = new auntieSarah(rs.getString("auntieSarahComment"),rs.getString("topic"),rs.getString("subject"),rs.getString("question"),rs.getString("date"),rs.getString("account.username"));
					retrieveAQuestion.add(raq);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveAQuestion;
	}

	public ArrayList<auntieSarah> retrieveTipPerDay()
	{
		ArrayList<auntieSarah> retrieveATip = new ArrayList<auntieSarah>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "select tipperday from tipperday order by rand() limit 1";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					auntieSarah raq = new auntieSarah(rs.getString("tipperday"));
					retrieveATip.add(raq);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveATip;
	}
	
	/*//Correct One
	public ArrayList<auntieSarah> retrieveTipPerDay()
	{
		ArrayList<auntieSarah> retrieveATip = new ArrayList<auntieSarah>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "select tipperday from auntiesarah order by rand() limit 1";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					auntieSarah raq = new auntieSarah(rs.getString("tipperday"));
					retrieveATip.add(raq);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveATip;
	}*/
	
}
