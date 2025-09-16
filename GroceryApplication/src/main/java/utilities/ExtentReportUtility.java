package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {//customized 3rd party tool to use avenstack for report generation , extent report class

	public static final ExtentReports extentReports = new ExtentReports();//static instance of extentreports that can be shared accross the application

	public synchronized static ExtentReports createExtentReports() {
		//Creates an instance of the reporter that will generate the HTML report in the path "./extent-reports/extent-report.html".
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //once the report is generated where the report needs to be saved 
		
		// the report needs to be saved as 7R Mart SuperMarket name
		reporter.config().setReportName("7R Mart SuperMarket");
		extentReports.attachReporter(reporter); //For attaching the folder  and report name to the class ExtentReports
		extentReports.setSystemInfo("Organization", "Obsqura");//to set the organization name
		extentReports.setSystemInfo("Name", " Sherin"); //provides context of the report and tester name)
		return extentReports;
	}
}
