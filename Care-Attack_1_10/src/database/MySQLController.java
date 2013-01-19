package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * This class MySQLController provides the necessary utility methods
 * to set up a connection to the database and to parse querys to the database
 * for CRUD operations
 * @author Aaron Goy Ding Xian
 * @version 2.0
 * @since 2012-09-01
 * @category utility
 */
public class MySQLController {
	private Connection con;
	private final String sqlUserID = "root";	 //	Simply change to the appropriate userID to connect to DB
	private final String sqlPwd = "it2299care";	//	Simply change to the appropriate pwd to connect to the Db
	
	/**
	 * Sets up connection to database
	 * 
	 * This method setUp removes the need to configure the dsn over and over
	 * again in each java bean that establishes a connection to the db
	 * Allowing one to just edit the data source name (DB) at only one
	 * point. This should be used if one needs to connect to several different
	 * databases.
	 *
	 * @return void
	 */
	public void setUp()
	{
		final String dsn = "careattack";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e)
		{
			System.out.println("Load Driver Error");
			e.printStackTrace();
		}
		try
		{
			//String src = "jdbc:mysql://localhost:3306/" + dsn;
			String src = "jdbc:mysql://it2299care.cyjvphgjvodb.ap-southeast-1.rds.amazonaws.com:3306/" + dsn;
			con = DriverManager.getConnection(src,sqlUserID,sqlPwd);
		}catch(Exception conErr)
		{
			conErr.printStackTrace();
		}
	}
	/**
	 * Method Name: SetUp Input Parameter: String (Data Source Name) 
	 * 
	 * Purpose :
	 * Load the database driver and establish connection
	 * @see database.MySQLController#setUp()
	 * @param dsn (String)
	 * @return void
	 */
	public void setUp(String dsn) {
		// load the database driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println("Load driver error!");
			// after loading driver, establish connection
		}
		try {
			//	For Testing Server
			//String s = "jdbc:mysql://localhost:3306/" + dsn;
			//	For Production Server
			String s = "jdbc:mysql://it2299care.cyjvphgjvodb.ap-southeast-1.rds.amazonaws.com:3306/" + dsn;
			con = DriverManager.getConnection(s, sqlUserID, sqlPwd); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method Name : Read Request Input Parameter : String (database query)
	 * Purpose : Obtain the result set from the db query Return : resultset
	 * (records from query)
	 * @return rs (ResultSet) 
	 * @throws SQLException
	 */
	public ResultSet readRequest(String dbQuery) throws SQLException {
		ResultSet rs = null;
		try {
			// Creates statement obj
			Statement stmt = con.createStatement();
			// executes an SQL query and get the result
			rs = stmt.executeQuery(dbQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Update Request to database
	 * Purpose : Execute update using dbQuery
	 * @param dbQuery (String)
	 * @return count (int) [count == 1 if query was executed successfully]
	 */
	public int updateRequest(String dbQuery) throws SQLException {
		int count = 0;
		try {
			Statement stmt = con.createStatement();
			count = stmt.executeUpdate(dbQuery);
			System.out.println(count);
		} catch (SQLException sqlErr) {
			System.out.println("Update Request Error!");
			sqlErr.printStackTrace();
		}
		return count;
	}

	/**
	 * Closes the database connection
	 * @return void
	 */
	public void terminate() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// End of MySQLController

}
