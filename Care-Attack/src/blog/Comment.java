package blog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	private String dsn = "CareAttack";
	
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
	 * @param int blogid 
	 * @return ArrayList<Comment> commentArrList
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

	
}
