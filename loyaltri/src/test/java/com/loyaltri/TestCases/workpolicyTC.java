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
import com.loyaltri.objects.workpolicyObj;

public class workpolicyTC  extends commonfunctions{
  static String screenShot;

	@BeforeSuite
	
	public void report() {
		report = new ExtentSparkReporter("Reports/worpolicy.html");
		reports = new ExtentReports();
		reports.attachReporter(report);
        reports.setSystemInfo("<b>Application<b>", "<b>Loyaltri<b>");
		reports.setSystemInfo("<b>Module<b>", "<b>MisspunchPolicy<\b>");
		reports.setSystemInfo("<b>Author<b>", "<b> Cordova Testing Team<b>");

	}

	
@Test(priority = 1)
	public void eventlist() throws Exception {
	FileInputStream stream = new FileInputStream("Config.properties"); 
	Properties properties = new Properties();
	properties.load(stream);
	
 //for give the default value
	
		Faker faker = new Faker();          
 		test = reports.createTest("Testcase for Work Policy Page ");
		PageFactory.initElements(driver,workpolicyObj.class);
	test.info("<b><font color = 'purple'>Test case-1 Verify the Miss Puch page is displayed </b>");
		
		workpolicyObj.settings.click();
		test.pass("Settings Menu clicked");
		workpolicyObj.workpolicy.click();
		test.pass("workpolicy Menu Clicked");
		String actCountry = workpolicyObj.WorkpolicyHead.getText();
		if (actCountry.equals("WorkPolicy")) {
	            test.pass("WorkPolicy page is displayed");
 
	        } else {
				test.fail("<font color='red'>MissPuchPOlicy page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	  
	        }
 
		
	test.info("<b><font color = 'purple'>Test case-2 Check the Create Workpolicy page is displayed </b>");
        workpolicyObj.CreateWorkPol.click();
		test.pass("Creatework policy option clicked");
		Thread.sleep(1000);
	
		//scroll down the window
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		workpolicyObj.MisspuchOpt.click();
		test.pass("Miss Punch option clicked successfully");


	test.info("<b><font color = 'purple'>Test case-3 Check the Create Misspuch  page is displayed </b>");
		 if(workpolicyObj.MisspuchHead.getText().equals("Miss Punch Policy")) {
				test.pass("Miss Puch Policy  window is displayed.The heading is :"+workpolicyObj.MisspuchHead.getText());
			}else {
				test.fail("<font color='red'>Create Workpolicy page navigation failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
			}
		    workpolicyObj.policyName.sendKeys(properties.getProperty("PolicyName"));
			test.pass("Policyname entred successfully");
			Thread.sleep(1000);
            workpolicyObj.mispuchNo.sendKeys(properties.getProperty("MissTime"));
		    test.pass("MissPuch value entred successfully");
		    Thread.sleep(1000);
            workpolicyObj.DuductionDD.click();
			test.pass("Deduction DroprDown clicked successfully");
            Thread.sleep(1000);
		        
//Deduction Type dropdown
    for (int i = 0; i < workpolicyObj.DeductionList.size(); i++) {
		if (workpolicyObj.DeductionList.get(i).getText().equalsIgnoreCase(properties.getProperty("DeductionType1"))) {
		workpolicyObj.DeductionList.get(i).click();
		break;	  
}
}
            test.pass("Deduction Type is selected successfully");
	        workpolicyObj.Amount.sendKeys(properties.getProperty("amount"));
			test.pass("Amount entred successfully");
	        workpolicyObj.SaveCont.click();
		    test.pass("Save & Continue button clicked successfully");
		    Thread.sleep(2000);

			workpolicyObj.Proceedbtn.click();
			test.pass("Proceed button clicked successfully");
			Thread.sleep(2000);
		

	test.info("<b><font color = 'purple'>Test case-4 Check the Assign Policy  page is displayed </b>");
	        if(workpolicyObj.assignHeadmiss.getText().equals("Assign Policy")) {
		    test.pass("Assign Policy  window is displayed.The heading is :"+workpolicyObj.assignHeadmiss.getText());
	        }else {
		    test.fail("<font color='red'>Assign policy page navigation failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	      }

			workpolicyObj.EffDate.click(); 
			test.pass("Effective date clicked successfully"); 
			Thread.sleep(2000);
			workpolicyObj.CalendrPrevBtn.click();
			test.pass("Previous button clicked successfully");
			workpolicyObj.EffDate.sendKeys(properties.getProperty("PreviousMonthDate"));

//search Empolyee
	        workpolicyObj.SearchEmp.sendKeys(properties.getProperty("workSearch"));
            test.pass("Send the value successfully");
	        Thread.sleep(1000);
              
////check box		        
            if (!workpolicyObj.checkboxMiss.isSelected()) {
			workpolicyObj.checkboxMiss.click();
			test.pass("Checkbox clicked successfully");
			    }
			Thread.sleep(2000);
			workpolicyObj.missSavebtn.click();
			test.pass("Save & Continue button clicked successfully");
			workpolicyObj.Proceedbtn.click();
			Thread.sleep(1000);
			
			
			
	
//Update		
test.info("<b><font color = 'purple'>Test case-5  Verify the Update Miss Puch Policy functionality  </b>");
	        workpolicyObj.DashSerch.sendKeys(properties.getProperty("PolicyName"));
	        Thread.sleep(4000);
	        if (workpolicyObj.DashSerch.getText().contains(properties.getProperty("PolicyName"))) {
		    test.pass("Policy found successfully in the search results");
        	} else {
		    test.fail("<font color='red'>Policy not found in the search results</font>", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());
	       }

			workpolicyObj.MPeditBtn.click();
			test.pass("Edit button clicked successfully");
			Thread.sleep(1000);
		
			workpolicyObj.missSavebtn.click();
			test.pass("Save & Continue button clicked successfully");
			Thread.sleep(1000);
			workpolicyObj.Proceedbtn.click();
			Thread.sleep(1000);
			// misspunchObj.EffDate.sendKeys(properties.getProperty("PreviousMonthDate"));
        
			Thread.sleep(1000);
			workpolicyObj.UnassignBtnMiss.click();
			test.pass("Unassign button clicked successfully");
			workpolicyObj.missSavebtn.click();
			test.pass("Update the policy  successfully");
			workpolicyObj.Proceedbtn.click();
			test.pass("Proceed button clicked successfully");
			Thread.sleep(1000);
		

//DELETE 
test.info("<b><font color = 'purple'>Test case-6  Verify the Delete  functionality  Miss Puch Policy </b>");
           workpolicyObj.DashSerch.sendKeys(properties.getProperty("PolicyName"));
           Thread.sleep(4000);
        if (workpolicyObj.DashSerch.getText().contains(properties.getProperty("PolicyName"))) {
           test.pass("Policy found successfully in the search results");
           } else {
        test.fail("<font color='red'>Policy not found in the search results</font>", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());
}

			workpolicyObj.DeletBtnmis.click();
			test.pass("Delete button clicked successfully");
			Thread.sleep(1000);
			workpolicyObj.NObtnMis.click();
			test.pass("No button clicked successfully");
			Thread.sleep(1000);
			workpolicyObj.DashSerch.sendKeys(properties.getProperty("PolicyName"));
			Thread.sleep(4000);
			workpolicyObj.DeletBtnmis.click();
			workpolicyObj.ConfirmBtnMis.click();
			test.pass("Confirm button clicked successfully");
			Thread.sleep(1000);
			test.pass("Deleted the misspunch policy  successfully");
  
}

//OVER TIME POLICY
 
@Test(priority = 2)
public void overtime()throws Exception{
	FileInputStream stream = new FileInputStream("Config.properties"); 
	Properties properties = new Properties();
	properties.load(stream);
         
 		test = reports.createTest("Testcase for Over Time Policy Page ");
		PageFactory.initElements(driver,workpolicyObj.class);
	test.info("<b><font color = 'purple'>Test case-1 Verify the Over Time Policy  page is displayed </b>");
		
		workpolicyObj.settings.click();
		test.pass("Settings Menu clicked");
		workpolicyObj.workpolicy.click();
		test.pass("workpolicy Menu Clicked");
		String actCountry = workpolicyObj.WorkpolicyHead.getText();
		if (actCountry.equals("WorkPolicy")) {
	            test.pass("WorkPolicy page is displayed");
 
	        } else {
				test.fail("<font color='red'>WorkPolicy page  page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	  
	        }
 
		
	test.info("<b><font color = 'purple'>Test case-1 Check the Create Workpolicy page is displayed </b>");
		workpolicyObj.CreateWorkPol.click();
		test.pass("Creatework policy option clicked");
		Thread.sleep(1000);

//CREATE OT POLICY
	
	test.info("<b><font color = 'purple'>Test case-2 Check the Create short Time Policy page is displayed </b>");
	workpolicyObj.OvertimePolicyOp.click();
	test.pass("Over Time  pollicy option is clicked Suceesfully");
	String OvertimeName = workpolicyObj.OvertimePolicyHead.getText();
	if (OvertimeName.equals("Over Time Policy")) {
		test.pass("Over Time Policy page is displayed");

	} else {
		test.fail("<font color='red'> Over Time Policy page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	}
	 Thread.sleep(3000);
	 workpolicyObj.policyName.sendKeys(properties.getProperty("OTpolicyName"));
	 test.pass("Policyname entred successfully");
	 Thread.sleep(1000);
	 workpolicyObj.OtType.click();
	 Thread.sleep(2000);
     test.pass("Overtime Type option clicked successfully");
	 workpolicyObj.WMTOt.sendKeys(properties.getProperty("Workmorethan"));
	 test.pass("Overtime Type value entered successfully");
	 Thread.sleep(2000);
	 workpolicyObj.AmountOT.sendKeys(properties.getProperty("AmountPerMini"));
	 test.pass("Amount entred successfully");
	 workpolicyObj.SaveCont.click();
	 test.pass("Save & Continue button clicked successfully");
	 Thread.sleep(1000);
	 workpolicyObj.Proceedbtn.click();
	 test.pass("Proceed button clicked successfully");
	 Thread.sleep(1000);

//ASSIGN OT POLICY	 

test.info("<b><font color = 'purple'>Test case-3 Check the Assign OT Policy  page is displayed </b>");
   if(workpolicyObj.assignHeadmiss.getText().equals("Assign Policy")) {
   test.pass("Assign Policy  window is displayed.The heading is :"+workpolicyObj.assignHeadmiss.getText());
   }else {
   test.fail("<font color='red'>Assign policy page navigation failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
}

workpolicyObj.EffDate.click(); 
test.pass("Effective date clicked successfully"); 
Thread.sleep(2000);
workpolicyObj.CalendrPrevBtn.click();
test.pass("Previous button clicked successfully");
workpolicyObj.EffDate.sendKeys(properties.getProperty("PreviousMonthDate"));

//search Empolyee
workpolicyObj.SearchEmp.sendKeys(properties.getProperty("workSearch"));
test.pass("Send the value successfully");
Thread.sleep(1000);
  
////check box		        
if (!workpolicyObj.checkboxMiss.isSelected()) {
workpolicyObj.checkboxMiss.click();
test.pass("Checkbox clicked successfully");
	}
Thread.sleep(2000);
workpolicyObj.missSavebtn.click();
test.pass("Save & Continue button clicked successfully");
Thread.sleep(2000);
workpolicyObj.Proceedbtn.click();
Thread.sleep(1000);

test.info("<b><font color = 'purple'>Test case-5  Verify the Update OverTime Policy functionality  </b>");
	        workpolicyObj.DashSerch.sendKeys(properties.getProperty("OTpolicyName"));
	        Thread.sleep(4000);
	        if (workpolicyObj.DashSerch.getText().contains(properties.getProperty("OTpolicyName"))) {
		    test.pass("Policy found successfully in the search results");
        	} else {
		    test.fail("<font color='red'>Policy not found in the search results</font>", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());
	       }

			workpolicyObj.MPeditBtn.click();
			test.pass("Edit button clicked successfully");
			Thread.sleep(1000);
		
			workpolicyObj.missSavebtn.click();
			test.pass("Save & Continue button clicked successfully");
			Thread.sleep(1000);
			workpolicyObj.Proceedbtn.click();
			Thread.sleep(1000);
			// misspunchObj.EffDate.sendKeys(properties.getProperty("PreviousMonthDate"));
        
			Thread.sleep(1000);
			workpolicyObj.UnassignBtnMiss.click();
			test.pass("Unassign button clicked successfully");
			workpolicyObj.missSavebtn.click();
			Thread.sleep(1000);
			test.pass("Update the policy  successfully");
			workpolicyObj.Proceedbtn.click();
			test.pass("Proceed button clicked successfully");
			Thread.sleep(1000);
		

//DELETE 
test.info("<b><font color = 'purple'>Test case-6  Verify the Delete  functionality  Miss Puch Policy </b>");
           workpolicyObj.DashSerch.sendKeys(properties.getProperty("OTpolicyName"));
           Thread.sleep(4000);
        if (workpolicyObj.DashSerch.getText().contains(properties.getProperty("PolicyName"))) {
           test.pass("Policy found successfully in the search results");
           } else {
        test.fail("<font color='red'>Policy not found in the search results</font>", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());
}

			workpolicyObj.DeletBtnmis.click();
			test.pass("Delete button clicked successfully");
			Thread.sleep(1000);
			workpolicyObj.NObtnMis.click();
			test.pass("No button clicked successfully");
			Thread.sleep(1000);
			workpolicyObj.DashSerch.sendKeys(properties.getProperty("OTpolicyName"));
			Thread.sleep(2000);
			workpolicyObj.DeletBtnmis.click();
			Thread.sleep(1000);
			workpolicyObj.ConfirmBtnMis.click();
			test.pass("Confirm button clicked successfully");
			Thread.sleep(1000);
			test.pass("Deleted the misspunch policy  successfully");

}

//Time In-Out Policy 

		@Test(priority = 3)
		public void timeout()throws Exception{
			FileInputStream stream = new FileInputStream("Config.properties"); 
			Properties properties = new Properties();
			properties.load(stream);
	 		test = reports.createTest("Testcase for Time In-Out Policy Page ");
			PageFactory.initElements(driver,workpolicyObj.class);
			test.info("<b><font color = 'purple'>Test case-1 Verify the Time In Time Out Policy  page is displayed </b>");
			workpolicyObj.settings.click();
			test.pass("Settings Menu clicked");
			workpolicyObj.workpolicy.click();
			test.pass("workpolicy Menu Clicked");
			String actCountry = workpolicyObj.WorkpolicyHead.getText();
			if (actCountry.equals("WorkPolicy")) {
					test.pass("WorkPolicy page is displayed");
	 
				} else {
					test.fail("<font color='red'>WorkPolicy page  page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		  
				}

				test.info("<b><font color = 'purple'>Test case-2 Check the Create Workpolicy page is displayed </b>");
				workpolicyObj.CreateWorkPol.click();
				test.pass("Creatework policy option clicked");
				Thread.sleep(1000);
				String Timeout = workpolicyObj.TimeinouHead.getText();
				if (Timeout.equals("Time In-Out Policy")) {
					test.pass("Time In-Out Policy page is displayed");
			
				} else {
					test.fail("<font color='red'> Time In-Out Policy page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
				}
				workpolicyObj.TimeinouHead.click();
				test.pass("Time In-Out Policy option is clicked Suceesfully");
           	    workpolicyObj.policyName.sendKeys(properties.getProperty("TimeOutpolicyName"));
				test.pass("Policyname entred successfully");
				Thread.sleep(1000);
				workpolicyObj.Shortfalexced.sendKeys(properties.getProperty("shortfallTime"));
				test.pass("Time entred successfully");
				Thread.sleep(2000);
				workpolicyObj.DuductionDD.click();
				test.pass("Deduction DroprDown clicked successfully");
				Thread.sleep(1000);
					
	//Deduction Type dropdown
		for (int i = 0; i < workpolicyObj.DeductionList.size(); i++) {
			if (workpolicyObj.DeductionList.get(i).getText().equalsIgnoreCase(properties.getProperty("DeductionType1"))) {
			workpolicyObj.DeductionList.get(i).click();
			break;	  
	}
	}
				test.pass("Deduction Type is selected successfully");
				workpolicyObj.AmountTITO.sendKeys(properties.getProperty("amount"));
				test.pass("Amount entred successfully");
				workpolicyObj.SaveCont.click();
				Thread.sleep(1000);
				workpolicyObj.Proceedbtn.click();
			    test.pass("Proceed button clicked successfully");
			    Thread.sleep(2000);
		
						
				test.info("<b><font color = 'purple'>Test case-3 Check the Assign Policy  page is displayed </b>");
				if(workpolicyObj.assignHeadmiss.getText().equals("Assign Policy")) {
				test.pass("Assign Policy  window is displayed.The heading is :"+workpolicyObj.assignHeadmiss.getText());
				}else {
				test.fail("<font color='red'>Assign policy page navigation failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
			  }
	
				workpolicyObj.EffDate.click(); 
				test.pass("Effective date clicked successfully"); 
				Thread.sleep(2000);
				workpolicyObj.CalendrPrevBtn.click();
				Thread.sleep(2000);

				test.pass("Previous button clicked successfully");
				workpolicyObj.EffDate.sendKeys(properties.getProperty("PreviousMonthDate"));
				//search Empolyee
workpolicyObj.SearchEmp.sendKeys(properties.getProperty("workSearch"));
test.pass("Searching the empolyee  successfully");
Thread.sleep(1000);
  
////check box		        
if (!workpolicyObj.checkboxMiss.isSelected()) {
workpolicyObj.checkboxMiss.click();
test.pass("Checkbox clicked successfully");
	}
Thread.sleep(2000);
workpolicyObj.missSavebtn.click();
test.pass("Save & Continue button clicked successfully");
Thread.sleep(2000);
workpolicyObj.Proceedbtn.click();
Thread.sleep(1000);

test.info("<b><font color = 'purple'>Test case-4  Verify the Update Time In Time Out Policy functionality  </b>");
	        workpolicyObj.DashSerch.sendKeys(properties.getProperty("TimeOutpolicyName"));
	        Thread.sleep(4000);
	        if (workpolicyObj.DashSerch.getText().contains(properties.getProperty("TimeOutpolicyName"))) {
		    test.pass("Policy found successfully in the search results");
        	} else {
		    test.fail("<font color='red'>Policy not found in the search results</font>", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());
	       }

			workpolicyObj.MPeditBtn.click();
			test.pass("Edit button clicked successfully");
			Thread.sleep(1000);
		
			workpolicyObj.missSavebtn.click();
			test.pass("Save & Continue button clicked successfully");
			Thread.sleep(1000);
			workpolicyObj.Proceedbtn.click();
			Thread.sleep(1000);
			// misspunchObj.EffDate.sendKeys(properties.getProperty("PreviousMonthDate"));
        
			Thread.sleep(1000);
			workpolicyObj.UnassignBtnMiss.click();
			test.pass("Unassign button clicked successfully");
			workpolicyObj.missSavebtn.click();
			test.pass("Update the policy  successfully");
			workpolicyObj.Proceedbtn.click();
			test.pass("Proceed button clicked successfully");
			Thread.sleep(1000);
		

//DELETE 
test.info("<b><font color = 'purple'>Test case-5  Verify the Delete  functionality  Miss Puch Policy </b>");
           workpolicyObj.DashSerch.sendKeys(properties.getProperty("TimeOutpolicyName"));
           Thread.sleep(4000);
        if (workpolicyObj.DashSerch.getText().contains(properties.getProperty("PolicyName"))) {
           test.pass("Policy found successfully in the search results");
           } else {
        test.fail("<font color='red'>Policy not found in the search results</font>", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());
}
			workpolicyObj.DeletBtnmis.click();
			test.pass("Delete button clicked successfully");
			Thread.sleep(1000);
			workpolicyObj.NObtnMis.click();
			test.pass("No button clicked successfully");
			Thread.sleep(1000);
			workpolicyObj.DashSerch.sendKeys(properties.getProperty("TimeOutpolicyName"));
			Thread.sleep(4000);
			workpolicyObj.DeletBtnmis.click();
			workpolicyObj.ConfirmBtnMis.click();
			test.pass("Confirm button clicked successfully");
			Thread.sleep(1000);
			test.pass("Deleted the misspunch policy  successfully");
  
}
	        
   
		@Test(priority = 4)
		public void Offdays()throws Exception{
			FileInputStream stream = new FileInputStream("Config.properties"); 
			Properties properties = new Properties();
			properties.load(stream);
	 		test = reports.createTest("Testcase for Attendance on Off days Page ");
			PageFactory.initElements(driver,workpolicyObj.class);
			test.info("<b><font color = 'purple'>Test case-1 Verify the Attendance on Off days  page is displayed </b>");
			workpolicyObj.settings.click();
			test.pass("Settings Menu clicked");
			workpolicyObj.workpolicy.click();
			test.pass("workpolicy Menu Clicked");
			String actCountry = workpolicyObj.WorkpolicyHead.getText();
			if (actCountry.equals("WorkPolicy")) {
					test.pass("WorkPolicy page is displayed");
	 
				} else {
					test.fail("<font color='red'>WorkPolicy page  page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		  
				}  
				
				test.info("<b><font color = 'purple'>Test case-2 Check the Create Workpolicy page is displayed </b>");
				workpolicyObj.CreateWorkPol.click();
				test.pass("Creatework policy option clicked");
				Thread.sleep(1000);
				String Timeout = workpolicyObj.AttendOffdaysHead.getText();
				if (Timeout.equals("Attendance on Off days")) {
					test.pass("Attendance on Off days page is displayed");
			
				} else {
					test.fail("<font color='red'>Attendance on Off days page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
				}
				workpolicyObj.AttendOffdaysHead.click();
				Thread.sleep(1000);
				workpolicyObj.policyName.sendKeys(properties.getProperty("Offdaypolicy"));
				test.pass("Policyname entred successfully");
				Thread.sleep(2000);

        // Use JavaScript to click if needed


       // JavascriptExecutor js1 = (JavascriptExecutor) driver;  
        //js1.executeScript("arguments[0].click();", workpolicyObj.instantmessages);

		 Actions actions1 = new Actions(driver);
         actions1.moveToElement(workpolicyObj.SalaryComponent).perform();
         Thread.sleep(2000); // Optional wait after scroll

		workpolicyObj.SalaryMultiplier.click();
		test.pass("Salary Multiplier option clicked successfully");
		Thread.sleep(2000);
		for (int i = 0; i < workpolicyObj.MultiplierDD.size(); i++) {
			if (workpolicyObj.DeductionList.get(i).getText().equalsIgnoreCase(properties.getProperty("SalaryMultiplier"))) {
			workpolicyObj.DeductionList.get(i).click();
			break;	  
	}
	}
	Thread.sleep(2000);
	workpolicyObj.ComponentOpt.click();
	test.pass("Salary Component option clicked successfully");
	Thread.sleep(2000);

	for (int i = 0; i < workpolicyObj.ComponentDD.size(); i++) {
		if (workpolicyObj.ComponentDD.get(i).getText().equalsIgnoreCase(properties.getProperty("SalaryComponent"))) {
		workpolicyObj.ComponentDD.get(i).click();
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
