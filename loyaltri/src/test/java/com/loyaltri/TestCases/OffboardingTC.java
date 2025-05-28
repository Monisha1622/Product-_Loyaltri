package com.loyaltri.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.loyaltri.objects.OffboardingObj;

public class OffboardingTC extends commonfunctions {
	  static String screenShot;

    @BeforeSuite
    public void report(){
        report = new ExtentSparkReporter("Reports/Offboarding.html");
        reports= new ExtentReports();
        reports.attachReporter(report);
        reports.setSystemInfo("<b>Application<b>", "<b>Loyaltri<b>");
		reports.setSystemInfo("<b>Module<b>", "<b>Offboarding<\b>");
		reports.setSystemInfo("<b>Author<b>", "<b> Cordova Testing Team<b>");

    }
   @Test(priority = 1)
	public void  Offboarding() throws Exception {
	FileInputStream stream = new FileInputStream("Config.properties"); 
	Properties properties = new Properties();
	properties.load(stream);
	
 		test = reports.createTest("Testcase for Offboarding Page ");
	PageFactory.initElements(driver,OffboardingObj.class);
	test.info("<b><font color = 'purple'>Test case-1 Verify the Offboarding is displayed </b>");
	OffboardingObj.CompanyOpt.click();
	test.pass("Settings Menu clicked");
	Thread.sleep(2000);
	 OffboardingObj.OffboardingOpt.click();
	Thread.sleep(2000);
	test.pass("Time  Menu clicked");

	test.info("<b><font color = 'purple'>Test case-2 Verify the Initate Offboarding page is displayed </b>");
	
	OffboardingObj.InitateOBOpt.click();
	test.pass("Initiate Offboarding Menu clicked");
	Thread.sleep(2000);
       String actHead = OffboardingObj.EmpoOffHead.getText();
		if (actHead.equals("Employee Offboarding")) {
					test.pass("Employee Offboarding page is displayed");
	 
				} else {
					test.fail("<font color='red'>Employee Offboarding page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		  
				}
		OffboardingObj.SearchEmpOB.sendKeys(properties.getProperty("EmpoName"));
		test.pass("Search Employee Menu clicked");
		Thread.sleep(1000);
		OffboardingObj.EmpCode.click();
		Thread.sleep(1000);
		test.pass("Search Employee Menu clicked");
		Thread.sleep(3000);
		OffboardingObj.SubmitDateOpt.click();
		test.pass("Submit Date Menu clicked");
		Thread.sleep(2000);
		OffboardingObj.DateVal.click();
		test.pass("Date Value clicked");
		Thread.sleep(1000);
		OffboardingObj.OffSaveBtn.click();
		test.pass("Offboarding Save & Continue button clicked");
		Thread.sleep(1000);
//Separation Mode page

	test.info("<b><font color = 'purple'>Test case-3 Verify the Separation Mode - Offboarding page is displayed </b>");
       String sepeMode = OffboardingObj.SeperationOpt.getText();
		if (sepeMode.equals("Separation Mode")) {
					test.pass("Separation Mode page is displayed");
	 
				} else {
					test.fail("<font color='red'>Separation Mode page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		  
				}
						Thread.sleep(3000);

		OffboardingObj.SeperationModeOpt.click();
		test.pass("Separation Mode Menu clicked");
		Thread.sleep(3000);
		OffboardingObj.voluntarySeperationOpt.click();
		test.pass("Voluntary Separation Mode clicked");
		Thread.sleep(3000);
		OffboardingObj.OffSaveBtn.click();
		test.pass("Offboarding Save & Continue button clicked");

//Leave Balance Details page 

	test.info("<b><font color = 'purple'>Test case-4 Verify the Leave Balance Details - Offboarding page is displayed </b>");
	 String LeaveDeatils = OffboardingObj.LeaveBalHead.getText();
		if (LeaveDeatils.equals("Leave Balance Details")) {
					test.pass("Leave Balance Details page is displayed");
	 
				} else {
					test.fail("<font color='red'>Leave Balance Details page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		  
				}

// Get the leave count value from the Leave Balance Details page
				String leaveCount = OffboardingObj.LeaveBalance.getText();
				test.info("<b><font color = 'purple'>Leave Count Value: </font></b>" + leaveCount);
				OffboardingObj.OffSaveBtn.click();
		test.pass("Offboarding Save & Continue button clicked");

//Rehire Eligibility page
	test.info("<b><font color = 'purple'>Test case-5 Verify the Rehire Eligibility - Offboarding page is displayed </b>");
	 String rehireEligi = OffboardingObj.RehireEligiOpt.getText();
		if (rehireEligi.equals("Rehire Eligibility")) {
					test.pass("Rehire Eligibility page is displayed");
	 
				} else {
					test.fail("<font color='red'>Rehire Eligibility page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		  
				}
		Thread.sleep(3000);
		OffboardingObj.OffSaveBtn.click();
		test.pass("Offboarding Save & Continue button clicked");
		Thread.sleep(3000);


		
		test.pass("Offboarding process completed successfully");
		
		reports.flush();






	





	}
@AfterTest
public void reportflush(){
	reports.flush();
}
	 public static String takeScreenshot(WebDriver driver, String screenshotName) throws Exception 
		 {
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			screenShot = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
			File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotfile, new File(screenShot));
			return screenShot;

		}
	 

}
