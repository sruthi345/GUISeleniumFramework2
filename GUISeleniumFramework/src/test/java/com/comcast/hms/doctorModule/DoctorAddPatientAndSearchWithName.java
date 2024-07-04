package com.comcast.hms.doctorModule;

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.objectrepositoryutility.AddPatientPage;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.Search_ManagePatientPage;

public class DoctorAddPatientAndSearchWithName extends DoctorBaseClass{

	@Test
	public void addingPatientAndSearch() throws Throwable {
		//Adding patient
		AddPatientPage addPat=new AddPatientPage(driver);
		addPat.getPatientsDropdown().click();
		addPat.getAddPatMod().click();
		String patName = eLib.getDataFromExcelDoctor("Doctor_Module",3, 0);
		System.out.println(patName);
		String patContactNO = eLib.getDataFromExcelDoctor("Doctor_Module",3, 1);
		System.out.println(patContactNO);
		String patEmail=eLib.getDataFromExcelDoctor("Doctor_Module", 3, 2)+jLib.getRandomNumber();
		System.out.println(patEmail);
		String patEmail1=eLib.getDataFromExcelDoctor("Doctor_Module", 3, 3);
		System.out.println(patEmail1);
		String email=patEmail+patEmail1;
		System.out.println(email);
		String patAddress=eLib.getDataFromExcelDoctor("Doctor_Module", 3, 5);
		System.out.println(patAddress);
		String patAge=eLib.getDataFromExcelDoctor("Doctor_Module", 3, 6);
	    String medicalHis=eLib.getDataFromExcelDoctor("Doctor_Module", 3, 7);
	    addPat.addMalePatients(patName, patContactNO, email, patAddress, patAge, medicalHis);
	    //Click on search feature
	    Search_ManagePatientPage searchPat=new Search_ManagePatientPage(driver);
	    DoctorDashboardPage doctpage=new DoctorDashboardPage(driver);
	    doctpage.getSearchFeatureBtn().click();
	    searchPat.searchByName(patName);
	    searchPat.getSearchBtn().click();
	    System.out.println("patient");
	    //Verify the patient name
	    searchPat.verifyAfterSearch(driver, patName);
	}
}
