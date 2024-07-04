package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMedicalHistoryPage {
	
	public AddMedicalHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "bp")
	private WebElement bpTxt;
	
	@FindBy(name="bs")
	private WebElement bloodSugarTxt;
	
	@FindBy(name="weight")
	private WebElement weightTxt;
	
	@FindBy(name="temp")
	private WebElement bodyTempTxt;
	
	@FindBy(name="pres")
	private WebElement prescriptionTxt;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public WebElement getBpTxt() {
		return bpTxt;
	}

	public WebElement getBloodSugarTxt() {
		return bloodSugarTxt;
	}

	public WebElement getWeightTxt() {
		return weightTxt;
	}

	public WebElement getBodyTempTxt() {
		return bodyTempTxt;
	}

	public WebElement getPrescriptionTxt() {
		return prescriptionTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
}
