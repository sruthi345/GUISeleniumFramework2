package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Nithish
 *This page contains Admin_Manage_Doctors elements
 */

public class Admin1_Manage_Doctors_Page {
	

	public Admin1_Manage_Doctors_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void editDcotor(WebDriver driver,String DoctorName) {
	
		driver.findElement(By.xpath("//td[text()='"+DoctorName+"']/..//i[@class='fa fa-pencil']")).click();
	}
	

	public void deleteDcotor(WebDriver driver,String DoctorName) {
	
		driver.findElement(By.xpath("//td[text()='"+DoctorName+"']/..//i[@class='fa fa-times fa fa-white']")).click();
	}
	
	

}
