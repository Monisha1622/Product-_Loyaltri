package com;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import com.loyaltri.TestCases.commonfunctions;
import com.loyaltri.objects.OffboardingObj;

public class OffboardingTC extends commonfunctions {
    @BeforeSuite
    public void report(){
        report = new ExtentSparkReporter("Reports/Offboarding.html");
        reports= new ExtentReports();
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
 		test = reports.createTest("Testcase for Offboarding Page ");
			PageFactory.initElements(driver,OffboardingObj.class);
	test.info("<b><font color = 'purple'>Test case-1 Verify the Offboarding is displayed </b>");
	
		

    
}
