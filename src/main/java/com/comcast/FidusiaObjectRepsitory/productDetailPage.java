package com.comcast.FidusiaObjectRepsitory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productDetailPage 
{
	@FindBy(xpath="//tbody/tr[1]/td[5]/div[1]/div[1]/a[1]")private WebElement productDetailElipsBtn;
	@FindBy(xpath="//ul[@class='dropdown-menu text-center show']//a[@type='button'][normalize-space()='Edit']")private WebElement productEditBtn;
	@FindBy(xpath="//textarea[@placeholder='Description']")private WebElement productDiscriptionTxt;
	@FindBy(xpath="//button[.='Update']")private WebElement productUpdateBtn;
	@FindBy(xpath="//th[@aria-label='Price: activate to sort column ascending']")private WebElement priceAceBtn;
	
	
	public  productDetailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getProductDetailElipsBtn() 
	{
		return productDetailElipsBtn;
	}
	public WebElement getProductEditBtn() 
	{
		return productEditBtn;
	}
	public WebElement getProductDiscriptionTxt(String t) 
	{
		return productDiscriptionTxt;
	}
	public WebElement getProductUpdateBtn() 
	{
		return productUpdateBtn;
	}



	public WebElement getPriceAceBtn() {
		return priceAceBtn;
	}
	public void proDetail(String text) throws IOException
	{
		productDetailElipsBtn.click();
		productEditBtn.click();
		productDiscriptionTxt.sendKeys(text);
		productUpdateBtn.click();
		priceAceBtn.click();
		
	}
}
