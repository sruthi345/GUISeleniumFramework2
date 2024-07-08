package com.comcast.hms.patienttest;

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

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AppointmentHistoryTest extends PatientBaseClass {
	/**
	 * @author sruthi booking appointment as a patient checking in
	 *         Appointmenthistory
	 */
	@Test
	public void AppHistoryTest() throws Throwable {

		/* featching the data from excel */
		String docSpecilization = eLib.getDataFromExcel("patient", 5, 1);
		String doctorName = eLib.getDataFromExcel("patient", 5, 2);

		/* booking the appointment and handeling the alert */
		DashboardPage dboard = new DashboardPage(driver);
		dboard.BookAppointment(docSpecilization, doctorName);
		wLib.switchtoAlertAndAccept(driver);
		dboard.getDadhboard().click();
		dboard.getViewAppointmentHistorylink().click();
		String actualappTitle = "User | Appointment History";
		String expectedappTitle = driver.getTitle();
		System.out.println(expectedappTitle);
		Assert.assertEquals(actualappTitle, expectedappTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Appointment history page is displyed-----");
		Reporter.log("==Appointment history page is displyed==", true);

		/* date formate */
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
