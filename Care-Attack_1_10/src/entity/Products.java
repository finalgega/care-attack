package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.*;
public class Products {
	private final String dsn = "careattack";
	private String productName = null;
	private String productDescription = null;
	private int productQuantity = 0;
	private String status = null;
	private String productID = null;
	
	public Products(){}
	
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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantity() {
		return productQuantity;
	}

	public void setQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Products(String productName, String productDescription, int productQuantity, String status)
	{
		this.productName = productName;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.status = status;
	}

	public boolean createProducts(int productQuantity, String productName, String productDescription, String status)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String sql ="INSERT INTO product(productQuantity, productName, productDescription, status)";
		sql += "VALUES('" + productQuantity + "','" + productName + "','" + productDescription + "','" + status +"')";
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
				Products p1 = new Products( productName, productDescription, productQuantity, status);
				product.add(p1);
				
				}
		}
		catch (Exception e)
		{e.printStackTrace();}
		db.terminate();
		return product;
	}
}
