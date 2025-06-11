package com.loyaltri.objects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShiftSchedulerObj {

    @FindBy(xpath = "//p[contains(text(),'Settings')]")
    public static WebElement ShiftSchedsettings;

    @FindBy(xpath = "//p[contains(text(),'Time')]")
    public static WebElement TimeShiftSche;

    @FindBy(xpath = "//a[text()='Shift Scheduler']")
    public static WebElement ShiftScheOpt;

    @FindBy(xpath = "//span[contains(text(),'Shift Schedular')]")
    public static WebElement ShiftScheHe;

    @FindBy(xpath = "//input[@placeholder='Start Date']")
    public static WebElement StartDateOpt;

    @FindBy(xpath = "(//div[text()='26'])[1]")
    public static WebElement StartDate;
    @FindBy(xpath = "(//div[text()='31'])[1]")
    public static WebElement EndDate;

    @FindBy(xpath = "(//div[@class='ant-select-selector'])[1]")
    public static WebElement shiftSchemeOpt;

    @FindBy(xpath = "//div[@class='ant-select-item-option-content']")
    public static List<WebElement> shiftSchemeDD;

    // Department dropdown
    @FindBy(xpath = "(//div[@class='ant-select-selector'])[2]")
    public static WebElement departmentOpt;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content']")
    public static List<WebElement> departmentDD;

    @FindBy(xpath = "//div[@class='group-hover:bg-primaryalpha/20 bg-primaryalpha/10 p-1 rounded-full  block group-active:block']")
    public static List<WebElement> addShiftButton;

    @FindBy(xpath = "//span[text()='Off Day']")
    public static WebElement offDaysOption;

    @FindBy(xpath = "(//span[text()='Morning Shift'])[7]")
    public static WebElement morningShiftOption;

    @FindBy(xpath = "(//span[text()='Morning Shift'])[2]")
    public static List<WebElement> morningShiftDD;
    @FindBy(xpath = "(//*[local-name()='svg'])[104]")
    public static WebElement deleteButton;

}