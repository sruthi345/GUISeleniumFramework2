package com.comcast.hms.doctorModule;
/**
 * Adding Doctor and Verify doctor in manage doctor feature(Admin Module)
 * 
 */
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.Admin1_Add_Doctor_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Dashboard_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Manage_Doctors_Page;

public class AddDoctorAndVerifyInManageDoctorPageTest extends AdminBaseClass{
	
	@Test
	public void CreateDoctorAndVerify() throws Throwable{
		//Adding Doctor in Admin Module
		Admin1_Dashboard_Page doctor=new Admin1_Dashboard_Page(driver);
		Admin1_Add_Doctor_Page addDoctor=new Admin1_Add_Doctor_Page(driver);
		//Fetching data from excel
		doctor.getDoctordropdown().click();
		String doctorSpecialization = eLib.getDataFromExceladmin1("Admin1", 1, 2);
		String doctorName = eLib.getDataFromExceladmin1("Admin1", 1, 3)+jLib.getRandomNumber();
		String doctorAddress = eLib.getDataFromExceladmin1("Admin1", 1, 4);
		String doctorFees = eLib.getDataFromExceladmin1("Admin1", 1, 5);
		String doctorNo = eLib.getDataFromExceladmin1("Admin1", 1, 6);
		String doctoremail = eLib.getDataFromExceladmin1("Admin1", 1, 7) + jLib.getRandomNumber();
		String emailcom = eLib.getDataFromExceladmin1("Admin1", 1, 8);
		String email = doctoremail + emailcom;
		String doctorPwd = eLib.getDataFromExceladmin1("Admin1", 1, 9);
		String doctorConfirmPwd = eLib.getDataFromExceladmin1("Admin1", 1, 10);
		addDoctor.addDoctor(doctorSpecialization, doctorName, doctorAddress, doctorFees, doctorNo, email, doctorPwd, doctorConfirmPwd);
		//Handling Alert
		wLib.switchtoAlertAndAccept(driver);
		System.out.println("handled");
		//Added Doctor verify in Manage patient page
		Thread.sleep(2000);
		Admin1_Manage_Doctors_Page amdp=new Admin1_Manage_Doctors_Page(driver);
		boolean status = amdp.verifyAddedDoctor(driver, doctorName);
		System.out.println(status);
		Assert.assertTrue(status);
		
	}
}
