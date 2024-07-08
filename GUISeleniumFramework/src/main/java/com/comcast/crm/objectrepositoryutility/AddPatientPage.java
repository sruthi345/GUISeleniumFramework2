package com.comcast.crm.objectrepositoryutility;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Anbumathi
 * 
 * Contains add patients by name,contact number, email, gender, address, age, medical history
 *
 */  	

public class AddPatientPage {
	 WebDriverUtility wbD=new WebDriverUtility();
	 WebDriver driver=null;
	 ExcelUtility excellib=new ExcelUtility();
	public AddPatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='patname']")
	private WebElement enterPatientNameTxt;
	
	@FindBy(name = "patcontact")
	private WebElement patientContactNoTxt;
	
	@FindBy(id = "patemail")
	private WebElement patientEmailTxt;
	
	@FindBy(xpath =  "//label[@for='rg-female']")
	private WebElement genderFemaleRadioBtn;
	
	@FindBy(xpath =  "//label[@for='rg-male']")
	private WebElement genderMaleRadioBtn;
	
	@FindBy(name = "pataddress")
	private WebElement patientAddressTxt;
	
	@FindBy(name = "patage")
	private WebElement patientAgeTxt;
	
	@FindBy(name = "medhis")
	private WebElement medicalHistoryTxt;
	
	@FindBy(id = "submit")
	private WebElement addBtn;
	
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientsDropdown;
	
	@FindBy(xpath =" //span[text()=' Add Patient']" )
	private WebElement addPatMod;
	
	@FindBy(xpath ="//span[text()=' Manage Patient ']" )
	private WebElement managePat;
	
	public WebElement getManagePat() {
		return managePat;
	}

	public WebElement getEnterPatientNameTxt() {
		return enterPatientNameTxt;
	}

	public WebElement getPatientContactNoTxt() {
		return patientContactNoTxt;
	}

	public WebElement getPatientEmailTxt() {
		return patientEmailTxt;
	}

	public WebElement getGenderFemaleRadioBtn() {
		return genderFemaleRadioBtn;
	}

	public WebElement getGenderMaleRadioBtn() {
		return genderMaleRadioBtn;
	}

	public WebElement getPatientAddressTxt() {
		return patientAddressTxt;
	}

	public WebElement getPatientAgeTxt() {
		return patientAgeTxt;
	}

	public WebElement getMedicalHistoryTxt() {
		return medicalHistoryTxt;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}
	
	public WebDriverUtility getWbD() {
		return wbD;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPatientsDropdown() {
		return patientsDropdown;
	}

	public WebElement getAddPatMod() {
		return addPatMod;
	}

	/**
	 * 
	 * Adding patients by help of this credentials(Male)
	 * @param patName
	 * @param PatContactNo
	 * @param patEmail
	 * @param patGender
	 * @param patAddress
	 * @param patAge
	 * @param medicalHistory
	 */
	
	public void addMalePatients(String patName,String PatContactNo, String patEmail, String patAddress, String patAge, String medicalHistory) {
		patientsDropdown.click();
		addPatMod.click();
		enterPatientNameTxt.sendKeys(patName);
		patientContactNoTxt.sendKeys(PatContactNo);
		patientEmailTxt.sendKeys(patEmail);
		genderMaleRadioBtn.click();
		patientAddressTxt.sendKeys(patAddress);
		patientAgeTxt.sendKeys(patAge);
		medicalHistoryTxt.sendKeys(medicalHistory);
		addBtn.click();
	}
	/**
	 * 
	 * Adding patients by help of this credentials(Female)
	 * @param patName
	 * @param PatContactNo
	 * @param patEmail
	 * @param patAddress
	 * @param patAge
	 * @param medicalHistory
	 */
	public void addFemalePatients(String patName,String PatContactNo, String patEmail, String patAddress, String patAge, String medicalHistory) {
		patientsDropdown.click();
		addPatMod.click();
		enterPatientNameTxt.sendKeys(patName);
		patientContactNoTxt.sendKeys(PatContactNo);
		patientEmailTxt.sendKeys(patEmail);
		
		genderFemaleRadioBtn.click();
		patientAddressTxt.sendKeys(patAddress);
		patientAgeTxt.sendKeys(patAge);
		medicalHistoryTxt.sendKeys(medicalHistory);
		addBtn.click();
	}
	public boolean verifyingAddedPatient(WebDriver driver,String patName) {
	driver.findElement(By.xpath("//td[text()='"+patName+"']/..//i[@class='fa fa-eye']")).click();
	boolean addedpatientName = driver.findElement(By.xpath("(//td[text()='"+patName+"'])[1]")).isDisplayed();
	return addedpatientName;
	}
}
