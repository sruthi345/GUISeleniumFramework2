package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author sruthi
 *
 */
public class MedicalHistory {
	public class BookAppointment {
		WebDriver driver;
		 public BookAppointment(WebDriver driver) {             
			 this.driver = driver;
			 PageFactory.initElements(driver, this);
		 }
	public void eyeIcon(WebDriver driver,String patientName)
	{
		driver.findElement(By.xpath("//td[text()="+patientName+"']/..//i[@class='fa fa-eye']")).click();
	}
	 
}
}
