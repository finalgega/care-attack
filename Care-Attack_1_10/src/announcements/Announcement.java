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
	private final String dsn = "careattack";
	private String aTopic = null;
	private String aContent = null;
	private String aDate = null;
	
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

	/**
	 * Creates announcements and stores them in the database
	 * 
	 * @param aTopic (String)
	 * @param aContent (String)
	 * @param date (String)
	 * @return success (boolean)
	 * @throws SQLException
	 */
	public boolean createAnnouncement(String aTopic, String aContent, String date) throws SQLException
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String sql ="INSERT INTO announcement(announceTopic, announceContent,announceDate)";
		sql += "VALUES('" + aTopic + "','" + aContent + "','" + date + "')";
		if(mysql.updateRequest(sql) == 1)
		{
			success = true;
		}
		mysql.terminate();
		return success;
	}

	/**
	 * Retrieves all the announcements from database and stores them into
	 * an ArrayList<Announcement> for further processing
	 * 
	 * @return ArrayList<Announcement>
	 */
	public ArrayList<Announcement> retrieveAnnouncement()
	{
		ArrayList<Announcement> announce = new ArrayList<Announcement>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "SELECT * FROM announcement";
		try
		{
			rs = mysql.readRequest(dbQuery);
				while(rs.next())
				{
					Announcement a = new Announcement(rs.getString("announceTopic"),rs.getString("announceContent"),rs.getString("announceDate"));
					announce.add(a);
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return announce;
	}
}
