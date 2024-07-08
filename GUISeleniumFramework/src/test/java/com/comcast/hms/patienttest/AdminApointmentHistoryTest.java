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
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.DashboardPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AdminApointmentHistoryTest extends PatientBaseClass {
	@Test
	public void AppHistoryTest() throws Throwable {

		/* featching data from excel */
		String docSpecilization = eLib.getDataFromExcel("patient", 5, 1);
		String doctorName = eLib.getDataFromExcel("patient", 5, 2);

		/* by using bussinesslogic bookingAppointment */
		DashboardPage dboard = new DashboardPage(driver);
		dboard.BookAppointment(docSpecilization, doctorName);

		/* switch DashboardPage */
		wLib.switchtoAlertAndAccept(driver);
		String actualTitle = "User | Book Appointment";
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----patient appointment is booked-----");
		Reporter.log("==patient appointment is booked==", true);

		// logout as patient
		configAM();
		String actuallogTitle = "Hospital management System";
		String expectedlogoutTitle = driver.getTitle();
		Assert.assertEquals(actuallogTitle, expectedlogoutTitle);

		// login as admin
		String USERNAME = System.getProperty("Adminusername", fLib.getDataFromPropertiesFile("Adminusername"));
		String PASSWORD = System.getProperty("Adminpassword", fLib.getDataFromPropertiesFile("Adminpassword"));
		hp = new Home(driver);
		hp.getAdminLoginClickHereButton().click();
		String actualadTitle = "Hospital management System";
		String expectedadTitle = driver.getTitle();
		Assert.assertEquals(actualadTitle, expectedadTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----login as admin-----");
		Reporter.log("==login as admin==", true);
		LoginPage lp = new LoginPage(driver);
		lp.loginToAdmin(driver, USERNAME, PASSWORD);

		// clicking on Appointment history
		dboard.getadminAppointHistory().click();
		String actualadminTitle = "Patients | Appointment History";
		String expectedadminTitle = driver.getTitle();
		Assert.assertEquals(actualadminTitle, expectedadminTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Appointmetn history page is displayed-----");
		Reporter.log("==Appointmetn history page is displayed-==", true);

		/* featching the patient data */
		String patientName = eLib.getDataFromExcel("patient", 7, 1);

		/* time format */
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int hrs = date.getHours();
		int min = date.getMinutes();
		String modDate = sdf.format(date) + " " + hrs + ":" + min;
		System.out.println(modDate);

		/* verifying booked Appointment is there or not */
		WebElement status = driver
				.findElement(By.xpath("//td[text()='" + patientName + "']/..//td[contains(text(),'" + modDate + "')]"));
		Actions action = new Actions(driver);
		action.scrollToElement(status);
		boolean display = status.isDisplayed();
		System.out.println(display);
		Assert.assertTrue(display);
		System.out.println("completed");
		UtilityClassObject.getTest().log(Status.PASS,
				"----booked patient appointmentHistoty reflected in admin AppointmetnHistory-----");
		Reporter.log("==booked patient appointment reflected in admin AppointmetnHistory==", true);

		/* logout as admin */
		Home hp = new Home(driver);
		hp.getAdminAccount().click();
		hp.getLogoutLink().click();
		String actuallogoutTitle = "Hospital management System";
		String expectedlogoutadminTitle = driver.getTitle();
		Assert.assertEquals(actuallogoutTitle, expectedlogoutadminTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----logout as admin-----");
		Reporter.log("==logout as admin==", true);

		// featching the login data of Doctor
		System.out.println("=login as docter=");
		String DUSERNAME = System.getProperty("Doctorusername", fLib.getDataFromPropertiesFile("Doctorusername"));
		String DPASSWORD = System.getProperty("Doctorpassword", fLib.getDataFromPropertiesFile("Doctorpassword"));

		// login as doctor
		hp.getDoctorLoginClickHereButton().click();
		lp.loginToDoctor(driver, DUSERNAME, DPASSWORD);
		dboard.getdocAppointHistory().click();
		String actualdoTitle = "Doctor | Appointment History";
		String expecteddocloginTitle = driver.getTitle();
		Assert.assertEquals(actualdoTitle, expecteddocloginTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----login as doctor-----");
		Reporter.log("==login as doctor==", true);

		// verifying booked Appointment is there or not
		String patientName1 = eLib.getDataFromExcel("patient", 7, 1);
		WebElement status1 = driver.findElement(
				By.xpath("//td[text()='" + patientName1 + "']/..//td[contains(text(),'" + modDate + "')]"));
		Actions action1 = new Actions(driver);
		action1.scrollToElement(status1);
		boolean display1 = status.isDisplayed();
		Assert.assertTrue(display1);
		System.out.println("completed");
		UtilityClassObject.getTest().log(Status.PASS,
				"----booked patient appointmentHistoty reflected in doctor AppointmetnHistory-----");
		Reporter.log("==booked patient appointment reflected in Doctor AppointmetnHistory==", true);

//			
	}
}
