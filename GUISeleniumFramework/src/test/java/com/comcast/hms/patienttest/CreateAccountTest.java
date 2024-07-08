package com.comcast.hms.patienttest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.PatientBaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.DashboardPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.PatientRegisterPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateAccountTest extends PatientBaseClass {
	/**
	 * @author sruthi
	 * register as a patient and login as patient
	 *booking appointment as a patient 
	 * checking in  Appointmenthistory                
	 */
	@Test
	public void CreateaccountTest() throws Throwable {
		/* read testscript data form excel */
		String fullName = eLib.getDataFromExcel("patient", 1, 1) + jLib.getRandomNumber();
		String adress = eLib.getDataFromExcel("patient", 1, 2);
		System.out.println(adress);
		String city = eLib.getDataFromExcel("patient", 1, 3);
		String semail = eLib.getDataFromExcel("patient", 1, 4) + jLib.getRandomNumber();
		String lemail = eLib.getDataFromExcel("patient", 1, 5);
		String email = semail + lemail + jLib.getRandomNumber();
		String password = eLib.getDataFromExcel("patient", 1, 6);
		String samepassword = eLib.getDataFromExcel("patient", 1, 7);

		/* logout as patient and switch to home page */
		configAM();
		hp = new Home(driver);
		hp.getPatienLoginClickHereButton().click();
		wLib.switchToTabOnTitle(driver, "user-login.php");

		/*
		 * clicking on create account link and verifying register page is display or not
		 */
		PatientRegisterPage reg = new PatientRegisterPage(driver);
		reg.getPatientCreateAnAccountlink().click();
		String actualregTitle = "User Registration";
		String expectedregTitle = driver.getTitle();
		Assert.assertEquals(actualregTitle, expectedregTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Registration page is displyed-----");
		Reporter.log("==Registration page is displyed==", true);

		/* entering the details of parient and switch back to home page */
		reg.registerAsFemalePatient(fullName, adress, city, email, password, samepassword);
		wLib.switchtoAlertAndAccept(driver);
		driver.close();
		wLib.switchToTabOnURL(driver, "Hospital_Doctor_Patient_Management_System/");

		/* login as patient */
		configBM();
		String actualTitle="User | Dashboard";
		String expectedlogTitle = driver.getTitle();
		 Assert.assertEquals(actualTitle, expectedlogTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----patient login page is displyed-----");
		Reporter.log("==patient login page is displyed==", true);

		/* featching the data from excel */
		String docSpecilization = eLib.getDataFromExcel("patient", 5, 1);
		String doctorName = eLib.getDataFromExcel("patient", 5, 2);
		DashboardPage dboard = new DashboardPage(driver);
		dboard.BookAppointment(docSpecilization, doctorName);
		wLib.switchtoAlertAndAccept(driver);
		dboard.getDadhboard().click();
		dboard.getViewAppointmentHistorylink().click();
		String actualappTitle="User | Appointment History";
		String expectedapphisTitle = driver.getTitle();
		System.out.println(expectedapphisTitle);
		Assert.assertEquals(actualappTitle, expectedapphisTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----appointment history page is displayed-----");
		Reporter.log("==appointment history page is displayed==", true);

		/* date format */
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int hrs = date.getHours();
		int min = date.getMinutes();
		String modDate = sdf.format(date) + " " + hrs + ":" + min;
		System.out.println(modDate);

		// dynamic webElement
		WebElement status = driver
				.findElement(By.xpath("//td[text()='" + doctorName + "']/..//td[contains(text(),'" + modDate + "')]"));
		Actions action = new Actions(driver);
		action.scrollToElement(status);
		boolean display = status.isDisplayed();
		System.out.println(display);
		Assert.assertTrue(display);
		System.out.println("completed");
		UtilityClassObject.getTest().log(Status.PASS, "----booked appointment is verified-----");
		Reporter.log("==booked appointment is verified==", true);

	}

}
