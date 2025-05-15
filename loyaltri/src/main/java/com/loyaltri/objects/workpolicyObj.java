package com.loyaltri.objects;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class workpolicyObj {

//Dashboard

@FindBy (xpath="//div[text()='Select']")
public static WebElement selectDD;

@FindBy (xpath="//span[text()='Select']")
public static WebElement selectOpt;

@FindBy (xpath="//div[@class='ant-select-item-option-content']")
public static List<WebElement> DashDD;


@FindBy (xpath="//span[text()='Assign']")
public static List<WebElement> AssignOption;



@FindBy (xpath="//button[@class='ant-modal-close']")
public static List<WebElement> CloseOption;




//misspunch policy
    
        @FindBy (xpath="//p[contains(text(),'Settings')]")
        public static WebElement settings;
    
        @FindBy (xpath="//a[contains(text(),'Work Policy')]")
        public static WebElement workpolicy;
    
        @FindBy (xpath="//span[text()='Create Work Policy']")
        public static WebElement CreateWorkPol;
        
        @FindBy (xpath="//h1[text()='Work Policy']")
        public static WebElement WorkpolicyHead;
        @FindBy (xpath="//h2[normalize-space()='Miss Punch Policy']")
        public static WebElement MisspuchOpt;
        @FindBy (xpath="//h1[text()='Miss Punch Policy']")
        public static WebElement MisspuchHead;

   //CREATE POLICY
  
        @FindBy (xpath="//input[@placeholder='Enter Work Policy Name']")
        public static WebElement policyName;
        
       
        @FindBy (xpath="//input[@type='number']")
        public static WebElement mispuchNo;
        
        @FindBy (xpath="(//span[@title='Select'])[1]")
        public static WebElement DuductionDD;
        
        @FindBy (xpath="(//span[text()='Cancel'])[2]")
        public static WebElement cancelmissbtn;
        
        @FindBy (xpath="//div[@class='ant-select-item-option-content']")
        public static 	List<WebElement> DeductionList;
        
        @FindBy (xpath="(//input[@type='number'])[2]")
        public static WebElement Amount;
        
        @FindBy (xpath="(//span[@title='Select'])[2]")
        public static WebElement DeductionfromDD;
     
        @FindBy (xpath="//div[contains(text(),'Save & Continue')]")
        public static WebElement SaveCont;
    
        @FindBy(xpath="(//span[text()='Cancel'])[2])")
        public static WebElement Misscancelbtn;
        
        @FindBy(xpath="//span[text()='Yes,Proceed']")
        public static WebElement Proceedbtn;

    //ASSIGN POLICY
        @FindBy(xpath="//h1[text()='Assign Policy']")
        public static WebElement assignHeadmiss;

        @FindBy (xpath="//input[@placeholder='Select Effective Date']")
        public static WebElement EffDate;

        @FindBy (xpath="//span[@class='ant-picker-prev-icon']")
        public static WebElement CalendrPrevBtn;

       @FindBy (xpath="//div[text()='Assign Policy']")
        public static WebElement AssignpolicyHed;

        @FindBy (xpath="(//input[@type='checkbox'])[2]")
        public static WebElement checkboxMiss;

        @FindBy (xpath="//div[text()='Save & Continue']")
        public static WebElement missSavebtn;
        
        @FindBy (xpath="//input[@placeholder='Search Employees']")
        public static WebElement SearchEmp;

//UPDATE POLICY
        @FindBy (xpath="(//tr[1]//td[6]//button)[1]")
        public static WebElement MPeditBtn;

        @FindBy (xpath="(//input[@type='checkbox'])[83]")
        public static WebElement UnassignBtnMiss;  

        @FindBy (xpath="//input[@placeholder='Search']")
        public static WebElement DashSerch;

 //delete

        @FindBy (xpath="(//tr[1]//td[6]//button)[2]")
        public static WebElement DeletBtnmis;

        @FindBy (xpath="//span[text()='No']")
        public static WebElement NObtnMis;

        @FindBy (xpath="//span[text()='Confirm']")
        public static WebElement ConfirmBtnMis;
         

//OVERTIME POLICY
        @FindBy (xpath="//h2[text()='Over Time Policy']")
        public static WebElement OvertimePolicyOp;

        @FindBy (xpath="//h1[text()='Over Time Policy']")
        public static WebElement OvertimePolicyHead;

        @FindBy (xpath="(//input[@type='radio'])[1]")
        public static WebElement OtType;

        @FindBy (xpath="//input[@placeholder='Choose Employee works more than']")
        public static WebElement WMTOt;

	@FindBy (xpath="//input[@placeholder='Enter Amount Per Minute']")
	public static WebElement AmountOT;
   

        @FindBy (xpath="//input[@type='number']")
        public static WebElement Overtimeno;

        @FindBy (xpath="(//span[@title='Select'])[3]")
        public static WebElement OvertimeDD;

        @FindBy (xpath="//div[contains(text(),'Save & Continue')]")
        public static WebElement SaveContOvertime;

//TIME OUT POLICY   
        @FindBy (xpath="//h2[text()='Time In-Out Policy']")
        public static WebElement TimeinoutOpt;

        @FindBy (xpath="//h2[text()='Time In-Out Policy']")
        public static WebElement TimeinouHead;

        @FindBy (xpath="//input[@placeholder='Choose If Time Shortfall Exceeds']")
        public static WebElement Shortfalexced;


        @FindBy (xpath="//input[@placeholder='Enter Amount']")
        public static WebElement AmountTITO;


        
//Attendence In Off Days

        @FindBy (xpath="//h2[text()='Attendance on Off days']")
        public static WebElement AttendOffdaysOpt;
        @FindBy (xpath="//h2[text()='Attendance on Off days']")
        public static WebElement AttendOffdaysHead;

        @FindBy (xpath="(//span[text()='Select'])[1]")
        public static WebElement SalaryMultiplier;
        @FindBy (xpath="//h1[text()='Consider attendance on week off as working day']")
        public static WebElement SalaryComponent;

        @FindBy (xpath="//div[@class='ant-select-item-option-content']")
        public static List<WebElement> MultiplierDD;

        @FindBy (xpath="(//span[@title='Select'])[1]")
        public static WebElement ComponentOpt;

        @FindBy (xpath="//div[@class='ant-select-item-option-content']")
        public static  List<WebElement> ComponentDD;

        @FindBy (xpath="(//h3[text()='Comp Off'])[2]")
        public static  WebElement CompoOffOpt;

        @FindBy (xpath="(//h3[text()='Overtime'])[2]")
        public static WebElement OvertimeOpt;


        @FindBy (xpath="(//h3[@class=' text-sm font-semibold'])[8]")
        public static WebElement DontConsiderOpt;

//Dashboard Meanu

@FindBy (xpath="//p[text()='Overtime Policy']")
public static WebElement Option1;



@FindBy (xpath="//span[@class='anticon anticon-close ant-modal-close-icon']")
public static WebElement Closebtn;





        
                    
}
