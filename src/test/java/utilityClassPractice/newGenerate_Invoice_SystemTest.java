package utilityClassPractice;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.comcast.FidusiaObjectRepsitory.homePage;
import com.comcast.FidusiaObjectRepsitory.invoicePage;
import com.comcast.FidusiaObjectRepsitory.posPage;
import com.genericUtility.Baseclass;


public class newGenerate_Invoice_SystemTest extends Baseclass
{
	@Test
	public void invoice() throws Throwable 
	{
		
		wdu.acceptAlert(driver);
		Thread.sleep(2000);
		homePage hmp=new homePage(driver);
		hmp.getpOSBtn().click();
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
		
		
		popg.cSubmitbtn();
		
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
		
		if(text.contains("Inventory "))
		{
			System.out.println("Trangection is successfull");
		}
		else
		{
			System.out.println("Trangection is not successfull");
		}
		}
		//for log out
				homePage hmPg=new homePage(driver);
				hmPg.imgLogoutUSer();
		
		// driver.close();

		

	}

}
