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
	
	@FindBy(xpath = "//span[text()=' Manage Patients ']")
	private WebElement manageptnt;
	
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement appointmntHstry;
	
	@FindBy(xpath = "//span[text()=' Conatctus Queries ']")
	private WebElement ContctedQueries;
	
	@FindBy(xpath = "//span[text()=' Unread Query ']")
	private WebElement unrdQuers;
	
	@FindBy(xpath = "//span[text()=' Read Query ']")
	private WebElement ReadQuers;
	
	@FindBy(xpath = "//span[text()='B/w dates reports ']")
	private WebElement BtwReprts;
	
	@FindBy(xpath = "//span[text()=' Reports ']")
	private WebElement reports;
	
	@FindBy(xpath = "//span[text()=' Pages ']")
	private WebElement pages;
}
