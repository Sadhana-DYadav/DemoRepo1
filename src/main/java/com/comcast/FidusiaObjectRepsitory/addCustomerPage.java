package com.comcast.FidusiaObjectRepsitory;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addCustomerPage 
{
	@FindBy(xpath="//div[@class='modal fade show']//div/div[@class='modal-body']//input[@name='firstname']")private WebElement employeeFiirstnameTxt;
	@FindBy(xpath="//div[@class='modal fade show']//div/div[@class='modal-body']//input[@name='lastname']")private WebElement employeeLastNameTxt;
	@FindBy(xpath="//div[@class='modal fade show']//div/div[@class='modal-body']//input[@name='phonenumber']")private WebElement employeePhoneNoTxt;
	@FindBy(xpath="//div[@class='modal fade show']//div/div[@class='modal-body']//button[@type='submit']")private WebElement employeeSubmitBtn;
	
	
	
	
	
	
	
	
	public WebElement getEmployeeFiirstnameTxt() {
		return employeeFiirstnameTxt;
	}

	public WebElement getEmployeeLastNameTxt() {
		return employeeLastNameTxt;
	}

	public WebElement getEmployeePhoneNoTxt() {
		return employeePhoneNoTxt;
	}

	public WebElement getEmployeeSubmitBtn() {
		return employeeSubmitBtn;
	}

	public  addCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void posMajorTab(String fname, String Lname, String Phone) throws IOException
	{
		employeeSubmitBtn.click();
		employeeFiirstnameTxt.sendKeys(fname);
		employeeLastNameTxt.sendKeys(Lname);
		
		employeePhoneNoTxt.sendKeys(Phone);
	}
	
}
