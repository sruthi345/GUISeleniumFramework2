package com.comcast.hms.doctorModule;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.PatientBaseClass;
import com.comcast.crm.objectrepositoryutility.BookAppointment;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
/**
 * Book an Appointment in patient module
 * cancel the appointment in doctor module
 * verifying whether appointment is cancelled or not
 */
public class BookAndCancelAppointmentAndViewInAppointmentHistory extends PatientBaseClass{
	
	@Test
	public void BookingAndCancelAppointment() throws Throwable {
	
		BookAppointment bookApp=new BookAppointment(driver);
		bookApp.getBookAppointmentlink().click();
		String doctorSpecialization=eLib.getDataFromExcelDoctor("BookPatAppointment", 1, 0);
		System.out.println(doctorSpecialization);
		String doctorSpecialization1=eLib.getDataFromExcelDoctor("BookPatAppointment", 1, 0);
		System.out.println(doctorSpecialization1);
		String doctorName=eLib.getDataFromExcelDoctor("BookPatAppointment", 1, 1);
		System.out.println(doctorName);
		bookApp.BookAppointment(doctorSpecialization, doctorName);
		System.out.println("sucess");
		wLib.switchtoAlertAndAccept(driver);
		configAM();
		//Login as Doctor
		String USERNAME = System.getProperty("Doctorusername" , fLib.getDataFromPropertiesFile("Doctorusername"));
		String PASSWORD = System.getProperty("Doctorpassword" , fLib.getDataFromPropertiesFile("Doctorpassword"));
		hp = new Home(driver);
		hp.getDoctorLoginClickHereButton().click();
		LoginPage lp = new LoginPage(driver);
		lp.loginToDoctor(driver, USERNAME, PASSWORD);
		//Click on AppointmentHistory
		DoctorDashboardPage doc=new DoctorDashboardPage(driver);
		doc.getAppointmentHistoryBtn().click();
		System.out.println("History");
		String patName1=eLib.getDataFromExcelDoctor("BookPatAppointment", 3, 0);
		bookApp.verifyBookAppointment(patName1);
		wLib.switchtoAlertAndAccept(driver);
	}
}
