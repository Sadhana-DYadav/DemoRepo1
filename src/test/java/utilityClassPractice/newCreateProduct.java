package utilityClassPractice;
import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.comcast.FidusiaObjectRepsitory.createProductPage;
import com.comcast.FidusiaObjectRepsitory.homePage;

import com.genericUtility.Baseclass;
import com.genericUtility.ExcelUtility;


public class newCreateProduct extends Baseclass
{
	@Test
	public void cProduct() throws Throwable
	{
	
		wdu.acceptAlert(driver);
		Thread.sleep(3000);
		homePage hmp = new homePage(driver);
		hmp.getProductBtn().click();;
		createProductPage cPropg = new createProductPage(driver);
		cPropg.plusiconbtn();
		Thread.sleep(4000);
		
		HashMap<String, String> data = eu.readMultipleDatafromExcelFile("Create_product_Integration02", 9, 0, 0);
		createProductPage cprodpg = new createProductPage(driver);
		
		cprodpg.createProductform( driver,data.get("ProductCode"), data.get("Name"), data.get("Description"), data.get("Quantity"), data.get("OnHand"), data.get("Price"));
				

		
		wdu.SelectOptionFromDropDownVISIBLETEXT(cprodpg.getCategoryDropD(), data.get("SelectCategory"));
		wdu.SelectOptionFromDropDownVISIBLETEXT(cprodpg.getSupplierTxt(), data.get("SelectSupplier"));
		
		ExcelUtility eu=new ExcelUtility();
		 
		cprodpg.dateStockTxt(eu.readDataFromExcel("Create_product_Integration02", 8, 1));
		cprodpg.searcht();
		
		String expdata="24111990";
		String verification = cprodpg.actuData();
//		
		if(verification.equals(expdata))
		{
			System.out.println("Data is present");
		}
		System.out.println("User is createdS");
		//for log out
		homePage hmPg=new homePage(driver);
		hmPg.imgLogoutUSer();
		
		
	}
		
	}


