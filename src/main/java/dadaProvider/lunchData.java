package dadaProvider;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.FidusiaObjectRepsitory.loginPage;

import com.genericUtility.FileUtility;
import com.google.common.annotations.VisibleForTesting;



public class lunchData
{
	
	public void getData(String username, String pwd) throws IOException
	{
		FileUtility fu=new FileUtility();
		String USERNAME=fu.readDataFromPropertyFile("username");
		String PASSWORD=fu.readDataFromPropertyFile("password");
	WebDriver driver=new ChromeDriver();
	driver.get(" http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	
	
	loginPage lpg=new loginPage(driver);
	lpg.loginToApplication(USERNAME,PASSWORD);
	}
}
