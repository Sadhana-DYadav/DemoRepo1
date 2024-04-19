package com.comcast.FidusiaObjectRepsitory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createSupplierPage 
{
		
		@FindBy(xpath="//a[@data-toggle='modal']/i[@class='fas fa-fw fa-plus']")private WebElement addSupplierBtn;
		
		@FindBy(name ="companyname")private WebElement ComNametxt;
		@FindBy(id="province")private WebElement provinceTxt;
		@FindBy(id="city")private WebElement cityDropD;
		
		@FindBy(xpath="//option[contains(.,'Select City')]/parent::select[@id='city']/parent::div/following-sibling::div/input[@name='phonenumber']")private WebElement phoneNoTxt;
		@FindBy(xpath="//option[contains(.,'Select City')]/parent::select[@id='city']/ancestor::div[@class='modal-body']//descendant::button[@class='btn btn-success']")private WebElement saveBtn;
		@FindBy(xpath="//input[@type='search']")private WebElement searchTxt;
		@FindBy(xpath="//tr[@class='odd']//td[.='Bucay']")private WebElement actualData;
		
		//initialization
		public createSupplierPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}


		

		//utilization
		
		public WebElement getAddSupplierBtn() 
		{
			return addSupplierBtn;
		}
		public WebElement getSearchTxt() {
			return searchTxt;
		}




		public WebElement getComNametxt() 
		{
			return ComNametxt;
		}

		public WebElement getProvinceTxt() 
		{
			return provinceTxt;
		}

		public WebElement getPhoneNoTxt() 
		{
			return phoneNoTxt;
		}

		public WebElement getSaveBtn() 
		{
			return saveBtn;
		}
		
		public WebElement getCityDropD() 
		{
			return cityDropD;
		}

		public WebElement getActualData() {
			return actualData;
		}
		
		//BusinessClass
		
		
		public void createSupplierForm(WebDriver driver, String CompanyName,String provience, String city, String PhoneNumber) throws InterruptedException 
		{
			Thread.sleep(3000);
			Actions a = new Actions(driver);
			a.click(addSupplierBtn).perform();
			Thread.sleep(3000);
			ComNametxt.sendKeys(CompanyName);
			provinceTxt.sendKeys(provience);
			cityDropD.sendKeys(city);
			phoneNoTxt.sendKeys(PhoneNumber);
			saveBtn.click();
			//searchTxt();
			//actualData();
		}
}