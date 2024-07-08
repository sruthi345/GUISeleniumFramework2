package com.comcast.hms.patienttest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

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

/**
 * @author sruthi book appointment as patient and check booked appointment in
 *         doctor
 **/
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class DoctorAppoimentHistoryTest extends PatientBaseClass {
	@Test
	public void DocAppHistoryTest() throws Throwable {

		/* featching the data from the excel */
		String docSpecilization = eLib.getDataFromExcel("patient", 5, 1);
		String doctorName = eLib.getDataFromExcel("patient", 5, 2);
		String USERNAME = System.getProperty("Doctorusername", fLib.getDataFromPropertiesFile("Doctorusername"));
		String PASSWORD = System.getProperty("Doctorpassword", fLib.getDataFromPropertiesFile("Doctorpassword"));

		/* calling the business method */
		DashboardPage dboard = new DashboardPage(driver);
		dboard.BookAppointment(docSpecilization, doctorName);

		/* handeling the alert */
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.PASS, "----alert is handeld-----");
		Reporter.log("==alert is handeld==", true);

		/* logout as patient */
		configAM();
		String actualTitle = "Hospital management System";
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----logout as patient-----");
		Reporter.log("==logout as patient==", true);

		// login as doctor
		hp = new Home(driver);
		hp.getDoctorLoginClickHereButton().click();
		LoginPage lp = new LoginPage(driver);
		lp.loginToDoctor(driver, USERNAME, PASSWORD);
		String actualdocTitle = "Doctor | Dashboard";
		String expecteddocTitle = driver.getTitle();
		Assert.assertEquals(actualdocTitle, expecteddocTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----doctor dashboard page is dispalayed-----");
		Reporter.log("==doctor dashboard page is dispalayed==", true);

		// clicking on appointmentHistory feature
		dboard.getdocAppointHistory().click();
		String actualdappTitle = "Doctor | Appointment History";
		String expectedappTitle = driver.getTitle();
		Assert.assertEquals(actualdappTitle, expectedappTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----doctor dashboard page is dispalayed-----");
		Reporter.log("==doctor dashboard page is dispalayed==", true);

		DateFormat df = new SimpleDateFormat("hh");
		Calendar calobj = Calendar.getInstance();
		String currentTime1 = df.format(calobj.getTime());
		Integer c = Integer.valueOf(currentTime1);
		int n = c.intValue();
		n = n + 12;
		String currentTime = String.valueOf(n);
		System.out.println(currentTime);

		/* verifying bookedAppointment is displaying or not */
		String patientName = eLib.getDataFromExcel("patient", 7, 1);
		WebElement status = driver.findElement(
				By.xpath("//td[text()='" + patientName + "']/..//td[contains(text(),'" + currentTime + "')]"));
		Actions action = new Actions(driver);
		action.scrollToElement(status);
		boolean display = status.isDisplayed();
		Assert.assertTrue(display);
		System.out.println("completed");
		UtilityClassObject.getTest().log(Status.PASS,
				"----booked patient appointmentHistoty reflected in doctor AppointmetnHistory-----");
		Reporter.log("==booked patient appointment reflected in Doctor AppointmetnHistory==", true);

//		

	}
}
