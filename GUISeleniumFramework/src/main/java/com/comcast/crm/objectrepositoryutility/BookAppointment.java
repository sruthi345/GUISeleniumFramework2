package com.comcast.crm.objectrepositoryutility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class BookAppointment {
	WebDriver driver;
	 public BookAppointment(WebDriver driver) {             
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(partialLinkText="Book Appointment")
	 private WebElement BookAppointmentlink;

	 public WebElement getBookAppointmentlink()
	 {
	 	return BookAppointmentlink ;
	 }
	 
	 @FindBy(name="Doctorspecialization")
	 private WebElement Doctorspecializationdropdown;

	 public WebElement getDoctorspecializationdropdown()
	 {
	 	return Doctorspecializationdropdown ;
	 }
	 
	 @FindBy(name="doctor")
	 private WebElement Doctordropdown;

	 public WebElement getDoctordropdown()
	 {
	 	return Doctordropdown ;
	 }
	 
	 @FindBy(name="fees")
	 private WebElement counsultancyFees;

	 public WebElement getcounsultancyFees()
	 {
	 	return counsultancyFees ;
	 }
	 
	 @FindBy(name="fees")
	 private WebElement datetextfield;

	 public WebElement getdatetextfield()
	 {
	 	return datetextfield ;
	 }
	 
	 @FindBy(name="appdate")
	 private WebElement appdate;

	 public WebElement getappdate()
	 {
	 	return appdate ;
	 }
	 
	 @FindBy(name="appdate")
	 private WebElement apptime;

	 public WebElement getapptime()
	 {
	 	return apptime ;
	 }
	 
	 @FindBy(name="submit")
	 private WebElement submitBtn;

	 public WebElement getsubmitBtn()
	 {
	 	return submitBtn ;
	 }
	 
	 	 JavaUtility ju=new JavaUtility();
	 	 String date = ju.getSystemDateYYYYDDMM();
		 DateFormat df=new SimpleDateFormat("hh:mm");
		 Calendar calobj=Calendar.getInstance();
		 String currentTime = df.format(calobj.getTime());
	 
	 public void BookAppointment(String doctorSpecilization,String doctor)
	 {
		 BookAppointmentlink.click();
		 System.out.println("book");
		 Doctorspecializationdropdown.sendKeys(doctorSpecilization);
		 Doctordropdown.sendKeys(doctor);
		 datetextfield.sendKeys(date);
		 apptime.sendKeys(currentTime);
		 submitBtn.click(); 
	 }
	 public void verifyBookAppointment(String patName) throws InterruptedException {
		 System.out.println("=====");
		 driver.findElement(By.xpath("//td[text()='"+patName+"']/..//td[contains(text(),'"+date+"')]"));
		
		
	 }
}
