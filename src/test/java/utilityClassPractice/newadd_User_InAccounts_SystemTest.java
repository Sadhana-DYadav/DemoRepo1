package utilityClassPractice;
import java.util.HashMap;
import org.testng.annotations.Test;
import com.comcast.FidusiaObjectRepsitory.AddUserAccountPage;
import com.comcast.FidusiaObjectRepsitory.UserLoginpage;
import com.comcast.FidusiaObjectRepsitory.addCustomerPage;
import com.comcast.FidusiaObjectRepsitory.homePage;
import com.comcast.FidusiaObjectRepsitory.invoicePage;
import com.comcast.FidusiaObjectRepsitory.loginPage;
import com.comcast.FidusiaObjectRepsitory.posPage;
import com.genericUtility.Baseclass;
import com.genericUtility.WebDriverUtility;


public class newadd_User_InAccounts_SystemTest extends Baseclass
{
	@Test
	
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
		homePage hmPg=new homePage(driver);

		hmPg.imgLogoutUSer();
		
		
		//		Thread.sleep(3000);
//		aUserPg.getAdminlogout();
//		Thread.sleep(3000);
//		aUserPg.adminLogOut();
//		Thread.sleep(3000);
//		aUserPg.getLogOutpopUp().click();
//		Thread.sleep(3000);
		
		
		
		
		
		System.out.println("User is createdS");
//			UserLoginpage ulgPG=new UserLoginpage(driver);
//			Thread.sleep(3000);
			
			
			
//			HashMap<String, String> data = eu.readMultipleDatafromExcelFile("User_logIn", 2, 0, 0);
//		ulgPG.userLoginCre(data.get("UserName"), data.get("Password"));
//			
		
			
			
			
//			ulgPG.userLoginCre();
//		
//			wdu.acceptAlert(driver);
//			
//			
//			
//		Thread.sleep(3000);
//		
//		ulgPG.getUserLoginbtn().click();
//		//driver.get(UUrl);
//		wdu.acceptAlert(driver);
//		Thread.sleep(2000);
//		
////		driver.switchTo().alert().accept();
//		posPage posPg=new posPage(driver);
//		posPg.getCpuBtn();
//		posPg.getCpuAddBtn().click();
//		posPg.getCustomerAddicon().click();
//		
//		
//		HashMap<String, String> data1 = eu.readMultipleDatafromExcelFile("AddUser_InAccounts09", 7, 2, 0);
//		addCustomerPage AddCusPg = new addCustomerPage(driver);
//		AddCusPg.posMajorTab(data1.get("First Name"), data1.get("Last Name"), data1.get("Phone Number\r\n"
//				+ ""));
//		AddCusPg.getEmployeeSubmitBtn();
//		
//
//		driver.switchTo().alert().accept();
//		
//		
//		 posPg.getCustomerSearchDropd().click();
//		wdu.SelectOptionFromDropDownSelectByValue(posPg.getCustomerSearchDropd(), "476");
//
//		
//		posPg.getCustomerSubmitBtn().click();
//		
//		
//		invoicePage inPg=new invoicePage(driver);
//		inPg.transictionProcess("80000");
//		
//		inPg.getPaymentbtn().click();
//		
//		String text=driver.switchTo().alert().getText();
//		if(text.equalsIgnoreCase("success."))
//		{
//			System.out.println("Trangection is successfull");
//		}
//		
//		wdu.robotObj();
//		wdu.enterKey(driver);
//		wdu.enterRelease();
//		

		driver.close();
	}

}


