package blog;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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

	
	
	public ArrayList<BlogPost> retrieveBlogTitle()
	{
		ArrayList<BlogPost> retrieveTitle = new ArrayList<BlogPost>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "select blogTitle from careattack.blog group by blog.blogID";
		
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
	
	public ArrayList<BlogPost> searchTitle(String words)
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
	
	public boolean createABlogPost(String title, String content)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		Cal date = new Cal();
		mysql.setUp(dsn);
		String sql ="INSERT INTO blog(blogTitle, blogContent, accID,date)";
		sql += "VALUES('" + title + "','" + content + "','" + 2 + "','" + date.dated() + "')";
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
	
	/*
	public BlogPost anyItem(ArrayList<BlogPost> retrieveBlogTitle){
		int index = randomGenerator.nextInt(retrieveBlogTitle.size());
		if(index >-1)
			return retrieveBlogTitle.get(index);
		return retrieveBlogTitle.get(index);
	}
	
	public  BlogPost selectItems( ArrayList<BlogPost> retrieveBlogTitle) {
		Collections.shuffle(retrieveBlogTitle);
		return retrieveBlogTitle;
	}
	*/
	
	/*public BlogPost removeDup(ArrayList<BlogPost> retrieveBlogTitle){
		retrieveBlogTitle = new ArrayList<BlogPost>(new LinkedHashSet<String>retrieveBlogTitle);
	}*/
}
