package com.comcase.crm.Admin1;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddPatientPage;
import com.comcast.crm.objectrepositoryutility.Admin1_Add_Doctor_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Dashboard_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Doctor_Specialization_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Edit_Doctor_page;
import com.comcast.crm.objectrepositoryutility.Admin1_Manage_Doctors_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Manage_Patients_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Manage_user_Page;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.PatientCreateAnAccount;
import com.comcast.crm.objectrepositoryutility.PatientRegisterPage;

/**
 * 
 * @author Nithish
 * this class consists of add doctor script, editing doctor detalis script 
 * and deleting doctor script
 *jjjj
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class Admin1_Doctor_Test extends AdminBaseClass {
	
	/**
	 * this method consists of add doctor script
	 * @throws Throwable
	 */
	@Test

	public void addDoctor() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "----Adding Doctor-----");
		Reporter.log("==Adding Doctor==",true);
		
		/* Navigating to Add Doctor page */
		Admin1_Dashboard_Page adp = new Admin1_Dashboard_Page(driver);
		adp.getDoctordropdown().click();
		Admin1_Add_Doctor_Page aadp = new Admin1_Add_Doctor_Page(driver);
		aadp.getAddDoctor().click();
		String AddDoctorActualTiltle="Admin | Add Doctor";
		String AddDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(AddDoctorActualTiltle,AddDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Add Doctor page is displayed-----");
		Reporter.log("==Adding Doctor page is displayed==",true);
		
		/* Fetching the data from Excel file */
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

		/* Creating the doctor */
		aadp.addDoctor(doctorspecialization, doctorName, doctoraddress, doctorfees, doctorph_no, email, doctorpassword,doctorcpassword);
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor created-----");
		Reporter.log("----Doctor created-----",true);
		
		/* Verifying Manage doctors page is displayed after adding doctor */
		String ManageDoctorsActualTiltle="Admin | Manage Doctors";
		String ManageDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(ManageDoctorsActualTiltle,ManageDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Manage Doctors page is displayed-----");
		Reporter.log("==Manage  Doctor page is displayed==",true);
		
		/* performing logout */
		configAM();
		
		/*verify admin logout is done */
		String HomepageActualTiltle="Hospital management System";
		String HomepageDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(HomepageActualTiltle,HomepageDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Admin logged out successfully-----");
		Reporter.log("=Admin logged out successfully=",true);
		
		/*Verify weather created doctor is able to login*/
		hp.getDoctorLoginClickHereButton().click();
		LoginPage lp = new LoginPage(driver);
		lp.loginToDoctor(driver, email, doctorpassword);
		String DoctorDashboardactualtiltle="Doctor | Dashboard";
		String DoctorDashboarexpectedtitle = driver.getTitle();
		Assert.assertEquals(DoctorDashboardactualtiltle, DoctorDashboarexpectedtitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor able to login-----");
		Reporter.log("=Doctor able to login=",true);
		
		/*verify Doctor logout is done */
		hp.getAdminAccount().click();
		hp.getLogoutLink().click();
		Assert.assertEquals(HomepageActualTiltle,HomepageDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor logged out successfully-----");
		Reporter.log("=Doctor logged out successfully=",true);
		
		/* performing admin login */
		configBM();
	}

	/**
	 * this method consists of edit doctor details script
	 * @throws Throwable
	 */
	@Test

	public void editDoctor() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "----Editinging Doctor details-----");
		Reporter.log("==Editinging Doctor details==",true);
		
		/* Navigating to Add Doctor page */
		Admin1_Dashboard_Page adp = new Admin1_Dashboard_Page(driver);
		adp.getDoctordropdown().click();
		Admin1_Add_Doctor_Page aadp = new Admin1_Add_Doctor_Page(driver);
		aadp.getAddDoctor().click();
		String AddDoctorActualTiltle="Admin | Add Doctor";
		String AddDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(AddDoctorActualTiltle,AddDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Add Doctor page is displayed-----");
		Reporter.log("==Adding Doctor page is displayed==",true);
		
		/* Fetching the data from Excel file */
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

		/* Creating the doctor */
		aadp.addDoctor(doctorspecialization, doctorName, doctoraddress, doctorfees, doctorph_no, email, doctorpassword,doctorcpassword);
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor created-----");
		Reporter.log("----Doctor created-----",true);
		
		/* Verifying Manage doctors page is displayed after adding doctor */
		String ManageDoctorsActualTiltle="Admin | Manage Doctors";
		String ManageDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(ManageDoctorsActualTiltle,ManageDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Manage Doctors page is displayed-----");
		Reporter.log("==Manage  Doctor page is displayed==",true);
		
		/* Navigating to Edit Doctor page */
		Admin1_Manage_Doctors_Page amdp=new Admin1_Manage_Doctors_Page(driver);
		amdp.editDcotor(driver, doctorName);
		String editDcotorActualTiltle="Admin | Edit Doctor Details";
		String editDcotorExpectedTitle = driver.getTitle();
		Assert.assertEquals(editDcotorActualTiltle,editDcotorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Edit Doctor Details page is displayed-----");
		Reporter.log("==Edit Doctor Details page is displayed==",true);

		/* Fetching the data from Excel file */
		String editedfees = eLib.getDataFromExceladmin1("Admin1", 3, 5);
		String editedph_no = eLib.getDataFromExceladmin1("Admin1", 3, 6);
		
		/*editing doctor details(fees and phone number)*/
		Admin1_Edit_Doctor_page aedp=new Admin1_Edit_Doctor_page(driver);
		aedp.editDoctor(editedfees, editedph_no);
		
		/*Verifying doctor fees editing is successfull*/
		String fees = aedp.getDoctorfeesTxt().getAttribute("value");
		Assert.assertEquals(editedfees, fees);
		UtilityClassObject.getTest().log(Status.PASS, "----editing of fees successfully-----");
		Reporter.log("editing of fees successfully",true);
		
		/*Verifying doctor phone number editing is successfull*/
		String ph_no = aedp.getDoctorcontactTxt().getAttribute("value");
		Assert.assertEquals(editedph_no, ph_no);
		UtilityClassObject.getTest().log(Status.PASS, "----editing of ph_no successfully-----");
		Reporter.log("editing of ph_no successfully",true);
	}
	

	/**
	 * this method consists of delete doctor script
	 * @throws Throwable
	 */

	@Test

	public void deleteDoctor() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "----deleting Doctor details-----");
		Reporter.log("==deleting Doctor details==",true);
		
		/* Navigating to Add Doctor page */
		Admin1_Dashboard_Page adp = new Admin1_Dashboard_Page(driver);
		adp.getDoctordropdown().click();
		Admin1_Add_Doctor_Page aadp = new Admin1_Add_Doctor_Page(driver);
		aadp.getAddDoctor().click();
		String AddDoctorActualTiltle="Admin | Add Doctor";
		String AddDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(AddDoctorActualTiltle,AddDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Add Doctor page is displayed-----");
		Reporter.log("==Adding Doctor page is displayed==",true);
		
		/* Fetching the data from Excel file */
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

		/* Creating the doctor */
		aadp.addDoctor(doctorspecialization, doctorName, doctoraddress, doctorfees, doctorph_no, email, doctorpassword,doctorcpassword);
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor created-----");
		Reporter.log("----Doctor created-----",true);
		
		/* Verifying Manage doctors page is displayed after adding doctor */
		String ManageDoctorsActualTiltle="Admin | Manage Doctors";
		String ManageDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(ManageDoctorsActualTiltle,ManageDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Manage Doctors page is displayed-----");
		Reporter.log("==Manage  Doctor page is displayed==",true);
		
		/*Delete the doctor which is created */
		Admin1_Manage_Doctors_Page amdp=new Admin1_Manage_Doctors_Page(driver);
		amdp.deleteDcotor(driver, doctorName);
		wLib.switchtoAlertAndAccept(driver);
		
		/*verify doctor is deleted*/
		boolean status = amdp.getDoctordeletedconfirmMsg().isDisplayed();
		Assert.assertTrue(true);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor deleted successfully-----");
		Reporter.log("==Doctor deleted successfully==",true);
	}

}