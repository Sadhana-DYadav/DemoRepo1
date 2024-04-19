package com.comcast.FidusiaObjectRepsitory;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.ExcelUtility;
import com.genericUtility.WebDriverUtility;

public class posPage 
{
	@FindBy(xpath="//a[.='Motherboard']")private WebElement motherboardBtn;
	@FindBy(xpath="//div[@id='motherboard']//div[2]//form[1]//div[1]//input[1]")private WebElement motherQwabText;
	@FindBy(xpath="//div[@id='motherboard']//div[2]//form[1]//div[1]//input[4]")private WebElement motherAddBtn;
	@FindBy(xpath="//a[.='Monitor']")private WebElement monitorBtn;
	
	@FindBy(xpath="//div[@id='monitor']//input[@name='quantity']")private WebElement monitorQuantTxt;
	@FindBy(xpath="//div[@id='monitor']//input[@name='addpos']")private WebElement monitorAddBtn;
	
	
	@FindBy(xpath="//tbody/tr[2]/td[5]/a[1]/div[1]")private WebElement motherDeleteBtn;
	@FindBy(xpath="//div[@class='col-sm-12 text-primary btn-group']//select")private WebElement customerSearchDropd;
	@FindBy(xpath="//a[.='CPU']")private WebElement cpuBtn;
	@FindBy(xpath="//div[@id='cpu']//div[@class='row']//div[1]//form[1]//div[1]//input[4]")private WebElement cpuAddBtn;
	
	@FindBy(xpath="//a[@type='button']")private WebElement customerAddicon;
	@FindBy(xpath="//button[normalize-space()='SUBMIT']")private WebElement customerSubmitBtn;
	public  posPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	


	public WebElement getMotherboardBtn() 
	{
		return motherboardBtn;
	}
	public WebElement getMotherQwabText()
	{
		return motherQwabText;
	}
	public WebElement getMotherAddBtn() 
	{
		
		return motherAddBtn;
	}
	public WebElement getMonitorBtn() 
	{
		return monitorBtn;
	}
	public WebElement getMonitorQuantTxt(String qua) 
	{
		return monitorQuantTxt;
	}
	public WebElement getMonitorAddBtn()
	{
		return monitorAddBtn;
	}

	public WebElement getMotherDeleteBtn()
	{
		return motherDeleteBtn;
	}
	public WebElement getCustomerSearchDropd() 
	{
		return customerSearchDropd;
	}
	
	public WebElement getCpuBtn() 
	{
		return cpuBtn;
	}
	public WebElement getCpuAddBtn()
	{
		return cpuAddBtn;
	}
	public WebElement getCustomerAddicon() 
	{
		return customerAddicon;
	}
	public WebElement getCustomerSubmitBtn() 
	{
		return customerSubmitBtn;
	}





	public void posMajorTab(String quantity) throws IOException
	{
		cpuAddBtn.click();
		customerAddicon.click();
		motherboardBtn.click();
		motherQwabText.sendKeys(quantity);
		motherAddBtn.click();
		monitorQuantTxt.sendKeys(quantity);
		monitorBtn.click();
		
	}
	 public void custSerch() throws EncryptedDocumentException, IOException
	 {
		 WebDriverUtility wdu=new WebDriverUtility();
		 ExcelUtility eu=new ExcelUtility();
		 wdu.SelectOptionFromDropDownVISIBLETEXT(customerSearchDropd,eu.readDataFromExcel("Generate_invoice05", 0, 0)); 
	 }
	 
	 public void cSubmitbtn()
	 {
		 customerSubmitBtn.click();
	 }
}
