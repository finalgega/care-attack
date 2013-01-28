package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.*;
public class Rental {
	private final String dsn = "careattack";
	private String name = null;
	private String nric = null;
	private String rentalName = null;
	private int rentalQuantity = 0;
	private String startDate = null;
	private String endDate = null;
	
	
	
	public Rental(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	
	public String getRentalName() {
		return rentalName;
	}


	public void setRentalName(String productName) {
		this.rentalName = productName;
	}


	public int getRentalQuantity() {
		return rentalQuantity;
	}


	public void setRentalQuantity(int rentalQuantity) {
		this.rentalQuantity = rentalQuantity;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public Rental(String name, String nric, String rentalName, int rentalQuantity, String startDate, String endDate)
	{
		this.name = name;
		this.nric = nric;
		this.rentalName = rentalName;
		this.rentalQuantity = rentalQuantity;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	public Products retrieveProduct(String productName){

		ResultSet rs = null;
		MySQLController db = new MySQLController();
		db.setUp();
		System.out.println("Product Name : " + productName);
		String dbQuery = "SELECT * FROM product WHERE productName = '" + productName + "'";
		System.out.println(" SQL Statement : " + dbQuery);
		try{
			rs = db.readRequest (dbQuery);
			if(rs.next())
			{		
				Products p = new Products(rs.getString("productName"),rs.getString("productDescription"), rs.getInt("productQuantity"), rs.getString("status"));
				
				return p;
			}
		}
		catch (Exception e){e.printStackTrace();}
		db.terminate();
		return null;
	}
	
	
		
	public boolean createRental(String name, String nric, String rentalName, int rentalQuantity, String startDate, String endDate)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String sql ="INSERT INTO rental(name, nric, rentalName, rentalQuantity, startDate, endDate)";
		sql += "VALUES('" + name + "','" + nric + "','" + rentalName + "','" + rentalQuantity + "','" + startDate +"','" + endDate +"')";
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
	
	/*public ArrayList<Products> retrieveData(){

		ArrayList<Products> product = new ArrayList<Products>();
		ResultSet rs = null;
		MySQLController db = new MySQLController();
		String dbQuery = "SELECT * FROM product";
		db.setUp("careattack");
		try{
			rs = db.readRequest(dbQuery);
			while(rs.next())
			{		
				quantity = rs.getString("productQuantity");
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
	}*/
}
