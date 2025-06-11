package com.loyaltri.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.loyaltri.objects.loginobj;

public class commonfunctions {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static FileInputStream stream;
	public static ExtentSparkReporter report;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentTest node;

	@BeforeTest

	public void main() throws IOException, InterruptedException {
		FileInputStream stream = new FileInputStream("Config.properties");

		Properties properties = new Properties();
		properties.load(stream);

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		String URL = properties.getProperty("url");

		driver.navigate().to(URL);
		PageFactory.initElements(driver, loginobj.class);

		loginobj.username.sendKeys(properties.getProperty("username"));
		loginobj.password.sendKeys(properties.getProperty("password"));
		loginobj.sigin.click();

	}

	@AfterSuite
	public void close()

	{

		driver.close();

	}
}

