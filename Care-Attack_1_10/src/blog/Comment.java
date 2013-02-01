package blog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Cal;
import database.MySQLController;

/**
 * This Java bean Comment provides a set of of accessor and
 * mutator methods to access the Comment Object and provides
 * methods to retrieve comments from the database
 *
 * @author Aaron Goy Ding Xian
 * @version 1.0a
 * @category Java Bean
 * @since 2012-12-28
 */
public class Comment {
	
	private String comment;
	private String commenter;
	private String dsn = "careattack";
	
	public Comment(String comment, String commenter) {
		super();
		this.comment = comment;
		this.commenter = commenter;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	
	/**
	 * Retrieves comments from Database and stores into ArrayList
	 * 
	 * This method retrieveComments retrieves all the comments in the database and store them
	 * into an ArrayList for further processing
	 * 
	 * @return ArrayList<Comment> ArrayList of Comments
	 */
	public ArrayList<Comment> retrieveComments()
	{
		//	Need to think out a little more
		MySQLController mySQL = new MySQLController();
		mySQL.setUp();
		String dbQuery = "SELECT commentContent, username FROM comment com INNER JOIN accounts acc ON com.accID = acc.accID";
		ResultSet rs = null;
		ArrayList<Comment> commentArrList = new ArrayList<Comment>();
		try{
			rs = mySQL.readRequest(dbQuery);
			while(rs.next())
			{
				Comment com = new Comment(rs.getString("commentContent"), rs.getString("username"));
				commentArrList.add(com);
			}
		}catch(SQLException sqlErr)
		{
			sqlErr.printStackTrace();
		}finally
		{
			mySQL.terminate();
		}
		return commentArrList;
	}
	
	/**
	 * Gets comments and its author for a particular blog post.
	 * 
	 * This method retrieveComments serves to get comments and the author of
	 * the comments from the configured DB and table and store all the comments
	 * retrieved into an ArrayList<Comment> for ease of use
	 * @param blogid (int) 
	 * @return  commentArrList (ArrayList<Comment>)
	 */
	public ArrayList<Comment> retrieveComments(int blogid)
	{
		//@TODO
		MySQLController mySQL = new MySQLController();
		mySQL.setUp();
		String dbQuery = "SELECT blogID, commentContent, username FROM comment com INNER JOIN accounts acc ON com.accID = acc.accID WHERE blogID = '";
		dbQuery += blogid + "';";
		ResultSet rs = null;
		ArrayList<Comment> commentArr = new ArrayList<Comment>();
		try
		{
			rs = mySQL.readRequest(dbQuery);
			while(rs.next())
			{
				Comment cm = new Comment(rs.getString("commentContent"),rs.getString("username"));
				commentArr.add(cm);
			}
		}catch(SQLException sqlErr)
		{
			sqlErr.printStackTrace();
		}finally
		{
			mySQL.terminate();
		}
		return commentArr;
	}
	
	
	
public boolean createAComment(String comment,String username){
		
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
			String sql ="INSERT INTO comment(accID,commentContent,date)";
			sql += "VALUES('" + owner + "','" + comment +  "','" + date.dated() + "')";
		
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

	
}
