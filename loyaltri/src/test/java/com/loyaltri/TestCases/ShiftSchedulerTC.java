
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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
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

		// for give the default value

		Faker faker = new Faker();
		test = reports.createTest("Testcase for Shift Scheduler Page ");
		PageFactory.initElements(driver, ShiftSchedulerObj.class);
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

		ShiftSchedulerObj.shiftSchemeOpt.click();
		Thread.sleep(1000);
		for (int i = 0; i < ShiftSchedulerObj.shiftSchemeDD.size(); i++) {
			if (ShiftSchedulerObj.shiftSchemeDD.get(i).getText()
					.equalsIgnoreCase(properties.getProperty("ShiftName"))) {
				ShiftSchedulerObj.shiftSchemeDD.get(i).click();
				break;
			}
		}
		test.pass("Selected Shift Scheme: " + properties.getProperty("ShiftName"));
		// Select Department
		ShiftSchedulerObj.departmentOpt.click();
		test.pass("Department DropDown clicked successfully");
		Thread.sleep(1000);

		for (int i = 0; i < ShiftSchedulerObj.departmentDD.size(); i++) {
			if (ShiftSchedulerObj.departmentDD.get(i).getText()
					.equalsIgnoreCase(properties.getProperty("DepartmentName"))) {
				ShiftSchedulerObj.departmentDD.get(i).click();
				break;
			}

		}
		test.pass("Selected Department: " + properties.getProperty("DepartmentName"));
		Thread.sleep(1000);

		test.info("<b><font color = 'purple'>Test case-3 Check the Assign Policy Functionality </b>");
		ShiftSchedulerObj.addShiftButton.get(0).click();
		test.pass("Clicked on Add Shift (+)");
		Thread.sleep(2000);

		ShiftSchedulerObj.morningShiftDD.get(0).click();
		test.pass("Selected Morning Shift");
		Thread.sleep(2000);
		ShiftSchedulerObj.addShiftButton.get(0).click();
		ShiftSchedulerObj.offDaysOption.click();
		test.pass("Selected Off Day");
		Thread.sleep(2000);
		ShiftSchedulerObj.deleteButton.click();
		test.pass("Clicked on Delete Shift");
		Thread.sleep(2000);

		// test.pass("Clicked on Add Shift (+)");
		Thread.sleep(2000);

		// test.pass("Selected Morning Shift");
		// ShiftSchedulerObj.deleteButton.click();
		// Thread.sleep(2000);
	}

	@AfterSuite
	public void reportflush() {

		reports.flush();
	}

	/*
	 * Code for taking Screenshot
	 */

	public static String takeScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		screenShot = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
		File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File(screenShot));
		return screenShot;

	}

	@AfterTest
	public void close() {

		driver.close();

	}

}
