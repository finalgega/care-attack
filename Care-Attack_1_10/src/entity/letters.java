package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.*;
public class letters {
	private final String dsn = "careattack";
	private String name = null;
	private String message = null;
	
	public letters(){}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	public letters(String name, String message){
		this.name = name;
		this.message = message;
	}


	public boolean createLetters(String name, String message)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String sql ="INSERT INTO letters(name, message)";
		sql += "VALUES('" + name + "','" + message +"')";
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
	
	
	public ArrayList<letters> retrieveData(){

		ArrayList<letters> letter = new ArrayList<letters>();
		ResultSet rs = null;
		MySQLController db = new MySQLController();
		String dbQuery = "SELECT * FROM letters";
		db.setUp("careattack");
		try{
			rs = db.readRequest(dbQuery);
			while(rs.next())
			{		
				name = rs.getString("name");
				message = rs.getString("message");
				letters l1 = new letters (name, message);
				letter.add(l1);
				
				}
		}
		catch (Exception e)
		{e.printStackTrace();}
		db.terminate();
		return letter;
	}
}
