package com.loyaltri.objects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class OffboardingObj {

    @FindBy(xpath="//p[text()='Company']")
        public static WebElement CompanyOpt;

    @FindBy(xpath="//a[text()='Offboarding']")
        public static WebElement OffboardingOpt;

    @FindBy(xpath="//span[text()='Initiate Offboarding']")
    public static WebElement InitateOBOpt;
    
    @FindBy(xpath="//h1[text()='Employee Offboarding']")
    public static WebElement EmpoOffHead;

    @FindBy(xpath="//input[@placeholder='Search Employees']")
    public static WebElement SearchEmpOB;

    @FindBy(xpath="(//p[text()='Emp Code: '])[1]")
    public static WebElement EmpCode;

    @FindBy(xpath="//input[@placeholder='Select']")
    public static WebElement SubmitDateOpt;

    @FindBy(xpath="(//div[@class='ant-picker-cell-inner'])[5]")
    public static WebElement DateVal;

    @FindBy(xpath="//div[text()='Save & Continue']")
    public static WebElement OffSaveBtn;   

    @FindBy(xpath="//div[text()='Separation Mode']")
    public static WebElement SeperationOpt;

    @FindBy(xpath="//h3[contains(text(), 'Voluntary Seperation')]")
    public static WebElement SeperationModeOpt;

    @FindBy(xpath="//span[text()='Resigned']")
    public static WebElement voluntarySeperationOpt;

    @FindBy(xpath="//h1[text()='Leave Balance Details']")
    public static WebElement LeaveBalHead;

    @FindBy(xpath="//span[@class='text-primary font-bold']")
    public static WebElement LeaveBalance;

     @FindBy(xpath="//p[text()='Rehire Eligibility']")
    public static WebElement RehireEligiHead;

     @FindBy(xpath="(//span[@class='font-medium text-sm 2xl:text-[16px]'])[1]")
    public static WebElement RehireEligiOpt;

    @FindBy(xpath="//p[text()='Feedbacks']")
    public static WebElement FeedbackHead;

    @FindBy(xpath="//h2[text()='Go to asset page']")
    public static WebElement AssetPopupHead;

    
    

    


    
    

}
    