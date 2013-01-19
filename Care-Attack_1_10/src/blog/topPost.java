package blog;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import database.MySQLController;

public class topPost {

	private final static String dsn = "CareAttack";
	private String title = null;
	private String content = null;
	private String date = null;
	private String username = null;
	private String count = null;
	private Random randomGenerator;
	private ArrayList<BlogPost> blog;
	

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
	
	
	public topPost(){}
	
	public BlogPost anyItem(ArrayList<BlogPost> retrieveBlogTitle){
		int index = randomGenerator.nextInt(retrieveBlogTitle.size());
		if(index >-1)
			return retrieveBlogTitle.get(index);
		/*int index = randomGenerator.nextInt(blog.size());
		BlogPost post = blog.get(index);
		return post;*/
		return retrieveBlogTitle.get(index);
	}
	
	public topPost(String title, String content,String date, String username,String count) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.username = username;
		this.count= count;
	}
	
	public topPost(String title, String content,String date, String username) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.username = username;
	}
	public topPost(String count){
		super();
		this.count=count;
	}

	
	public ArrayList<topPost> getblogCount(){
		ArrayList<topPost> retrieveNoOfComment = new ArrayList<topPost>();
		//ArrayList<topPost> retrieveTopRatedPost = new ArrayList<topPost>();
		//String blogID = null;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		ResultSet rs = null;
		String dbQuery ="select count(comment.commentID) from careattack.comment group by comment.blogID ";
		
		try {
			rs = mysql.readRequest(dbQuery);
			while(rs.next()){
				topPost count = new topPost(rs.getString("count(comment.commentID)"));
				retrieveNoOfComment.add(count);
			}
		}
		catch(Exception e){e.printStackTrace();}
		return retrieveNoOfComment;
}

}
