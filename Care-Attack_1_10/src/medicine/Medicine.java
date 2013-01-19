package medicine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.MySQLController;
/**
 * This java bean Medicine provides the necessary accessor and mutator methods
 * to access the Medicine Object and provides instance methods to perform
 * CRUD functions on the database schema
 * @author macpro
 * @category Java Bean
 */
public class Medicine {


    private int medicineID,timesperDay;
    private String medicineName, medicineDescription,contraindications,instructions,sideEffects;
	public Medicine() {
	}
    
    public Medicine(int medicineID,String medicineName,String medicineDescription,String contraindications,String instructions, String sideEffects)
    {
        this.medicineID = medicineID;
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
        this.contraindications = contraindications;
        this.instructions = instructions;
        this.sideEffects = sideEffects;
    }
    
    public Medicine(String medicineName,String medicineDescription,String contraindications,String instructions,int timesperDay,String sideEffects)
    {
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
        this.contraindications = contraindications;
        this.instructions = instructions;
        this.timesperDay = timesperDay;
        this.sideEffects = sideEffects;
    }
    public Medicine(int medicineID,String medicineName,String medicineDescription,String contraindications,String instructions,int timesperDay,String sideEffects)
    {
    	this.medicineID = medicineID;
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
        this.contraindications = contraindications;
        this.instructions = instructions;
        this.timesperDay = timesperDay;
        this.sideEffects = sideEffects;
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

	public String getContraindications() {
		return contraindications;
	}

	public void setContraindications(String contraindications) {
		this.contraindications = contraindications;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getSideEffects() {
		return sideEffects;
	}

	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}

	public boolean createMedicine(Medicine med)
    {
    	boolean success = false;
        MySQLController mysql = new MySQLController();
        mysql.setUp();
        String dbQuery = "INSERT INTO medicine(medicineName,medicineDescription,contraindications,instructions,timesperDay) VALUES('" + med.medicineName  + "','" + med.medicineDescription + "','";
        dbQuery += med.contraindications + "','" + med.instructions + "','" + med.timesperDay +"')";
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
    
	/**
	 * This method createMedicine prepares a SQL statement to create a medicine record in the database
	 * @param medicineName
	 * @param medicineDescription
	 * @param contraindications
	 * @param instructions
	 * @param timesPerDay
	 * @return success (boolean)
	 */
	public boolean createMedicine(String medicineName,String medicineDescription,String contraindications,String instructions,int timesPerDay)
    {
    	boolean success = false;
        MySQLController mysql = new MySQLController();
        mysql.setUp();
        String dbQuery = "INSERT INTO medicine(medicineName,medicineDescription,contraindications,instructions,timesperDay) VALUES('" + medicineName  + "','" + medicineDescription + "','";
        dbQuery += contraindications + "','" + instructions + "','" + timesPerDay +"')";
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
	
	/**
	 * This method retrieveMedicine gets the entire medicine db schema
	 * and wraps it in an ArrayList<Medicine> and returns it for further
	 * processing.
	 * @return medicineArrayList (ArrayList<Medicine>)
	 */
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
    			 Medicine med = new Medicine(rs.getInt("medicineID"),rs.getString("medicineName"),rs.getString("medicineDescription"),rs.getString("contraindications"),rs.getString("instructions"),rs.getInt("timesperDay"),rs.getString("sideEffects"));
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
