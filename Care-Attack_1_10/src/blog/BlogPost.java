package blog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import util.*;
import database.MySQLController;

public class BlogPost {
	
	private final static String dsn = "careattack";
	private String title = null;
	private String content = null;
	private String date = null;
	private String accUsernameComment = null;
	private String accUsername = null;
	private String count = null;
	private String blogUsername = null;
	private String blogid = null; 
	private String comment = null;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAccUsernameComment() {
		return accUsernameComment;
	}

	public void setAccUsernameComment(String accUsernameComment) {
		this.accUsernameComment = accUsernameComment;
	}

	public String getAccUsername() {
		return accUsername;
	}

	public void setAccUsername(String accUsername) {
		this.accUsername = accUsername;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getBlogUsername() {
		return blogUsername;
	}

	public void setBlogUsername(String blogUsername) {
		this.blogUsername = blogUsername;
	}

	public String getBlogid() {
		return blogid;
	}

	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BlogPost(){}
	
	public BlogPost(String blogid,String title,String content,String blogUsername,String date,String accUsernameComment){
		super();
		this.blogid = blogid;
		this.title = title;
		this.content = content;
		this.blogUsername= blogUsername;
		this.date = date;
		this.accUsernameComment = accUsernameComment;
	}
	
	public BlogPost(String blogid,String title,String content,String blogUsername,String date){
		super();
		this.blogid = blogid;
		this.title = title;
		this.content = content;
		this.blogUsername= blogUsername;
		this.date = date;
	}
	
	public BlogPost(String title,String count){
		super();
		this.title=title;
		this.count = count;
	}
	
	public BlogPost(String title){
		super();
		this.title= title;
	}
	
	/*public BlogPost(String accUsernameComment,String count){
		super();
		this.accUsernameComment = accUsernameComment;
		this.count = count;
	}*/
	
	public ArrayList<BlogPost> retrieveSelectedBlogTitle()
	{
		ArrayList<BlogPost> retrieveSelectedTitle = new ArrayList<BlogPost>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "select blogTitle from careattack.blog group by blogID order by rand() limit 3";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					BlogPost rbt = new BlogPost(rs.getString("blogTitle"));
					retrieveSelectedTitle.add(rbt);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveSelectedTitle;
	}
	
	public ArrayList<BlogPost> retrieveAllBlogTitle()
	{
		ArrayList<BlogPost> retrieveAllTitle = new ArrayList<BlogPost>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "select blogTitle from careattack.blog group by blogID";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					BlogPost rbt = new BlogPost(rs.getString("blogTitle"));
					retrieveAllTitle.add(rbt);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveAllTitle;
	}
	
	/*public ArrayList<BlogPost> retrieveBlogPost()
	{
		ArrayList<BlogPost> retrieveBlogPost = new ArrayList<BlogPost>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "Select blog.blogID, blog.blogTitle , blog.blogContent,blog.date,account.username from careattack.blog inner join careattack.account on blog.accID = account.accID";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					BlogPost rbp = new BlogPost(rs.getString("blog.blogID"),rs.getString("blog.blogTitle"),rs.getString("blog.blogContent"),rs.getString("blog.date"),rs.getString("account.username"));
					retrieveBlogPost.add(rbp);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveBlogPost;
	}*/

	public ArrayList<BlogPost> retrieveTopRatedBlogTitle()
	{
		ArrayList<BlogPost> retrieveTopRatedTitle = new ArrayList<BlogPost>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "select blog.blogTitle, count(comment.commentID) from careattack.comment inner join careattack.blog on blog.blogID = comment.blogID  group by comment.blogID ;";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					title = rs.getString("blog.blogTitle");
					count = rs.getString("count(comment.commentID)");
					BlogPost rbt = new BlogPost(title,count);
					retrieveTopRatedTitle.add(rbt);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveTopRatedTitle;
	}
	

public boolean createABlogPost(String title, String content,String username){
		
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
			String sql ="INSERT INTO blog(blogTitle, blogContent, accID,date)";
			sql += "VALUES('" + title + "','" + content + "','" + owner + "','" + date.dated() + "')";
		
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

public ArrayList<BlogPost> retrieveBlog()
{
	ArrayList<BlogPost> retrieveBlog = new ArrayList<BlogPost>();
	MySQLController mysql = new MySQLController();
	mysql.setUp(dsn);
	ResultSet rs = null;
	String dbQuery = "select blog.blogID, blog.blogTitle,blog.blogContent,account.username,blog.date,group_concat(account.username, ' : ' ,commentContent , '     ') from comment  inner join account on comment.accID = account.accID inner join blog on comment.blogID = blog.blogID  group by blog.blogID";
	
	try{
		rs = mysql.readRequest(dbQuery);
			while(rs.next()){
				blogid = rs.getString("blog.blogID");
				title = rs.getString("blog.blogTitle");
				content = rs.getString("blog.blogContent");
				blogUsername = rs.getString("account.username");
				date = rs.getString("blog.date");
				accUsernameComment = rs.getString("group_concat(account.username, ' : ' ,commentContent , '     ')");
				BlogPost com = new BlogPost(blogid,title,content,blogUsername,date,accUsernameComment);
				retrieveBlog.add(com);
				}
	}catch(Exception e){
		e.printStackTrace();
	}
	return retrieveBlog;
}

public ArrayList<BlogPost> retrievePostTitle(String title)
{
	ArrayList<BlogPost> retrieveBlog = new ArrayList<BlogPost>();
	MySQLController mysql = new MySQLController();
	mysql.setUp(dsn);
	ResultSet rs = null;
	String dbQuery = "select blog.blogID, blog.blogTitle,blog.blogContent,account.username,blog.date,group_concat(account.username, ' : ' ,commentContent , '     ') from comment  inner join account on comment.accID = account.accID inner join blog on comment.accID = blog.accID where blog.blogTitle = '" + title + "' group by blog.blogID";
	
	try{
		rs = mysql.readRequest(dbQuery);
			while(rs.next()){
				blogid = rs.getString("blog.blogID");
				title = rs.getString("blog.blogTitle");
				content = rs.getString("blog.blogContent");
				blogUsername = rs.getString("account.username");
				date = rs.getString("blog.date");
				accUsernameComment = rs.getString("group_concat(account.username, ' : ' ,commentContent , '     ')");
				BlogPost com = new BlogPost(blogid,title,content,blogUsername,date,accUsernameComment);
				retrieveBlog.add(com);
				}
	}catch(Exception e){
		e.printStackTrace();
	}
	return retrieveBlog;
}

}