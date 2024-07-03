package com.comcase.crm.Admin1;

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.objectrepositoryutility.Admin1_Add_Doctor_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Dashboard_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Doctor_Specialization_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Manage_Doctors_Page;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class Doctor_Test extends AdminBaseClass {

	@Test

	public void addDoctor() throws Throwable {

		Admin1_Dashboard_Page adp = new Admin1_Dashboard_Page(driver);
		adp.getDoctordropdown().click();

		Admin1_Add_Doctor_Page aadp = new Admin1_Add_Doctor_Page(driver);
		
		String doctorspecialization = eLib.getDataFromExceladmin1("Admin1", 1, 2);
		String doctorName = eLib.getDataFromExceladmin1("Admin1", 1, 3);
		String doctoraddress = eLib.getDataFromExceladmin1("Admin1", 1, 4);
		String doctorfees = eLib.getDataFromExceladmin1("Admin1", 1, 5);
		String doctorph_no = eLib.getDataFromExceladmin1("Admin1", 1, 6);
		String doctoremail = eLib.getDataFromExceladmin1("Admin1", 1, 7) + jLib.getRandomNumber();
		String emailcom = eLib.getDataFromExceladmin1("Admin1", 1, 8);
		String email = doctoremail + emailcom;
		String doctorpassword = eLib.getDataFromExceladmin1("Admin1", 1, 9);
		String doctorcpassword = eLib.getDataFromExceladmin1("Admin1", 1, 10);

		aadp.addDoctor(doctorspecialization, doctorName, doctoraddress, doctorfees, doctorph_no, email, doctorpassword,
				doctorcpassword);

		wLib.switchtoAlertAndAccept(driver);
		System.out.println("----Doctor created-----");

		configAM();
		System.out.println("=Admin logout=");

		hp.getDoctorLoginClickHereButton().click();
		LoginPage lp = new LoginPage(driver);
		lp.loginToDoctor(driver, email, doctorpassword);
		System.out.println("=Doctor login=");

		hp.getAdminAccount().click();
		hp.getLogoutLink().click();

		System.out.println("=Doctor logout=");

		configBM();
		System.out.println("=Admin login=");

	}

	@Test

	public void editDoctor() throws Throwable {
		
		Admin1_Dashboard_Page adp = new Admin1_Dashboard_Page(driver);
		adp.getDoctordropdown().click();

		Admin1_Add_Doctor_Page aadp = new Admin1_Add_Doctor_Page(driver);
		
		String doctorspecialization = eLib.getDataFromExceladmin1("Admin1", 1, 2);
		String doctorName = eLib.getDataFromExceladmin1("Admin1", 1, 3);
		String doctoraddress = eLib.getDataFromExceladmin1("Admin1", 1, 4);
		String doctorfees = eLib.getDataFromExceladmin1("Admin1", 1, 5);
		String doctorph_no = eLib.getDataFromExceladmin1("Admin1", 1, 6);
		String doctoremail = eLib.getDataFromExceladmin1("Admin1", 1, 7) + jLib.getRandomNumber();
		String emailcom = eLib.getDataFromExceladmin1("Admin1", 1, 8);
		String email = doctoremail + emailcom;
		String doctorpassword = eLib.getDataFromExceladmin1("Admin1", 1, 9);
		String doctorcpassword = eLib.getDataFromExceladmin1("Admin1", 1, 10);

		aadp.addDoctor(doctorspecialization, doctorName, doctoraddress, doctorfees, doctorph_no, email, doctorpassword,
				doctorcpassword);

		wLib.switchtoAlertAndAccept(driver);
		System.out.println("----Doctor created-----");

		configAM();
		System.out.println("=Admin logout=");

		hp.getDoctorLoginClickHereButton().click();
		LoginPage lp = new LoginPage(driver);
		lp.loginToDoctor(driver, email, doctorpassword);
		System.out.println("=Doctor login=");

		hp.getAdminAccount().click();
		hp.getLogoutLink().click();

		System.out.println("=Doctor logout=");

		configBM();
		System.out.println("=Admin login=");
		
		adp.getDoctordropdown().click();
		adp.getManageDoctorsLink().click();
		Admin1_Manage_Doctors_Page amdp=new Admin1_Manage_Doctors_Page(driver);

	}

}
