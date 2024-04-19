package testNGApplyInProjectScript;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.FidusiaObjectRepsitory.AddUserAccountPage;
import com.comcast.FidusiaObjectRepsitory.createProductPage;
import com.comcast.FidusiaObjectRepsitory.createSupplierPage;
import com.comcast.FidusiaObjectRepsitory.homePage;
import com.genericUtility.Baseclass;
import com.genericUtility.ExcelUtility;
@Listeners(com.genericUtility.ListnerImplementationClass.class)
public class addProductAndSupplierAndAddUserInAccount extends Baseclass
{
	
	@Test(groups={"smoke", "regression"})
	//@Test(retryAnalyzer = com.genericUtility.RetryImpClass.class)
	//@Test(groups="smoke")
	public void cProduct() throws Throwable
	{
	
		wdu.acceptAlert(driver);
		Thread.sleep(3000);
		homePage hmp = new homePage(driver);
		hmp.getProductBtn().click();
		//Assert.fail();
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
		
		
		Assert.assertEquals(verification, expdata,"Data is varify");
//		if(verification.equals(expdata))
//		{
//			System.out.println("Data is present");
//		}
		 Thread.sleep(3000);
		//for log out
		homePage hmPg=new homePage(driver);
		hmPg.imgLogoutUSer();
		
		
	}	
		
		@Test(groups="regression")
		
		public void csupplier() throws Throwable
		{
			wdu.acceptAlert(driver);
			Thread.sleep(2000);
			homePage hmp=new homePage(driver);
			hmp.getSupplierBtn().click();
			Thread.sleep(4000);
			createSupplierPage creSupPg = new createSupplierPage(driver);
			//creSupPg.getAddSupplierBtn().click();
			Thread.sleep(3000);
			HashMap<String, String> data = eu.readMultipleDatafromExcelFile("Create_Supplier_Integration01", 4, 0, 0);
			creSupPg.createSupplierForm(driver, data.get("Campany Name"), data.get("provience"), data.get("City"), data.get("phoneNumber"));
			String expdata="Bucay";
			String verification=creSupPg.getActualData().getText();
			Assert.assertEquals(verification, expdata,"Supplier is Added");
			System.out.println("--------------------tested----------------");
//			if(verification.equals(expdata))
//			{
//				System.out.println("Data is present");
//			}
			Thread.sleep(2000);
			
			//for log out
			homePage hmPg=new homePage(driver);
			hmPg.imgLogoutUSer();
			
			driver.close();

		}
		
		
		
		@Test(groups = "smoke")
		
		public void addUserInAccount() throws Throwable
		{
			wdu.acceptAlert(driver);
			Thread.sleep(2000);
			
			homePage hmp=new homePage(driver);
			hmp.getAccountBtn().click();
			AddUserAccountPage aUserPg = new AddUserAccountPage(driver);
			aUserPg.getUserAccountAdd().click();
			Thread.sleep(3000);
			aUserPg.empDropd();
			Thread.sleep(3000);
			aUserPg.userOptions(eu.readDataFromExcel("AddUser_InAccounts09", 6, 1),eu.readDataFromExcel("AddUser_InAccounts09", 7, 1));
			Thread.sleep(3000);
			
			
			//for log out
			homePage hmPg=new homePage(driver);
			hmPg.imgLogoutUSer();
			System.out.println("User is createdS");

		
	}
}

