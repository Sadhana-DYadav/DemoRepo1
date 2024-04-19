package com.comcast.FidusiaObjectRepsitory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.ExcelUtility;

public class UserLoginpage 
{

	@FindBy(xpath="//input[@name='user']")private WebElement useruserName;
	@FindBy(xpath="//input[@name='password']")private WebElement userPassword;
	@FindBy(xpath="//button[.='Login']")private WebElement userLoginbtn;
	
	
	public  UserLoginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	public WebElement getUseruserName() {
		return useruserName;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}
	public WebElement getUserLoginbtn() {
		return userLoginbtn;
	}






	public void userLoginCre() throws IOException
	{
		
//		useruserName.sendKeys(name);
//		userPassword.sendKeys(password);
		
		ExcelUtility eu=new ExcelUtility();
		useruserName.sendKeys(eu.readDataFromExcel("User_logIn", 0, 1));
		userPassword.sendKeys(eu.readDataFromExcel("User_logIn", 1, 1));
		userLoginbtn.click();
	}
}
