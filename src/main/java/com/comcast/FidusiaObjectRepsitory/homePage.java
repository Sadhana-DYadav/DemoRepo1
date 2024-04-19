package com.comcast.FidusiaObjectRepsitory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage 
{
	@FindBy(xpath="//span[.='Product']")private WebElement productBtn;
	@FindBy(xpath="//span[.='Supplier']")private WebElement supplierBtn;
	@FindBy(xpath="//span[.='POS']")private WebElement pOSBtn;
	@FindBy(xpath="//span[.='Accounts']")private WebElement accountBtn;
	@FindBy(xpath="//img[@class='img-profile rounded-circle']")private WebElement userLoginImg;
	@FindBy(xpath="//a[@data-target='#logoutModal']")private WebElement Adminlogout;
	@FindBy(xpath="(//div[@class='modal-footer']//a[.='Logout'])[1]")private WebElement logOutpopUp;
	
	@FindBy(xpath="//a[.='View All Products']")private WebElement viewProductBtn;
	@FindBy(id="sidebarToggle")private WebElement slidetogalBtn;
	@FindBy(xpath="//th[@aria-label='Price: activate to sort column ascending']")private WebElement descendingBtn;
	
	//initialization
	public  homePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getProductBtn()
	{
		return productBtn;
	}
	public WebElement getSupplierBtn() 
	{
		return supplierBtn;
	}
	

	public WebElement getpOSBtn()
	{
		return pOSBtn;
	}

	public WebElement getAccountBtn() 
	{
		return accountBtn;
	}

	public WebElement getUserLoginImg() {
		return userLoginImg;
	}

	

//	public WebElement getAdminlogout() {
//		return Adminlogout;
//	}
//
//	public WebElement getLogOutpopUp() {
//		return logOutpopUp;
//	}

	public WebElement getViewProductBtn() {
		return viewProductBtn;
	}

	public WebElement getSlidetogalBtn() {
		return slidetogalBtn;
	}

	public WebElement getDescendingBtn() {
		return descendingBtn;
	}

	//Business library
	public void homepageMajorTab() throws IOException
	{
		productBtn.click();
		supplierBtn.click();
		pOSBtn.click();
		accountBtn.click();
		viewProductBtn.click();
		
	}
	public void imgLogoutUSer() throws InterruptedException 
	{
		userLoginImg.click();
		Thread.sleep(3000);
		Adminlogout.click();
		Thread.sleep(3000);
		logOutpopUp.click();
	}
//	public void adlogout()
//	{
//		Adminlogout.click();
//	}
	
}
