package TestNGPractice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import com.comcast.FidusiaObjectRepsitory.loginPage;
import com.genericUtility.FileUtility;



public class loginApp 
{
	@Test(dataProviderClass = lohinDataProvider.class, dataProvider="data1")
	public void login(String USER,String PASS) throws IOException 
	{

		WebDriver driver=new ChromeDriver();
		driver.get(" http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		loginPage lpg=new loginPage(driver);
		lpg.loginToApplication(USER,PASS);
		

	}

}
