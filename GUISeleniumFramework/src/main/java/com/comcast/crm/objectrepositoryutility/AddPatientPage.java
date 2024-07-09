package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Anbumathi
 * 
 * Contains add patients by name,contact number, email, gender, address, age, medical history
 *
 */  	

public class AddPatientPage extends WebDriverUtility{
	 WebDriverUtility wbD=new WebDriverUtility();
	 WebDriver driver=null;
	 
	public AddPatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "patname")
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
	
	/**
	 * 
	 * Adding patients by help of this credentials
	 * @param patName
	 * @param PatContactNo
	 * @param patEmail
	 * @param patGender
	 * @param patAddress
	 * @param patAge
	 * @param medicalHistory
	 */
	
	public void addMalePatients(String patName,String PatContactNo, String patEmail, String patAddress, String patAge, String medicalHistory) {
		//wbD.waitForElementPresent(driver,enterPatientNameTxt );
		enterPatientNameTxt.sendKeys(patName);
		patientContactNoTxt.sendKeys(PatContactNo);
		patientEmailTxt.sendKeys(patEmail);
		genderMaleRadioBtn.click();
		patientAddressTxt.sendKeys(patAddress);
		patientAgeTxt.sendKeys(patAge);
		medicalHistoryTxt.sendKeys(medicalHistory);
		addBtn.click();
	}

	public void addFemalePatients(String patName,String PatContactNo, String patEmail, String patAddress, String patAge, String medicalHistory) {
		wbD.waitForElementPresent(driver,enterPatientNameTxt);
		enterPatientNameTxt.sendKeys(patName);
		patientContactNoTxt.sendKeys(PatContactNo);
		patientEmailTxt.sendKeys(patEmail);
		genderFemaleRadioBtn.click();
		patientAddressTxt.sendKeys(patAddress);
		patientAgeTxt.sendKeys(patAge);
		medicalHistoryTxt.sendKeys(medicalHistory);
		addBtn.click();
	}
}
