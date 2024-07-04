package com.comcast.hms.doctorModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.objectrepositoryutility.AddMedicalHistoryPage;
import com.comcast.crm.objectrepositoryutility.AddPatientPage;
import com.comcast.crm.objectrepositoryutility.ManagePatientsPage;

public class DoctorAddingMedicalHistoryTest extends DoctorBaseClass{
	@Test
	public void addMedicalHistory() throws Throwable {
		//Clicking on managePatients
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
	    addPat.addFemalePatients(patName, patContactNO, email, patAddress, patAge, medicalHis);
	    
	    //Clicking on patient dropdown
	    addPat.getPatientsDropdown().click();
		addPat.getManagePat().click();
		
		driver.findElement(By.xpath("//td[text()='"+patName+"']/..//i[@class='fa fa-eye']")).click();
		String addedpatientName = driver.findElement(By.xpath("(//td[text()='"+patName+"'])[1]")).getText();
		//Clicking on AddMedical history button
		ManagePatientsPage addMed=new ManagePatientsPage(driver);
		addMed.getAddMedicalHisBtn().click();
		//Adding Medical History
			
		  String bp=eLib.getDataFromExcelDoctor("AddingMedicalHistory", 1, 0);
		  System.out.println(bp);
		  String bloodSugar=eLib.getDataFromExcelDoctor("AddingMedicalHistory", 1, 1);
		  String weight=eLib.getDataFromExcelDoctor("AddingMedicalHistory", 1, 2);
		  String bodyTem=eLib.getDataFromExcelDoctor("AddingMedicalHistory", 1, 3);
		  String pres=eLib.getDataFromExcelDoctor("AddingMedicalHistory", 1, 4);
		  WebElement title = driver.findElement(By.xpath("//h5[@id='exampleModalLabel']"));
		  Actions a=new Actions(driver);
		  a.moveToElement(title).perform();
		  wLib.waitForElementPresent(driver,  title);
		  System.out.println("==title==");
		
		AddMedicalHistoryPage addMedHis=new AddMedicalHistoryPage(driver);
		
		addMedHis.addingMedicalHis(bp, bloodSugar, weight, bodyTem, pres);
		WebElement submit = driver.findElement(By.xpath("//button[@name='submit']"));
		a.moveToElement(submit).click().build().perform();
		wLib.switchtoAlertAndAccept(driver);
		
	}
}
