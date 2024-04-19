package testNGApplyInProjectScript;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.FidusiaObjectRepsitory.createProductPage;
import com.comcast.FidusiaObjectRepsitory.homePage;
import com.comcast.FidusiaObjectRepsitory.invoicePage;
import com.comcast.FidusiaObjectRepsitory.posPage;
import com.comcast.FidusiaObjectRepsitory.productDetailPage;
import com.genericUtility.Baseclass;

public class invoiceEditProduct extends Baseclass
{
	//@Test(retryAnalyzer = com.genericUtility.RetryImpClass.class)
	@Test(groups="regression")
	public void invoice() throws Throwable 
	{
		
		wdu.acceptAlert(driver);
		Thread.sleep(2000);
		homePage hmp=new homePage(driver);
		hmp.getpOSBtn().click();
		Thread.sleep(3000);
		//Assert.fail();
		posPage pospg = new  posPage(driver);
		pospg.getMotherboardBtn().click();
		Thread.sleep(3000);
		HashMap<String, String> data = eu.readMultipleDatafromExcelFile("Generate_invoice05", 5, 0, 0);
		posPage popg=new posPage(driver);
		//System.out.println(eu.readDataFromExcel("Generate_invoice05", 2, 1));
		popg.getMonitorQuantTxt(eu.readDataFromExcel("Generate_invoice05", 2, 1));
		popg.getMotherAddBtn().click();
		Thread.sleep(2000);
		popg.getMonitorBtn().click();
		popg.getMonitorQuantTxt(eu.readDataFromExcel("Generate_invoice05", 2, 1));
		popg.getMonitorAddBtn().click();
		popg.getMotherDeleteBtn().click();
		Thread.sleep(3000);
		WebElement dropd=popg.getCustomerSearchDropd();
		//dropd.click();
		Thread.sleep(3000);
		
		
		wdu.SelectOptionFromDropDownVISIBLETEXT(dropd,eu.readDataFromExcel("Generate_invoice05", 0, 1));
		Thread.sleep(3000);
		
		popg.cSubmitbtn();
		Thread.sleep(3000);
		
		invoicePage invoPg=new invoicePage(driver);
		invoPg.transictionProcess(eu.readDataFromExcel("Generate_invoice05", 5, 1));
		Thread.sleep(2000);
		invoPg.paybtn();
		System.out.println("User Is Added");
		Thread.sleep(3000);
		
		
		wdu.robotObj();
		wdu.enterKey(driver);
		wdu.enterRelease();
		Set<String> wid = driver.getWindowHandles();
		
		for(String srt:wid)
		{
			driver.switchTo().window(srt);
			String text=driver.getTitle();
			
			System.out.println(text);
			
			
		String expdata="Sales and Inventory System";
		
		Assert.assertEquals(text, expdata,"Trangection is successfull");
		
//		if(text.contains("Inventory "))
//		{
//			System.out.println("Trangection is successfull");
//		}
//		else
//		{
//			System.out.println("Trangection is not successfull");
//		}
		}
		
		Thread.sleep(7000);
		
		
		//for log out
		//homePage hmPg=new homePage(null);
		hmp.imgLogoutUSer();
	}
	
	
	@Test(groups="smoke")
	public void editProduct() throws Throwable
	{
		
		wdu.acceptAlert(driver);
		Thread.sleep(2000);
		
		homePage hmp=new homePage(driver);
		//hmp.getProductBtn().click();
		
		hmp.getViewProductBtn().click();
		hmp.getSlidetogalBtn().click();;
		
		productDetailPage ProDePg=new productDetailPage(driver);
		ProDePg.getPriceAceBtn().click();
		ProDePg.getProductDetailElipsBtn().click();
		ProDePg.getProductEditBtn().click();
		
		String data = eu.readDataFromExcel("Create_product_Integration02", 2, 1);
		
		ProDePg.getProductDiscriptionTxt(data);
		
		createProductPage cProPg=new createProductPage(driver);
		WebElement dropd =cProPg.getCategoryDropD();
		cProPg.getCategoryDropD().click();
		wdu.SelectOptionFromDropDownVISIBLETEXT(cProPg.getCategoryDropD(), "CPU");
		ProDePg.getProductUpdateBtn().click();
		String text =driver.switchTo().alert().getText();
		String expdata="You've Update Product Successfully.";
		Assert.assertEquals(text, expdata,"Item is Added");
		
//		if(text.equalsIgnoreCase("Item is Added"))
//		{
//			System.out.println("Item is Added");
//		}
//		
		wdu.robotObj();
		wdu.enterKey(driver);
		wdu.enterRelease();
		Thread.sleep(5000);
		
		//for log out
		//homePage hmPg=new homePage(null);
		hmp.imgLogoutUSer();


		//this is sended by the GitHub
		
	}
		
}
