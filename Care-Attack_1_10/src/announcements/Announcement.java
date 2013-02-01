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
	private String aTopic = null;
	private String aContent = null;
	private String aDate = null;
	private int aID = 0;
	private int aImageID = 0;
	
	public Announcement()
	{
		
	}
	
	public Announcement(String aTopic, String aContent)
	{
		this.aTopic = aTopic;
		this.aContent = aContent;
	}
	
	public Announcement(String aTopic, String aContent, String date)
	{
		this.aTopic = aTopic;
		this.aContent = aContent;
		this.aDate = date;
	}
	
	public Announcement(int aID,String aTopic,String aContent,String date)
	{
		this.setaID(aID);
		this.aTopic = aTopic;
		this.aContent = aContent;
		this.aDate = date;
	}
	
	public Announcement(int aID,String aTopic,String aContent,String date,int aImageID)
	{
		this.setaID(aID);
		this.aTopic = aTopic;
		this.aContent = aContent;
		this.aDate = date;
		this.setaImageID(aImageID);
	}
	
	/**
	 * @return the aID
	 */
	public int getaID() {
		return aID;
	}

	/**
	 * @param aID the aID to set
	 */
	public void setaID(int aID) {
		this.aID = aID;
	}

	public String getaTopic() {
		return aTopic;
	}

	public void setaTopic(String aTopic) {
		this.aTopic = aTopic;
	}

	public String getaContent() {
		return aContent;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent;
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
	 * @param aTopic (String)
	 * @param aContent (String)
	 * @param date (String)
	 * @param imageID 
	 * @return success (boolean)
	 * @throws SQLException
	 */
	public boolean createAnnouncement(String aTopic, String aContent, String date, int imageID) throws SQLException
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		String sql ="INSERT INTO announcement(announceTopic, announceContent,announceDate,imageID)";
		sql += "VALUES('" + aTopic + "','" + aContent + "','" + date + "','" + imageID +"')";
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
		}
		return annonIDs;
		
	}
	public Announcement retrieveAnnouncement(int aID)
	{
		Announcement annon = null;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		ResultSet rs = null;
		String dbQuery = "SELECT * FROM announcement WHERE announceID = '" + aID + "'";
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
		return announce;
	}
	
	public boolean deleteAnnouncement(int aID)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		String dbQuery = "DELETE FROM announcement WHERE announceID = '" + aID + "'";
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
		return success;
	}
}
