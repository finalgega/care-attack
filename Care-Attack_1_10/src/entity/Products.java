package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.*;
public class Products {
	private final String dsn = "careattack";
	private String productName = null;
	private String productDescription = null;
	private int price = 0;
	private int productQuantity = 0;
	private String status = null;
	private String productID = null;
	private int imageID = 0;
	
	public Products(){}
	
	
	public int getImageID() {
		return imageID;
	}


	public void setImageID(int imageID) {
		this.imageID = imageID;
	}


	public String getProductName() {
		return productName;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public Products(String productName, String productDescription, int productQuantity, String status, int price)
	{
		this.productName = productName;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.status = status;
		this.price = price;
	}


	public Products(String productName, String productDescription, int productQuantity, String status, int price, int imageID)
	{
		this.productName = productName;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.status = status;
		this.price = price;
		this.imageID = imageID;
	}

	public boolean createProducts(int productQuantity, String productName, String productDescription, String status, int price)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String sql ="INSERT INTO product(productQuantity, productName, productDescription, status, price)";
		sql += "VALUES('" + productQuantity + "','" + productName + "','" + productDescription + "','" + status + "','" + price  +"')";
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
	
	public boolean createProducts(int productQuantity, String productName, String productDescription, String status, int price,int imageID)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		String sql ="INSERT INTO product(productQuantity, productName, productDescription, status, price,imageID)";
		sql += "VALUES('" + productQuantity + "','" + productName + "','" + productDescription + "','" + status + "','" + price  +"','" + imageID + "')";
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
	
	
	
	public boolean updateQuantity(){
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String sql ="UPDATE product SET productQuantity = '" + productQuantity + "' WHERE productName = '" + productName + "'";
	
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
	
	
	
	public String retrieveProductID(){

		ResultSet rs = null;
		MySQLController db = new MySQLController();
		String dbQuery = "SELECT productID FROM product WHERE productName = '" + productName + "'";
		try{
			rs = db.readRequest (dbQuery);
			if(rs.next())
			{		
				productID = rs.getString("productID");
				
				}
			else
				System.out.print("NO ID FOUND");
		}
		catch (Exception e){e.printStackTrace();}
		db.terminate();
		return productID;
	}
	
	public ArrayList<Products> retrieveData(){

		ArrayList<Products> product = new ArrayList<Products>();
		ResultSet rs = null;
		MySQLController db = new MySQLController();
		String dbQuery = "SELECT * FROM product";
		db.setUp("careattack");
		try{
			rs = db.readRequest(dbQuery);
			while(rs.next())
			{		
				productQuantity = rs.getInt("productQuantity");
				productName = rs.getString("productName");
				productDescription = rs.getString("productDescription");
				status = rs.getString("status");
				price = rs.getInt("price");
				Products p1 = new Products( productName, productDescription, productQuantity, status, price, imageID);
				product.add(p1);
				
				}
		}
		catch (Exception e)
		{e.printStackTrace();}
		db.terminate();
		return product;
	}
}
