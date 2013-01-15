package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.*;
public class Products {
	private final String dsn = "CareAttack";
	private String productName = null;
	private String productDescription = null;
	private int quantity = 0;
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
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Products(String productName, String productDescription, int quantity, String status)
	{
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.status = status;
	}

	public boolean createProducts(int quantity, String productName, String productDescription, String status)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String sql ="INSERT INTO product(productQuantity, productName, productDescription, status)";
		sql += "VALUES('" + quantity + "','" + productName + "','" + productDescription + "','" + status +"')";
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
				quantity = rs.getInt("productQuantity");
				productName = rs.getString("productName");
				productDescription = rs.getString("productDescription");
				status = rs.getString("status");
				Products p1 = new Products( productName, productDescription,quantity, status);
				product.add(p1);
				
				}
		}
		catch (Exception e)
		{e.printStackTrace();}
		db.terminate();
		return product;
	}
}
