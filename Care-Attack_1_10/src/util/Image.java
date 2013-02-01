package util;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.MySQLController;

public class Image {

	private int imageID;
	private String path;
	private String imageDescription;
	public Image() {
	}
	public Image(int imageID, String path) {
		super();
		this.imageID = imageID;
		this.path = path;
	}
	public Image(int imageID, String path, String imageDescription) {
		super();
		this.imageID = imageID;
		this.path = path;
		this.imageDescription = imageDescription;
	}
	public int getImageID() {
		return imageID;
	}
	public void setImageID(int imageID) {
		this.imageID = imageID;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getImageDescription() {
		return imageDescription;
	}
	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}
	public String getImagePath(int imageID)
	{
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		String imagePath = null;
		String dbQuery = "SELECT imagePath FROM image WHERE imageID = '" + imageID + "'";
		System.out.println("What is my imageID : " + imageID);
		ResultSet rs = null;
		try
		{
			rs = mysql.readRequest(dbQuery);
			if(rs.next())
			{
			imagePath = "images/" + rs.getString("imagePath");
			}
		}catch(SQLException sqlErr)
		{
			sqlErr.printStackTrace();
		}
		return imagePath;
	}

}
