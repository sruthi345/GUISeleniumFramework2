package com.comcast.hms.doctorModule;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.AddPatientPage;
/**
 * Adding patient with erntering all details
 * verifying in manage patients
 * 
 */
public class AddPatientWithEnteringAllDetailsAndVerifyInManagePatients extends DoctorBaseClass{
	
	@Test
	public void addPatientWithName_Contact() throws Throwable{
		//Adding patient with entering all details
		AddPatientPage addPat=new AddPatientPage(driver);
		addPat.getPatientsDropdown().click();
		addPat.getAddPatMod().click();
		String patName = eLib.getDataFromExcelDoctor("Doctor_Module",2, 0);
		System.out.println(patName);
		String patContactNO = eLib.getDataFromExcelDoctor("Doctor_Module",2, 1);
		System.out.println(patContactNO);
		String patEmail=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 2)+jLib.getRandomNumber();
		System.out.println(patEmail);
		String patEmail1=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 3);
		System.out.println(patEmail1);
		String email=patEmail+patEmail1;
		System.out.println(email);
		String patAddress=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 5);
		System.out.println(patAddress);
		String patAge=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 6);
	    String medicalHis=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 7);
	    addPat.addMalePatients(patName, patContactNO, email, patAddress, patAge, medicalHis);
	    //Verify whether added patient is present or not
	    
	    addPat.getPatientsDropdown().click();
		addPat.getManagePat().click();
		String managePatName=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 0);
		System.out.println(managePatName);
		driver.findElement(By.xpath("//td[text()='"+managePatName+"']/..//i[@class='fa fa-eye']")).click();
		String addedpatientName = driver.findElement(By.xpath("(//td[text()='"+managePatName+"'])[1]")).getText();
		System.out.println(addedpatientName);
		//verifying patients is added or not
		assertEquals(managePatName, addedpatientName);
		boolean status=addedpatientName.contains(managePatName);
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(status);
		sa.assertAll();	
		
	}
}
