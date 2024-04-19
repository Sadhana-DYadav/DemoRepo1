package TestNGPractice;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.comcast.FidusiaObjectRepsitory.createProductPage;
import com.comcast.FidusiaObjectRepsitory.homePage;

import com.genericUtility.Baseclass;


public class CreateProductBaseClassTestNGApply extends Baseclass 
{
	
	
	
		@Test
		public void cProduct() throws InterruptedException, EncryptedDocumentException, IOException
		{
		Thread.sleep(3000);
		wdu.acceptAlert(driver);
		Thread.sleep(3000);
		homePage hmp = new homePage(driver);
		hmp.getProductBtn().click();;
		createProductPage cPropg = new createProductPage(driver);
		cPropg.getPlusIconBtn().click();
		Thread.sleep(4000);
		
		HashMap<String, String> data = eu.readMultipleDatafromExcelFile("Create_product_Integration02", 6, 0, 0);
		System.out.println(data.get("ProductCode"));
		
		createProductPage cprodpg = new createProductPage(driver);
		Thread.sleep(3000);
		
		
		//cprodpg.createProductform(driver, data.get("ProductCode"), data.get("Name"), data.get("Description"), data.get("Quantity"), data.get("OnHand"), data.get("Price"), data.get("DateStockIn"));

		
		wdu.SelectOptionFromDropDownVISIBLETEXT(cprodpg.getCategoryDropD(), data.get("SelectCategory"));
		wdu.SelectOptionFromDropDownVISIBLETEXT(cprodpg.getSupplierTxt(), data.get("SelectSupplier"));
		
		String expdata="24111990";
		
		String verification = cprodpg.getActualData().getText();
		if(verification.equals(expdata))
		{
			System.out.println("Data is present");
		}
		Thread.sleep(2000);
		driver.close();

	}

}
