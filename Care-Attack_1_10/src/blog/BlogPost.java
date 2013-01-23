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
	private String username = null;
	private String count = null;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public BlogPost(){}
	
	public BlogPost(String title, String content,String date, String username) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.username = username;
	}
	public BlogPost(String title,String count){
		super();
		this.title=title;
		this.count = count;
	}
	
	public BlogPost(String title){
		super();
		this.title = title;
	}
	

	public ArrayList<BlogPost> retrieveBlogTitle()
	{
		ArrayList<BlogPost> retrieveTitle = new ArrayList<BlogPost>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "select distinct blogTitle from careattack.blog group by blogID order by rand() limit 3";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					BlogPost rbt = new BlogPost(rs.getString("blogTitle"));
					retrieveTitle.add(rbt);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveTitle;
	}
	
	public ArrayList<BlogPost> retrieveBlogPost()
	{
		ArrayList<BlogPost> retrieveBlogPost = new ArrayList<BlogPost>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "Select blog.blogTitle , blog.blogContent,blog.date,account.username from careattack.blog inner join careattack.account on blog.accID = account.accID";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					BlogPost rbp = new BlogPost(rs.getString("blog.blogTitle"),rs.getString("blog.blogContent"),rs.getString("blog.date"),rs.getString("account.username"));
					retrieveBlogPost.add(rbp);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveBlogPost;
	}

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

	public ArrayList<BlogPost> searchPost(String words)
	{
		String searchTerm = "%";
		searchTerm += words;
		searchTerm += "%";
		ArrayList<BlogPost> searchBlogPost = new ArrayList<BlogPost>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "select blog.blogTitle , blog.blogContent,blog.date,account.username from careattack.blog inner join careattack.account on blog.accID = account.accID where blog.blogTitle LIKE '" + searchTerm + "' or blog.blogContent LIKE '" + searchTerm+ "'" ;
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					BlogPost rbp = new BlogPost(rs.getString("blog.blogTitle"),rs.getString("blog.blogContent"),rs.getString("blog.date"),rs.getString("account.username"));
					searchBlogPost.add(rbp);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchBlogPost;
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

}