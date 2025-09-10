package constant;

public class Constants { //constant classs is used to save values that doesn't change 
	public static final String TESTDATAFILE = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	//System.getProperty("user.dir") = to point to current directory or folder 
//constant name is given as capital
	
	public static final String LOGINSHEET = "LoginPage";//loginsheet is a variable to save the sheet name of excel file
	//this value should not be changed so the variable is declared as static final
	
	
	public static final String HOMESHEET = "HomePage";//second tab name of excel sheet is saved here.

//Also create a home page sheet
}

