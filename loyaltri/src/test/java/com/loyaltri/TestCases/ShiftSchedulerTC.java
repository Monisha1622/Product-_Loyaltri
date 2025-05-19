
package com.loyaltri.TestCases;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import com.loyaltri.objects.ShiftSchedulerObj;


public class ShiftSchedulerTC extends commonfunctions {

    static String screenShot;


	@BeforeSuite
	
	public void report() {
		report = new ExtentSparkReporter("Reports/Shift Scheduler.html");
		reports = new ExtentReports();
		reports.attachReporter(report);
        reports.setSystemInfo("<b>Application<b>", "<b>Loyaltri<b>");
		reports.setSystemInfo("<b>Module<b>", "<b>Shift Scheduler<\b>");
		reports.setSystemInfo("<b>Author<b>", "<b> Cordova Testing Team<b>");

	}


	@Test(priority = 1)
	public void eventlist() throws Exception {
	FileInputStream stream = new FileInputStream("Config.properties"); 
	Properties properties = new Properties();
	properties.load(stream);
	
 //for give the default value
	
		Faker faker = new Faker();          
 		test = reports.createTest("Testcase for Shift Scheduler Page ");
		PageFactory.initElements(driver,ShiftSchedulerObj.class);
	test.info("<b><font color = 'purple'>Test case-1 Verify the Shift Scheduler page is displayed </b>");
	ShiftSchedulerObj.ShiftSchedsettings.click();
	test.pass("Settings Menu clicked");
	Thread.sleep(2000);
	ShiftSchedulerObj.TimeShiftSche.click();
	Thread.sleep(2000);
    test.pass("Time  Menu clicked");
	Thread.sleep(2000);
	ShiftSchedulerObj.ShiftScheOpt.click();
	test.pass("Shfit Schedular option is clicked");
	Thread.sleep(2000);

	// ShiftSchedulerObj.StartDate.click();
	// test.pass("Deduction DroprDown clicked successfully");
	// Thread.sleep(2000);
	ShiftSchedulerObj.StartDate.sendKeys(properties.getProperty("StartDate"));
	test.pass("Start Date is entered successfully");
	Thread.sleep(2000);

	ShiftSchedulerObj.EndDate.sendKeys(properties.getProperty("EndDate"));
	test.pass("End Date is entered successfully");
	Thread.sleep(2000);
	ShiftSchedulerObj.ShiftScheOpt.click();
	test.pass("Shift Schedular Header is clicked successfully");
	Thread.sleep(2000);
	for (int i = 0; i < ShiftSchedulerObj.ShiftScheHeDrop.size(); i++) {
		if (ShiftSchedulerObj.ShiftScheHeDrop.get(i).getText().equalsIgnoreCase(properties.getProperty("DeductionType1"))) {
			ShiftSchedulerObj.ShiftScheHeDrop.get(i).click();
		break;	  
}
}




		
    }








@AfterSuite
public void reportflush() {
    
    reports.flush();
}


/*
 * Code for taking Screenshot
 */


 public static String takeScreenshot(WebDriver driver, String screenshotName) throws Exception 
 {
    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    screenShot = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
    File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenshotfile, new File(screenShot));
    return screenShot;

}

@AfterTest
public void close() {
    
    driver.close();

}



    
}
