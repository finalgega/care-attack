package blog;

import java.sql.ResultSet;
import java.util.ArrayList;

import util.Cal;

import database.MySQLController;

public class auntieSarah {
	private final static String dsn = "CareAttack";
	private String topic = null;
	private String subject = null;
	private String question = null;
	private String date = null;
	private String username = null;
	

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

	public auntieSarah(){}
	
	public auntieSarah(String topic, String subject,String question){
		this.topic = topic;
		this.subject = subject;
		this.question = question;
	}
	
	
	public auntieSarah(String topic, String subject,String question,String date){
		this.topic = topic;
		this.subject = subject;
		this.question = question;
		this.date =date;
	}
	
	public boolean createAQuestion(String topic, String subject,String question)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		Cal date = new Cal();
		mysql.setUp(dsn);
		String sql ="insert into careattack.auntiesarah (topic,subject,question,date)";
		sql += "VALUES('" + topic + "','" + subject + "','" + question + "','" + date.dated() + "')";
		try{
			if(mysql.updateRequest(sql) == 1)
			{
				success = true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		mysql.terminate();
		return success;
	}
	
	/*public boolean createAQuestion(String topic, String subject,String question,String username)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		Cal date = new Cal();
		mysql.setUp(dsn);
		String sql ="insert into careattack.auntiesarah (topic,subject,question,date,accID)";
		sql += "VALUES('" + topic + "','" + subject + "','" + question + "','" + date.dated()  + "','" + username + "')";
		try{
			if(mysql.updateRequest(sql) == 1)
			{
				success = true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		mysql.terminate();
		return success;
	}
	*/
	
	public ArrayList<auntieSarah> retrieveQuestion()
	{
		ArrayList<auntieSarah> retrieveAQuestion = new ArrayList<auntieSarah>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "select topic,subject,question,date from careattack.auntiesarah";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					auntieSarah raq = new auntieSarah(rs.getString("topic"),rs.getString("subject"),rs.getString("question"),rs.getString("date"));
					retrieveAQuestion.add(raq);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveAQuestion;
	}

	
	
}
