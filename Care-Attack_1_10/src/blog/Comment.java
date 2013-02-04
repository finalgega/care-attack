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
	private String count;
	private String title;	
	private String blogContent;	
	private String date;	
	private String accUsername;
	private String blogUsername;	
	private String accUsernameComment;
	private String blogid;
	private String dsn = "careattack";
	
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
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAccUsername() {
		return accUsername;
	}
	public void setAccUsername(String accUsername) {
		this.accUsername = accUsername;
	}
	public String getBlogUsername() {
		return blogUsername;
	}
	public void setBlogUsername(String blogUsername) {
		this.blogUsername = blogUsername;
	}
	public String getAccUsernameComment() {
		return accUsernameComment;
	}
	public void setAccUsernameComment(String accUsernameComment) {
		this.accUsernameComment = accUsernameComment;
	}
	public String getBlogid() {
		return blogid;
	}
	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}

	public Comment(String comment, String commenter) {
		super();
		this.comment = comment;
		this.commenter = commenter;
	}

	public Comment(){}
	
	public Comment(String count){
		this.count = count;
	}
	
	public Comment(String blogid,String title,String blogContent,String blogUsername,String date,String accUsernameComment){
		super();
		this.blogid = blogid;
		this.title = title;
		this.blogContent = blogContent;
		this.blogUsername= blogUsername;
		this.date = date;
		this.accUsernameComment = accUsernameComment;
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
	
	
	
public boolean createAComment(String blogid,String comment,String username){
		
		boolean success = false;
		ResultSet rs = null;
		MySQLController mysql = new MySQLController();
		String owner = null;
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
			String sql ="INSERT INTO comment(blogID,accID,commentContent)";
			sql += "VALUES('" + blogid + "','" + owner + "','" + comment +  "')";
		
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


public ArrayList<Comment> retrieveCommentCount(String blogid)
{
	//@TODO
	/*String searchTerm = "%";
	searchTerm += blogid;
	searchTerm += "%";*/
	MySQLController mySQL = new MySQLController();
	mySQL.setUp();
	String dbQuery = "select count(blogID) from comment where blogID = '" + blogid + "'";
	ResultSet rs = null;
	ArrayList<Comment> commentBlog = new ArrayList<Comment>();
	try
	{
		rs = mySQL.readRequest(dbQuery);
		while(rs.next())
		{
			count = rs.getString("count(blogID)");
			Comment cc = new Comment(count);
			commentBlog.add(cc);
		}
	}catch(SQLException sqlErr)
	{
		sqlErr.printStackTrace();
	}finally
	{
		mySQL.terminate();
	}
	return commentBlog;
}

public ArrayList<Comment> searchPost(String words)
{
	String searchTerm = "%";
	searchTerm += words;
	searchTerm += "%";
	ArrayList<Comment> searchPost = new ArrayList<Comment>();
	MySQLController mysql = new MySQLController();
	mysql.setUp(dsn);
	ResultSet rs = null;
	String dbQuery = "select blog.blogID, blog.blogTitle,blog.blogContent,account.username,blog.date,group_concat(account.username, ' : ' ,commentContent) from blog inner join comment on blog.blogID = comment.blogID inner join account on blog.accID = account.accID  group by blog.blogID where blog.blogTitle LIKE '" + searchTerm + "' or blog.blogContent LIKE '" + searchTerm+ "'" ;
	
	try{
		rs = mysql.readRequest(dbQuery);
			while(rs.next()){
				blogid = rs.getString("blog.blogID");
				title = rs.getString("blog.blogTitle");
				blogContent = rs.getString("blog.blogContent");
				blogUsername = rs.getString("account.username");
				date = rs.getString("blog.date");
				accUsernameComment = rs.getString("group_concat(account.username, ' : ' ,commentContent)");
				Comment search = new Comment(blogid,title,blogContent,blogUsername,date,accUsernameComment);
				searchPost.add(search);
				}
	}catch(Exception e){
		e.printStackTrace();
	}
	return searchPost;
}

	
}
