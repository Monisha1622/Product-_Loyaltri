package com.loyaltri.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OffboardingObj {

  @FindBy(xpath = "//p[text()='Company']")
  public static WebElement CompanyOpt;

  @FindBy(xpath = "//a[text()='Offboarding']")
  public static WebElement OffboardingOpt;

  @FindBy(xpath = "//span[text()='Initiate Offboarding']")
  public static WebElement InitateOBOpt;

  @FindBy(xpath = "//h1[text()='Employee Offboarding']")
  public static WebElement EmpoOffHead;

  @FindBy(xpath = "//input[@placeholder='Search Employees']")
  public static WebElement SearchEmpOB;

  @FindBy(xpath = "(//p[text()='Emp Code: '])[1]")
  public static WebElement EmpCode;

  @FindBy(xpath = "//input[@placeholder='Select']")
  public static WebElement SubmitDateOpt;

  @FindBy(xpath = "(//div[@class='ant-picker-cell-inner'])[5]")
  public static WebElement DateVal;

  @FindBy(xpath = "//div[text()='Save & Continue']")
  public static WebElement OffSaveBtn;

  @FindBy(xpath = "//div[text()='Separation Mode']")
  public static WebElement SeperationOpt;

  @FindBy(xpath = "//h3[contains(text(), 'Voluntary Seperation')]")
  public static WebElement SeperationModeOpt;

  @FindBy(xpath = "//span[text()='Resigned']")
  public static WebElement voluntarySeperationOpt;

  @FindBy(xpath = "//h1[text()='Leave Balance Details']")
  public static WebElement LeaveBalHead;

  @FindBy(xpath = "//span[@class='text-primary font-bold']")
  public static WebElement LeaveBalance;

  @FindBy(xpath = "//p[text()='Rehire Eligibility']")
  public static WebElement RehireEligiHead;

  @FindBy(xpath = "(//span[@class='font-medium text-sm 2xl:text-[16px]'])[1]")
  public static WebElement RehireEligiOpt;

  @FindBy(xpath = "//p[text()='Feedbacks']")
  public static WebElement FeedbackHead;

  @FindBy(xpath = "//h2[text()='Go to asset page']")
  public static WebElement AssetPopupHead;

  @FindBy(xpath = "//span[normalize-space()='Cancel']")
  public static WebElement AssestCancelOpt;

  @FindBy(xpath = "(//div[@class='text-2xl font-semibold 2xl:text-3xl'])[1]")
  public static WebElement InitiatedCount;

  @FindBy(xpath = "(//div[@class='text-2xl font-semibold 2xl:text-3xl'])[2]")
  public static WebElement HoldCount;

  @FindBy(xpath = "(//div[@class='text-2xl font-semibold 2xl:text-3xl'])[3]")
  public static WebElement AssetPendingCount;

  @FindBy(xpath = "(//div[@class='text-2xl font-semibold 2xl:text-3xl'])[4]")
  public static WebElement PFPendingCount;

  @FindBy(xpath = "(//div[@class='text-2xl font-semibold 2xl:text-3xl'])[5]")
  public static WebElement RelevedCount;

  @FindBy(xpath = "//input[@placeholder='Search']")
  public static WebElement ListEmpSearch;

  @FindBy(xpath = "//*[name()='path' and contains(@d,'M9.5 13a1.')]")
  public static WebElement KebabOpt;

  @FindBy(xpath = "(//p[@class='flex items-center gap-2 text-xs'])[3]")
  public static WebElement HoldOpt;

  @FindBy(xpath = "(//p[@class='flex items-center gap-2 text-xs'])[1]")
  public static WebElement UpdateOpt;

  @FindBy(xpath = "//span[text()='Go to Asset Recovery']")
  public static WebElement AssetRecoveryPop;

  @FindBy(xpath = "//h1[text()='Asset Recovering']")
  public static WebElement AssetRecoveringHead;

  @FindBy(xpath = "//span[text()='Start Recovery']")
  public static WebElement AssetRecoveryPage;

  @FindBy(xpath = "//span[text()='Mark as recovered']")
  public static WebElement Markasrecovered;

  @FindBy(xpath = "//input[@placeholder='Search']")
  public static WebElement SearchEmpOff;

  @FindBy(xpath = "//div[@class='rounded-full pr-2 py-[2px] w-fit font-medium text-[10px] 2xl:text-sm vhcenter flex-nowrap dark:!bg-dark3 dark:!shadow-lg'][contains(text(),'On')]")
  public static WebElement AssetStatus;

  @FindBy(xpath = "//div[contains(text(),'Recovering')]")
  public static WebElement AssetRecoveringStatus;

  @FindBy(xpath = "(//div[@class='text-2xl font-semibold 2xl:text-3xl'])[1]")
  public static WebElement PendingCount;

  @FindBy(xpath = "(//div[@class='text-2xl font-semibold 2xl:text-3xl'])[2]")
  public static WebElement InitiatedCountRecovry;

  @FindBy(xpath = "(//div[@class='text-2xl font-semibold 2xl:text-3xl'])[3]")
  public static WebElement CompletedCount;

  @FindBy(xpath = "//span[text()='Download Relieved List']")
  public static WebElement DownloadRelievedList;

}
