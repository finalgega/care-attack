package blog;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.MySQLController;
/**
 * This Java Bean BlogPost provides the necessary accessor and mutator methods
 * to access the BlogPost object and utility methods to retrieve various data 
 * from the database and creating blogPosts
 * @author Hui Wen
 * @version 1.00a
 * @since 2012-09-16
 * @category Java Bean
 *
 */
public class BlogPost {

	private final String dsn = "CareAttack";
	private String title = null;
	private String content = null;
	private String date = null;
	private String username = null;
	
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

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public BlogPost(){}
	
	public BlogPost(String title, String content,String date, String username) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.username = username;
	}
	public BlogPost(String title){
		super();
		this.title=title;
	}
	
	/**
	 * Retrieves blogpost from database and stores into an ArrayList<BlogPost> 
	 * for further processing
	 * @return ArrayList<BlogPost>
	 */
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
	
	/**
	 * Retrieves all the blog titles from the database and stores them in 
	 * an ArrayList<BlogPost> for further processing.
	 * @return ArrayList<BlogPost>
	 */
	public ArrayList<BlogPost> retrieveBlogTitle()
	{
		ArrayList<BlogPost> retrieveBlogTitle = new ArrayList<BlogPost>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "Select blogTitle from blog";
		
		try{
			rs = mysql.readRequest(dbQuery);
				while(rs.next()){
					BlogPost rbt = new BlogPost(rs.getString("blogTitle"));
					retrieveBlogTitle.add(rbt);
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrieveBlogTitle;
	}
	/**
	 * Retrieves a specific post from the database based on a given title.
	 * Superseded by searchPost method 
	 * @deprecated
	 * @param title (String)
	 * @see blog.BlogPost#searchPost(String)
	 * @return BlogPost (String)
	 */
	@Deprecated
	public String retrieveSpecificPost(String title){
		ResultSet rs = null;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String dbQuery ="select * from blog where blogTitle ='";
		dbQuery += title + "'";
		rs = mysql.readRequest(dbQuery);
		try {
			if(rs.next()){
				title = rs.getString("title");
			}
		}
		catch(Exception e){e.printStackTrace();}
		mysql.terminate();
		return title;
	}
	
	/**
	 * @precondition User must enter valid input
	 * @param words
	 * @return ArrayList<BlogPost>
	 */
	public ArrayList<BlogPost> searchPost(String words)
	{
		String searchTerm = "%";
		searchTerm += words;
		searchTerm += "%";
		ArrayList<BlogPost> searchBlogPost = new ArrayList<BlogPost>();
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery = "SELECT blog.blogTitle , blog.blogContent,blog.date,account.username FROM careattack.blog INNER JOIN careattack.account ON blog.accID = account.accID WHERE blog.blogTitle LIKE '" + searchTerm + "' or blog.blogContent LIKE '" + searchTerm+ "'" ;
		
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
		mysql.setUp(dsn);
		String sql ="INSERT INTO blog(blogTitle, blogContent)";
		sql += "VALUES('" + title + "','" + content + "')";
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
}
