package com.comcast.crm.objectrepositoryutility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author sruthi
 *
 */
public class DashboardPage extends WebDriverUtility {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Dashboard')] ")
	private WebElement Dadhboard;

	public WebElement getDadhboard() {
		return Dadhboard;
	}

	@FindBy(partialLinkText = "Update Profile")
	private WebElement UpdateProfilelink;

	public WebElement getUpdateProfilelink() {
		return UpdateProfilelink;
	}

	@FindBy(name = "fname")
	private WebElement UserName;

	public WebElement getUserName() {
		return UserName;
	}

	@FindBy(name = "address")
	private WebElement Address;

	public WebElement getAddress() {
		return Address;
	}

	@FindBy(name = "city")
	private WebElement city;

	public WebElement getname() {
		return city;
	}

	@FindBy(name = "submit")
	private WebElement submit;

	public WebElement getsubmit() {
		return submit;
	}

	@FindBy(partialLinkText = "View Appointment History")
	private WebElement ViewAppointmentHistorylink;

	public WebElement getViewAppointmentHistorylink() {
		return ViewAppointmentHistorylink;
	}

	@FindBy(partialLinkText = "Book Appointment")
	private WebElement BookAppointmentlink;

	public WebElement getBookAppointmentlink() {
		return BookAppointmentlink;
	}

	@FindBy(name = "Doctorspecialization")
	private WebElement Doctorspecializationdropdown;

	public WebElement getDoctorspecializationdropdown() {
		return Doctorspecializationdropdown;
	}

	@FindBy(name = "doctor")
	private WebElement Doctordropdown;

	public WebElement getDoctordropdown() {
		return Doctordropdown;
	}

	@FindBy(name = "fees")
	private WebElement counsultancyFees;

	public WebElement getcounsultancyFees() {
		return counsultancyFees;
	}

	@FindBy(name = "fees")
	private WebElement datetextfield;

	public WebElement getdatetextfield() {
		return datetextfield;
	}

	@FindBy(name = "appdate")
	private WebElement appdate;

	public WebElement getappdate() {
		return appdate;
	}

	@FindBy(name = "appdate")
	private WebElement apptime;

	public WebElement getapptime() {
		return apptime;
	}

	@FindBy(name = "submit")
	private WebElement submitBtn;

	public WebElement getsubmitBtn() {
		return submitBtn;
	}

	JavaUtility jLib = new JavaUtility();
	String date = jLib.getSystemDateYYYYDDMM();

	DateFormat df = new SimpleDateFormat("hh:mm");
	Calendar calobj = Calendar.getInstance();
	String currentTime = df.format(calobj.getTime());

	public void BookAppointment(String doctorSpecilization, String doctor) {
		BookAppointmentlink.click();
		Doctorspecializationdropdown.sendKeys(doctorSpecilization);
		Doctordropdown.sendKeys(doctor);
		datetextfield.sendKeys(date);
		apptime.sendKeys(currentTime);
		submitBtn.click();
	}

	public void CurrentTime() {
		DateFormat df = new SimpleDateFormat("hh:mm");
		Calendar calobj = Calendar.getInstance();
		String currentTime = df.format(calobj.getTime());
		System.out.println(currentTime);
	}

	public WebElement verifyAppointmentisbooked(String doctor) {

		WebElement status = driver
				.findElement(By.xpath("//td[text()='" + doctor + "']/..//td[contains(text(),'" + currentTime + "')]"));
		status.isDisplayed();
		return status;
	}

	@FindBy(xpath = " //span[text()=' Appointment History ']")
	private WebElement docAppointHistory;

	public WebElement getdocAppointHistory() {
		return docAppointHistory;
	}

	public boolean verifydocAppointmentisbooked(WebDriver driver, String patientName) {
		System.out.println("inside method");
		boolean status = driver
				.findElement(
						By.xpath("//td[text()='" + patientName + "']/..//td[contains(text(),'" + currentTime + "')]"))
				.isDisplayed();
		return status;
	}

	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement adminAppointHistory;

	public WebElement getadminAppointHistory() {
		return adminAppointHistory;
	}

	public boolean verifyAdminAppointmentisbooked(WebDriver driver, String patientName) {

		boolean status = driver
				.findElement(
						By.xpath("//td[text()='" + patientName + "']/..//td[contains(text(),'" + currentTime + "')]"))
				.isDisplayed();
		return status;
	}

}
