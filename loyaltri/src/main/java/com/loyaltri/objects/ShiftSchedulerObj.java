package com.loyaltri.objects;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShiftSchedulerObj {

    	
	@FindBy (xpath="//p[contains(text(),'Settings')]")
	public static WebElement ShiftSchedsettings;
	
	@FindBy (xpath="//p[contains(text(),'Time')]")
	public static WebElement TimeShiftSche;

	// @FindBy (xpath="//a[text()='Shift Scheduler']")
	// public static WebElement ShiftScheOpt;
	
	@FindBy (xpath="//span[contains(text(),'Shift Schedular')]")
	public static WebElement ShiftScheHe;

	@FindBy (xpath="//input[@placeholder='Start Date']")
	public static WebElement StartDate;
	@FindBy (xpath="//input[@placeholder='End Date']")
	public static WebElement EndDate;

	@FindBy (xpath="(//input[@role='combobox'])[2]")
	public static WebElement ShiftScheOpt;

	@FindBy (xpath="//div[@title='Select']")
	public static List<WebElement> ShiftScheHeDrop;

}


    

