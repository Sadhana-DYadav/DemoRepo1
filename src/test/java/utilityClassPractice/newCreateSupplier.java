package utilityClassPractice;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.comcast.FidusiaObjectRepsitory.createSupplierPage;
import com.comcast.FidusiaObjectRepsitory.homePage;
import com.genericUtility.Baseclass;


public class newCreateSupplier extends Baseclass 
{
	@Test
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
		if(verification.equals(expdata))
		{
			System.out.println("Data is present");
		}
		Thread.sleep(2000);
		
		//for log out
				homePage hmPg=new homePage(driver);
				hmPg.imgLogoutUSer();
				
		driver.close();

	}

}
