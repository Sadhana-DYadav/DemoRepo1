package com.comcast.FidusiaObjectRepsitory;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.genericUtility.ExcelUtility;

public class createProductPage
{
	@FindBy(xpath="//div[@class='card-header py-3']//a")private WebElement plusIconBtn;
	
	
	@FindBy(xpath="//input[@placeholder='Product Code']")private WebElement prodcodetxt;
	@FindBy(xpath="//input[@placeholder='Name']")private WebElement pronametxt;
	@FindBy(xpath="//textarea[@placeholder='Description']")private WebElement discriptxt;
	@FindBy(xpath="//input[@placeholder='Quantity']")private WebElement quanttxt;
	@FindBy(xpath="//input[@placeholder='Price']")private WebElement pricetxt;
	@FindBy(xpath="//input[@placeholder='On Hand']")private WebElement onHandtxt;
	
	@FindBy(xpath="//select[@name='category']")private WebElement categoryDropD;
	
	@FindBy(xpath="//select[@name='supplier']")private WebElement SupplierTxt;
	@FindBy(xpath="//input[@placeholder='Date Stock In']")private WebElement DstockBtn;
	@FindBy(xpath="//input[@placeholder='Date Stock In']")private WebElement Dstock;
	@FindBy(xpath="//input[@type='date']/ancestor::div[@class='modal-body']/descendant::button[.='Save']")private WebElement sveBtn;
	@FindBy(xpath="//input[@type='search']")private WebElement searchTxt;
	@FindBy(xpath="//tr[@class='odd']//td[.='24111990']")private WebElement actualData;
	
	
	//initialization
	public  createProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
		public WebElement getPlusIconBtn() {
			return plusIconBtn;
		}

		

		public WebElement getProdcodetxt() {
			return prodcodetxt;
		}

		public WebElement getPronametxt() {
			return pronametxt;
		}

		public WebElement getDiscriptxt() {
			return discriptxt;
		}

		public WebElement getSveBtn() {
			return sveBtn;
		}

		public WebElement getQuanttxt() {
			return quanttxt;
		}

		public WebElement getPricetxt() {
			return pricetxt;
		}

		public WebElement getOnHandtxt() {
			return onHandtxt;
		}

		public WebElement getCategoryDropD() 
		{
			return categoryDropD;
		}

		public WebElement getSupplierTxt() 
		{
			return SupplierTxt;
		}

		public WebElement getDstockBtn() {
			return DstockBtn;
		}

		public WebElement getDstock() 
		{
			return Dstock;
		}
		
		public WebElement getSearchTxt() 
		{
			return searchTxt;
		}
		public WebElement getActualData() 
		{
			return actualData;
		}
		
		
		//Business library
		
			public void createProductform(WebDriver driver, String prodcode ,String proname, String discrip, String quant, String onHand, String price) throws IOException, InterruptedException
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(prodcodetxt));
				Thread.sleep(2000);
				prodcodetxt.sendKeys(prodcode);
				Thread.sleep(2000);
				pronametxt.sendKeys(proname);
				discriptxt.sendKeys(discrip);
				quanttxt.sendKeys(quant);
				Thread.sleep(2000);
				onHandtxt.sendKeys(onHand);
				pricetxt.sendKeys(price);
				Thread.sleep(2000);
			}
			 
			public void DropBtn(String search)
			{
				DstockBtn.click();
				searchTxt.sendKeys(search);
				
			}

			public void plusiconbtn()
			{
				plusIconBtn.click();
			}
			public void dateStockTxt(String date) throws EncryptedDocumentException, IOException
			{
				DstockBtn.click();
				Dstock.sendKeys(date);
				sveBtn.click();
			}
			public void searcht()
			{
				searchTxt.sendKeys("24111990");
				actualData.getText();
			}
			public String actuData()
			{
				String data=actualData.getText();
				return data;
			}
			
		}

			
			

			
	


