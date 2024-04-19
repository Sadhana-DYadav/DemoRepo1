package UgadiAssienment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.WebDriverUtility;

public class launchTwoAppInDiffTab 
{

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wdu= new WebDriverUtility();
		wdu.maximizeWindow(driver);
		wdu.waitForPageLoad(driver, 20);
		driver.get("https://www.google.de");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com");

	}

}
