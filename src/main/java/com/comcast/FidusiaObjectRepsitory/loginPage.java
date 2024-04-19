package com.comcast.FidusiaObjectRepsitory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.ExcelUtility;


//Declaration
public class loginPage
{
	
		@FindBy(xpath="//input[@placeholder='Username']")private WebElement usernameTextField;
		@FindBy(xpath="//input[@placeholder='Password']")private WebElement passwordTextField;
		@FindBy(xpath="//button[.='Login']")private WebElement loginButton;

		//initialization
		public loginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

//utilization

		public WebElement getUsername() {
			return usernameTextField;
		}

		public WebElement getPassword() {
			return usernameTextField;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}
		
		//Business library
		
		public void loginToApplication(String username, String password) throws IOException
		{
			ExcelUtility eu=new ExcelUtility();
			usernameTextField.sendKeys(username);
			passwordTextField.sendKeys(password);
			loginButton.click();
		}
}