package com.comcast.FidusiaObjectRepsitory;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.ExcelUtility;
import com.genericUtility.WebDriverUtility;

public class AddUserAccountPage 
{

	
		@FindBy(xpath="//a[@data-toggle='modal']//i[@class='fas fa-fw fa-plus']")private WebElement userAccountAdd;
		@FindBy(xpath="//select[@name='empid']")private WebElement employeeDropD;
		@FindBy(xpath="//div[@class='form-group']//input[@placeholder='Username']")private WebElement username;
		@FindBy(xpath="//div[@class='form-group']//input[@placeholder='Password']")private WebElement pssword;
		@FindBy(xpath="//div[@class='modal fade show']/div/div//button[@type='submit']")private WebElement saveBtn;
//		@FindBy(xpath="//img[@class='img-profile rounded-circle']")private WebElement userLoginImg;
//		@FindBy(xpath="//a[@data-target='#logoutModal']")private WebElement Adminlogout;
//		@FindBy(xpath="(//div[@class='modal-footer']//a[.='Logout'])[1]")private WebElement logOutpopUp;
		
		
		public  AddUserAccountPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}


		public WebElement getUserAccountAdd() {
			return userAccountAdd;
		}


		public WebElement getEmployeeDropD() {
			return employeeDropD;
		}


		public WebElement getUsername() {
			return username;
		}


		public WebElement getPssword() {
			return pssword;
		}


		public WebElement getSaveBtn() {
			return saveBtn;
		}


//		public WebElement getUserLoginImg() {
//			return userLoginImg;
//		}
//
//
//		public WebElement getAdminlogout() {
//			return Adminlogout;
//		}
//
//
//		public WebElement getLogOutpopUp() {
//			return logOutpopUp;
//		}
		
		
		public void userOptions(String us,String Pw) throws InterruptedException
		{
			
			username.sendKeys(us);
			pssword.sendKeys(Pw);
			saveBtn.click();
			//userLoginImg.click();
			//Adminlogout.click();
			Thread.sleep(3000);
			//logOutpopUp.click();
			
			//userAccountAdd.click();
			
		}
		
//		public void adminLogOut()
//		{
//			Adminlogout.click();
//		}
//		
		public void empDropd() throws EncryptedDocumentException, IOException 
		{
			 WebDriverUtility wdu=new WebDriverUtility();
			 ExcelUtility eu=new ExcelUtility();
			 wdu.SelectOptionFromDropDownVISIBLETEXT(employeeDropD,eu.readDataFromExcel("AddUser_InAccounts09", 5, 1)); 
		}
		
}

