package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftPanel {

	public LeftPanel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patient;
	
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement appointmntHstry;
	
	@FindBy(xpath = "//span[text()=' Conatctus Queries ']")
	private WebElement queries;
	
	@FindBy(xpath = "//span[text()=' Reports ']")
	private WebElement reports;
	
	@FindBy(xpath = "//span[text()=' Pages ']")
	private WebElement pages;
}
