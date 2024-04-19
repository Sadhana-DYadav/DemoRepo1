package com.comcast.FidusiaObjectRepsitory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.ExcelUtility;

public class invoicePage 
{
	@FindBy(id="txtNumber")private WebElement amountTxt;
	@FindBy(xpath="//button[.='PROCEED TO PAYMENT']")private WebElement paymentbtn;
	
	
	public  invoicePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAmountTxt()
	{
		return amountTxt;
	}

	public WebElement getPaymentbtn() 
	{
		return paymentbtn;
	}

	public void transictionProcess(String amount) throws IOException
	{
		amountTxt.sendKeys(amount);
//		paymentbtn.click();
		
	}
	public void paybtn()
	{
		paymentbtn.click();
	}
}
