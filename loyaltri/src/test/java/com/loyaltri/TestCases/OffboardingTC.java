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
	public void report() {
		report = new ExtentSparkReporter("Reports/Offboarding.html");
		reports = new ExtentReports();
		reports.attachReporter(report);
		reports.setSystemInfo("<b>Application<b>", "<b>Loyaltri<b>");
		reports.setSystemInfo("<b>Module<b>", "<b>Offboarding<\b>");
		reports.setSystemInfo("<b>Author<b>", "<b> Cordova Testing Team<b>");

	}

	@Test(priority = 1)
	public void Offboarding() throws Exception {
		FileInputStream stream = new FileInputStream("Config.properties");
		Properties properties = new Properties();
		properties.load(stream);

		test = reports.createTest("Testcase for Offboarding Page ");
		PageFactory.initElements(driver, OffboardingObj.class);
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
			test.fail("<font color='red'>Employee Offboarding page is not displayed</font>",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());

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
		// Separation Mode page

		test.info(
				"<b><font color = 'purple'>Test case-3 Verify the Separation Mode - Offboarding page is displayed </b>");
		String sepeMode = OffboardingObj.SeperationOpt.getText();
		if (sepeMode.equals("Separation Mode")) {
			test.pass("Separation Mode page is displayed");

		} else {
			test.fail("<font color='red'>Separation Mode page is not displayed</font>",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());

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

		// Leave Balance Details page

		test.info(
				"<b><font color = 'purple'>Test case-4 Verify the Leave Balance Details - Offboarding page is displayed </b>");
		String LeaveDeatils = OffboardingObj.LeaveBalHead.getText();
		if (LeaveDeatils.equals("Leave Balance Details")) {
			test.pass("Leave Balance Details page is displayed");

		} else {
			test.fail("<font color='red'>Leave Balance Details page is not displayed</font>",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());

		}

		// Get the leave count value from the Leave Balance Details page
		String leaveCount = OffboardingObj.LeaveBalance.getText();
		test.info("<b><font color = 'Blue'>Leave Count Value: <b>" + leaveCount + "</b></font></b>");
		OffboardingObj.OffSaveBtn.click();
		test.pass("Offboarding Save & Continue button clicked");

		// Rehire Eligibility page
		test.info(
				"<b><font color = 'purple'>Test case-5 Verify the Rehire Eligibility - Offboarding page is displayed </b>");
		String rehireEligi = OffboardingObj.RehireEligiHead.getText();
		if (rehireEligi.equals("Rehire Eligibility")) {
			test.pass("Rehire Eligibility page is displayed");

		} else {
			test.fail("<font color='red'>Rehire Eligibility page is not displayed</font>",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());

		}
		Thread.sleep(1000);

		OffboardingObj.RehireEligiOpt.click();
		test.pass("Rehire Eligibility Option clicked");
		Thread.sleep(1000);
		OffboardingObj.OffSaveBtn.click();
		test.pass("Offboarding Save & Continue button clicked");
		Thread.sleep(1000);
		test.pass("Offboarding process completed successfully");

		// Feedbacks page
		test.info("<b><font color = 'purple'>Test case-6 Verify the Feedbacks - Offboarding page is displayed </b>");
		String feedbacks = OffboardingObj.FeedbackHead.getText();
		if (feedbacks.equals("Feedbacks")) {
			test.pass("Feedbacks page is displayed");

		} else {
			test.fail("<font color='red'>Feedbacks page is not displayed</font>",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());

		}

		OffboardingObj.OffSaveBtn.click();
		test.pass("Offboarding Save & Continue button clicked");
		Thread.sleep(3000);
		test.pass("Offboarding process completed successfully");

		// Assest cancel
		OffboardingObj.AssestCancelOpt.click();
		test.pass("Asset Cancel Option Clicked");
		Thread.sleep(1000);

		test.info("<b><font color = 'purple'>Test case-7 Verify the Offboarding Options Count </b>");

		// Print the count for each non-clickable option in the report
		String initiatedCount = OffboardingObj.InitiatedCount.getText();
		test.info("<b><font color = 'blue'>Initiated</font></b>: <b>" + initiatedCount + "</b>");

		String holdCount = OffboardingObj.HoldCount.getText();
		test.info("<b><font color = 'blue'>On Hold</font></b>: <b>" + holdCount + "</b>");

		String assetPendingCount = OffboardingObj.AssetPendingCount.getText();
		test.info("<b><font color = 'blue'>Asset Pending</font></b>: <b>" + assetPendingCount + "</b>");

		String pfPendingCount = OffboardingObj.PFPendingCount.getText();
		test.info("<b><font color = 'blue'>FF Pending</font></b>: <b>" + pfPendingCount + "</b>");

		String relevedCount = OffboardingObj.RelevedCount.getText();
		test.info("<b><font color = 'blue'>Relieved</font></b>: <b>" + relevedCount + "</b>");

		// Search for the employee again
		OffboardingObj.ListEmpSearch.sendKeys(properties.getProperty("EmpoName"));
		test.pass("Searched for employee to verify asset status");
		Thread.sleep(3000);

		// Click on the kebab menu for the employee
		OffboardingObj.KebabOpt.click();
		test.pass("Kebab menu clicked for employee");
		Thread.sleep(2000);
		test.info("<b><font color = 'purple'>Test case-8 Verify the Hold Functionality for Offboarding </b>");

		// Click the "Hold" menu option after update
		OffboardingObj.HoldOpt.click();
		test.pass("Hold option clicked after update");
		Thread.sleep(2000);
		OffboardingObj.ListEmpSearch.sendKeys(properties.getProperty("EmpoName"));
		test.pass("Searched for employee to verify asset status");
		Thread.sleep(2000);

		String holdStatus = OffboardingObj.AssetStatus.getText();
		if (holdStatus.equalsIgnoreCase("On  Hold")) {
			test.pass("Asset status successfully changed to 'On  Hold'");
		} else {
			test.fail("<font color='red'>Asset status did not change to 'On  Hold', found: " + holdStatus + "</font>",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());
		}

		// Click the kebab menu again for the employee
		Thread.sleep(2000);
		OffboardingObj.KebabOpt.click();
		test.pass("Kebab menu clicked again for employee");
		Thread.sleep(2000);

		// Click the "Update" option from the kebab menu
		OffboardingObj.UpdateOpt.click();
		test.pass("Update option clicked from kebab menu");
		Thread.sleep(1000);

		// clicking save button multiple times
		for (int i = 0; i < 5; i++) {
			OffboardingObj.OffSaveBtn.click();
			test.pass("Offboarding Save & Continue button clicked (" + (i + 1) + ")");
			Thread.sleep(3000);
		}
		OffboardingObj.AssetRecoveryPop.click();
		test.pass("Asset Recovery Option Clicked");
		Thread.sleep(1000);

		// Assest Recovering
		test.info(
				"<b><font color = 'purple'>Test case-9 Verify the Asset Recovering page Popup window  is displayed </b>");
		String Assestpage = OffboardingObj.AssetRecoveringHead.getText();
		if (feedbacks.equals("Asset Recovering")) {
			test.pass("Asset Recovering  page is displayed");

		} else {
			test.fail("<font color='red'>Asset Recovering page is not displayed</font>",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());

		}

		OffboardingObj.AssetRecoveryPage.click();
		test.pass("Asset Recovery Page Option Clicked");
		Thread.sleep(1000);
		OffboardingObj.Markasrecovered.click();
		test.pass("Mark as recovered Option Clicked");
		Thread.sleep(1000);
		OffboardingObj.OffSaveBtn.click();
		test.pass("Offboarding Save & Continue button clicked");
		Thread.sleep(1000);
		test.pass("Offboarding process completed successfully");

		// Verify the Offboarding Asset Status is 'asset recovered'
		test.info(
				"<b><font color = 'purple'>Test case-10 Verify the Offboarding Asset Status is 'asset recovered' </b>");
		OffboardingObj.ListEmpSearch.sendKeys(properties.getProperty("EmpoName"));
		test.pass("Searched for employee to verify asset status");
		Thread.sleep(2000);

		// Locate the asset status element and verify its value
		String assetStatus = OffboardingObj.AssetRecoveringStatus.getText();
		if (assetStatus.equalsIgnoreCase(" Recovering  Assets")) {
			test.pass("Asset status is ' Recovering  Assets'");
		} else {
			test.fail("<font color='red'>Asset status is not ' Recovering  Assets', found: " + assetStatus + "</font>",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());
		}

		test.info("<b><font color = 'purple'>Test case-11 Verify the Assest Recovery Options Count </b>");
		// Print the count for each non-clickable option in the report
		String PendingCount = OffboardingObj.PendingCount.getText();
		test.info("<b><font color = 'blue'>Pending</font></b>: <b>" + PendingCount + "</b>");

		String AssestInitiatedCount = OffboardingObj.InitiatedCountRecovry.getText();
		test.info("<b><font color = 'blue'>Initiated</font></b>: <b>" + AssestInitiatedCount + "</b>");

		String CompletedCount = OffboardingObj.CompletedCount.getText();
		test.info("<b><font color = 'blue'>Completed</font></b>: <b>" + CompletedCount + "</b>");

		test.pass("Assest Recovery process completed successfully");

		Thread.sleep(3000);

		// Back to Offboarding page
		OffboardingObj.OffboardingOpt.click();
		test.pass("Offboarding Menu clicked");
		Thread.sleep(2000);
		// Verify downloding Relieved List
		OffboardingObj.DownloadRelievedList.click();
		test.pass("Download Relieved List Option Clicked");
		Thread.sleep(2000);

	}

	@AfterTest
	public void reportflush() {
		reports.flush();
	}

	public static String takeScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		screenShot = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
		File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File(screenShot));
		return screenShot;

	}

}
