package illness;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.MySQLController;

public class Illness {
    
    private int illnessID,medicineID;
    private String illnessName,illnessDescription,illnessCategory,severity;


	public Illness(String illnessName, String illnessDescription,
			String illnessCategory, String severity) {
		super();
		this.illnessName = illnessName;
		this.illnessDescription = illnessDescription;
		this.illnessCategory = illnessCategory;
		this.severity = severity;
	}

	public Illness(int illnessID, int medicineID, String illnessName,
			String illnessDescription, String illnessCategory, String severity) {
		super();
		this.illnessID = illnessID;
		this.medicineID = medicineID;
		this.illnessName = illnessName;
		this.illnessDescription = illnessDescription;
		this.illnessCategory = illnessCategory;
		this.severity = severity;
	}

	public int getIllnessID() {
		return illnessID;
	}

	public void setIllnessID(int illnessID) {
		this.illnessID = illnessID;
	}

	public int getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}

	public String getIllnessName() {
		return illnessName;
	}

	public void setIllnessName(String illnessName) {
		this.illnessName = illnessName;
	}

	public String getIllnessDescription() {
		return illnessDescription;
	}

	public void setIllnessDescription(String illnessDescription) {
		this.illnessDescription = illnessDescription;
	}

	public String getIllnessCategory() {
		return illnessCategory;
	}

	public void setIllnessCategory(String illnessCategory) {
		this.illnessCategory = illnessCategory;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	public boolean createIllness(int illnessID, int medicineID, String illnessName,
			String illnessDescription, String illnessCategory, String severity)
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		try
		{
			String dbQuery = "INSERT INTO illness VALUES('" + illnessID + "','" + medicineID + "','";
			dbQuery += illnessName + "','" + illnessDescription + "','" +illnessCategory + "','" + severity + "')";
			if(mysql.updateRequest(dbQuery) == 1)
			{
				success = true;
			}
		}catch(SQLException sqlErr)
		{
			System.out.println("Something went wrong with SQL!");
			sqlErr.printStackTrace();
		}catch(Exception err)
		{
			System.out.println("General Exception");
			err.printStackTrace();
		}finally
		{
			mysql.terminate();
		}
		return success;
	}
	
	public boolean createIllness()
	{
		boolean success = false;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		try
		{
			String dbQuery = "INSERT INTO illness(illnessName,illnessDescription,illnessCategory,severity) VALUES('";
			dbQuery += this.illnessName + "','" + this.illnessDescription + "','" +this.illnessCategory + "','" + this.severity + "')";
			if(mysql.updateRequest(dbQuery) == 1)
			{
				success = true;
			}
		}catch(SQLException sqlErr)
		{
			System.out.println("Something went wrong with SQL!");
			sqlErr.printStackTrace();
		}catch(Exception err)
		{
			System.out.println("General Exception");
			err.printStackTrace();
		}finally
		{
			mysql.terminate();
		}
		return success;	
	}
	
	public ArrayList<Illness> retrieveListOfIllness()
	{
		ArrayList<Illness> illnessArr = new ArrayList<Illness>();
		ResultSet rs = null;
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		try
		{
			String dbQuery = "SELECT * FROM illness;";
			rs = mysql.readRequest(dbQuery);
			while(rs.next())
			{
				Illness ill = new Illness(rs.getInt("illnessID"),rs.getInt("medicineID"),rs.getString("illnessName"),rs.getString("illnessDescription"),rs.getString("illnessCategory"),rs.getString("severity"));
				illnessArr.add(ill);
			}
		}catch(SQLException sqlErr)
		{
			System.out.println("Something went wrong with the SQL Excecution :(");
			sqlErr.printStackTrace();
		}catch(Exception err)
		{
			err.printStackTrace();
		}finally
		{
			mysql.terminate();
		}
		return illnessArr;
	}
	
	public boolean updateIllness(Illness ill)
	{
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		String dbQuery = "UPDATE illness";
		try
		{
			mysql.updateRequest(dbQuery);
		}catch(SQLException sqlErr)
		{
			sqlErr.printStackTrace();
		}finally
		{
			mysql.terminate();
		}
		return false;
	}

}
