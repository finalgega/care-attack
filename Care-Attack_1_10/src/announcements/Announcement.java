package announcements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.MySQLController;

/**
 * This Java Bean Announcment provices the necessary accessor and mutator
 * methods for its variables and methods to create and retrieve announcements
 * @author Aaron Goy Ding Xian
 * @version 2.00
 * @since 2012-09-14
 * @category Java Bean
 */
public class Announcement {
	private String annonTopic = null;
	private String annonContent = null;
	private String aDate = null;
	private int annonID = 0;
	private int aImageID = 0;
	
	public Announcement()
	{
		
	}
	
	public Announcement(String annonTopic, String annonContent)
	{
		this.annonTopic = annonTopic;
		this.annonContent = annonContent;
	}
	
	public Announcement(String annonTopic, String annonContent, String date)
	{
		this.annonTopic = annonTopic;
		this.annonContent = annonContent;
		this.aDate = date;
	}
	
	public Announcement(int annonID,String annonTopic,String annonContent,String date)
	{
		this.setaID(annonID);
		this.annonTopic = annonTopic;
		this.annonContent = annonContent;
		this.aDate = date;
	}
	
	public Announcement(int annonID,String annonTopic,String annonContent,String date,int aImageID)
	{
		this.setaID(annonID);
		this.annonTopic = annonTopic;
		this.annonContent = annonContent;
		this.aDate = date;
		this.setaImageID(aImageID);
	}
	
	/**
	 * @return the annonID
	 */
	public int getaID() {
		return annonID;
	}

	/**
	 * @param annonID the annonID to set
	 */
	public void setaID(int annonID) {
		this.annonID = annonID;
	}

	public String getaTopic() {
		return annonTopic;
	}

	public void setaTopic(String annonTopic) {
		this.annonTopic = annonTopic;
	}

	public String getaContent() {
		return annonContent;
	}

	public void setaContent(String annonContent) {
		this.annonContent = annonContent;
	}

	public String getaDate() {
		return aDate;
	}

	public void setaDate(String aDate) {
		this.aDate = aDate;
	}

	public int getaImageID() {
		return aImageID;
	}

	public void setaImageID(int aImageID) {
		this.aImageID = aImageID;
	}

	/**
	 * Creates announcements and stores them in the database
	 * 
	 * @param annonTopic (String)
	 * @param annonContent (String)
	 * @param date (String)
	 * @param imageID 
	 * @return success (boolean)
	 * @throws SQLException
	 */
	public boolean createAnnouncement(String annonTopic, String annonContent, String date, int imageID) throws SQLException
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		String sql ="INSERT INTO announcement(announceTopic, announceContent,announceDate,imageID)";
		sql += "VALUES('" + annonTopic + "','" + annonContent + "','" + date + "','" + imageID +"')";
		if(mysql.updateRequest(sql) == 1)
		{
			success = true;
		}
		mysql.terminate();
		return success;
	}
	
	public ArrayList<Integer> retrieveAnnouncementIDs()
	{
		ArrayList<Integer> annonIDs = new ArrayList<Integer>();
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		ResultSet rs = null;
		String dbQuery = "SELECT announceID FROM announcement";
		try
		{
			rs = mysql.readRequest(dbQuery);
			while(rs.next())
			{
				int annonID = rs.getInt("announceID");
				annonIDs.add(annonID);
			}
		}catch(SQLException sqlErr)
		{
			sqlErr.printStackTrace();
		}finally
		{
			mysql.terminate();
		}
		return annonIDs;
		
	}
	public Announcement retrieveAnnouncement(int annonID)
	{
		Announcement annon = null;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		ResultSet rs = null;
		String dbQuery = "SELECT * FROM announcement WHERE announceID = '" + annonID + "'";
		try
		{
			rs = mysql.readRequest(dbQuery);
				if(rs.next())
				{
					Announcement a = new Announcement(rs.getInt("announceID"),rs.getString("announceTopic"),rs.getString("announceContent"),rs.getString("announceDate"),rs.getInt("imageID"));
					annon = a;
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			mysql.terminate();
		}
		return annon;
	}

	/**
	 * Retrieves all the announcements from database and stores them into
	 * an ArrayList<Announcement> for further processing
	 * 
	 * @return ArrayList<Announcement>
	 */
	public ArrayList<Announcement> retrieveAnnouncements()
	{
		ArrayList<Announcement> announce = new ArrayList<Announcement>();
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		ResultSet rs = null;
		String dbQuery = "SELECT * FROM announcement";
		try
		{
			rs = mysql.readRequest(dbQuery);
				while(rs.next())
				{
					Announcement a = new Announcement(rs.getInt("announceID"),rs.getString("announceTopic"),rs.getString("announceContent"),rs.getString("announceDate"),rs.getInt("imageID"));
					announce.add(a);
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			mysql.terminate();
		}
		return announce;
	}
	
	public boolean updateAnnouncenet(int annonID,String annonTopic,String annonContent,String date)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		String dbQuery = "UPDATE announcement SET announceTopic = '" + annonTopic + "',' announceContent = '" + annonContent + "',' announceDate = '" + date +"' WHERE announceID = '" + annonID + "'";
		try{
			if(mysql.updateRequest(dbQuery) == 1)
			{
				success = true;
			}
		}catch(SQLException sqlErr)
		{
			System.out.println("Something went wrong with updating the annnouncements");
			sqlErr.printStackTrace();
		}finally
		{
			mysql.terminate();
		}
		return success;
	}
	
	public boolean deleteAnnouncement(int annonID)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		String dbQuery = "DELETE FROM announcement WHERE announceID = '" + annonID + "'";
		try
		{
			if(mysql.updateRequest(dbQuery) == 1)
			{
				success = true;
			}
		}catch(SQLException sqlErr)
		{
			System.out.println("Unable to delete record. Connection to DB terminated unexpectedly.");
			sqlErr.printStackTrace();
		}
		mysql.terminate();
		return success;
	}
}
