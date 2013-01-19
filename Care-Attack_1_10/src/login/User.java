package login;

import java.security.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.MySQLController;
/**
 * This java bean class provides the necessary accessor and mutator methods to access
 * the data stored in User objects as well as methods to facilitate the creation of 
 * User accounts, checking if the account exists and obtaining the privilege level of
 * user account
 * @author Aaron Goy Ding Xian
 * @since 2012-09-10
 * @category Java Bean
 */
public class User {
	
	private String username = null;
	private String password = null;
	private String email = null;
	private String secret = null;
	private String secretAnswer = null;
	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	private final String dsn = "careattack";
	// Profile Picture
	
	public User()
	{
		
	}

	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public User(String username, String password, String email, String secret) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.secret = secret;
	}

	public User(String username, String password, String email, String secret,
			String secretAnswer) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.secret = secret;
		this.secretAnswer = secretAnswer;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	/**
	 * Creates a user record based on the given username,password and email
	 * @param username (String)
	 * @param password (String)
	 * @param email (String
	 * @return success (boolean)
	 */
	public boolean createUser(String username, String password, String email)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String dbQuery = "INSERT INTO account(username,pwd,email) VALUES('"+ username + "','";
				dbQuery += password + "','" + email + "')";
		try {
			if(mysql.updateRequest(dbQuery) == 1)
			{
				success = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
	/**
	 * @see login.User#createUser(String, String, String)
	 * @param username
	 * @param password
	 * @param email
	 * @param secret
	 * @return
	 */
	public boolean createUser(String username, String password, String email, String secret)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String dbQuery = "INSERT INTO account(username,pwd,email,secretQuestion) VALUES('"+ username + "','";
				dbQuery += password + "','" + email + "','" + secret +"')";
		try {
			if(mysql.updateRequest(dbQuery) == 1)
			{
				success = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	
	/**
	 * Gets information about the user
	 * @param username
	 * @return userAccount (User)
	 */
	public User getUserInfo(String username)
	{
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String dbQuery = "SELECT * FROM account WHERE username = '" + username + "'";
		ResultSet rs = null;
		User userAcc = null;
		try
		{
			rs = mysql.readRequest(dbQuery);
			if(rs.next())
			{
				userAcc = new User(username,rs.getString("pwd"),rs.getString("email"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return userAcc;
	}

	/**
	 * Checks if user record exists in the database
	 * @param username
	 * @param password
	 * @return success (boolean)
	 */
	public boolean isExist(String username,String password)
	{
		boolean result = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String dbQuery = "SELECT * FROM account WHERE username = '" + username + "' and pwd = SHA('" + password + "')";
		ResultSet rs = null;
		try
		{
			rs = mysql.readRequest(dbQuery);
			if(rs.next())
			{
				result = true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Gets privilege level of the user
	 * @param username
	 * @return privilege level (String)
	 */
	public String getPrivilegeLevel(String username)
	{
		String privilege = "user";
		String user = username;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String dbQuery = "SELECT privilege FROM account WHERE username = '"+user + "'";
		ResultSet rs = null;
		try
		{
			rs = mysql.readRequest(dbQuery);
			if(rs.next())
			{
				privilege = rs.getString("privilege");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return privilege;
	}

}
