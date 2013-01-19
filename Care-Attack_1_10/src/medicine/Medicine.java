package medicine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.MySQLController;

public class Medicine {


    private int medicineID,timesperDay;
    private String medicineName, medicineDescription,sideEffects,instructions,allergy;
	public Medicine() {
		// TODO Auto-generated constructor stub
	}
    
    public Medicine(int medicineID,String medicineName,String medicineDescription,String sideEffects,String instructions, String allergy)
    {
        this.medicineID = medicineID;
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
        this.sideEffects = sideEffects;
        this.instructions = instructions;
        this.allergy = allergy;
    }
    
    public Medicine(String medicineName,String medicineDescription,String sideEffects,String instructions,int timesperDay,String allergy)
    {
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
        this.sideEffects = sideEffects;
        this.instructions = instructions;
        this.timesperDay = timesperDay;
        this.allergy = allergy;
    }
    public Medicine(int medicineID,String medicineName,String medicineDescription,String sideEffects,String instructions,int timesperDay,String allergy)
    {
    	this.medicineID = medicineID;
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
        this.sideEffects = sideEffects;
        this.instructions = instructions;
        this.timesperDay = timesperDay;
        this.allergy = allergy;
    }
    
    public int getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}

	public int getTimesperDay() {
		return timesperDay;
	}

	public void setTimesperDay(int timesperDay) {
		this.timesperDay = timesperDay;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineDescription() {
		return medicineDescription;
	}

	public void setMedicineDescription(String medicineDescription) {
		this.medicineDescription = medicineDescription;
	}

	public String getSideEffects() {
		return sideEffects;
	}

	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public boolean createMedicine(Medicine med)
    {
    	boolean success = false;
        MySQLController mysql = new MySQLController();
        mysql.setUp();
        String dbQuery = "INSERT INTO medicine(medicineName,medicineDescription,sideEffects,instructions,timesperDay) VALUES('" + med.medicineName  + "','" + med.medicineDescription + "','";
        dbQuery += med.sideEffects + "','" + med.instructions + "','" + med.timesperDay +"')";
        try{
        if(mysql.updateRequest(dbQuery) == 1)
        {
        	success = true;
        }
        }catch(SQLException sqlErr)
        {
        	sqlErr.printStackTrace();
        	System.out.println("Couldn't create record!");
        }
        return success;
    }
    
    public ArrayList<Medicine> retrieveMedicine()
    {
    	 ArrayList<Medicine> medArr = new ArrayList<Medicine>();
    	 String dbQuery = "SELECT * FROM medicine";
    	 MySQLController mysql = new MySQLController();
    	 mysql.setUp();
    	 ResultSet rs;
    	 try
    	 {
    		 rs = mysql.readRequest(dbQuery);
    		 while(rs.next())
    		 {
    			 Medicine med = new Medicine(rs.getInt("medicineID"),rs.getString("medicineName"),rs.getString("medicineDescription"),rs.getString("sideEffects"),rs.getString("instructions"),rs.getInt("timesperDay"),rs.getString("allergy"));
    			 medArr.add(med);
    		 }
    	 }catch(SQLException sqlErr)
    	 {
    		 sqlErr.printStackTrace();
    		 System.out.println("Something went wrong : ( Can't retrieve data");
    	 }
    	 return medArr;
    }
    
    public boolean updateMedicine(Medicine med)
    {
    	return false;
    }
    

}
