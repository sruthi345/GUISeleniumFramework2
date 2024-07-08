package com.comcast.hms.patienttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.PatientBaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.DashboardPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class EditUserNameTest extends PatientBaseClass {
	/**
	 * @author sruthi
	 * editing the user name
	 *  verify the edited user name is displaying in profile icon 
	 * @throws Throwable
	 */
	@Test
	public void EditNameTest() throws Throwable {
		
		/*Navigating to updateproiflelink */
		DashboardPage dboard = new DashboardPage(driver);
		dboard.getUpdateProfilelink().click();
		String actualTitle="User | Edit Profile";
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----profilelink page is displyed-----");
		Reporter.log("==profilelink page is displyed==", true);
		
		/*editing the user name */
		String expectEditName = eLib.getDataFromExcel("patient", 3, 1);
		System.out.println(expectEditName);
		dboard.getUserName().clear();
		dboard.getUserName().sendKeys(expectEditName);
		dboard.getsubmit().click();
		String actualsubTitle="User | Edit Profile";
		String expectedsubTitle=driver.getTitle();
		Assert.assertEquals(actualsubTitle, expectedsubTitle);
		
		/* Verifying edited patient name is displaying or not */
		String ActualRes = driver.findElement(By.xpath("//span[contains(text(),'" + expectEditName + "')]")).getText();
		Assert.assertEquals(expectEditName, ActualRes);
		UtilityClassObject.getTest().log(Status.PASS, "----patient name is edited-----");
		Reporter.log("==patient name is edited==", true);

	}

}
