package UgadiAssienment;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.WebDriverUtility;

public class listOfTheMakeup {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wdu= new WebDriverUtility();
		wdu.maximizeWindow(driver);
		wdu.waitForPageLoad(driver, 20);
		driver.get("https://www.aveda.de");
		Thread.sleep(3000);
		//driver.switchTo().alert();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();
		wdu.scrollDownTillBottomOfPage(driver);
		
		
		
		WebElement ele=driver.findElement(By.xpath("//div[.='GERMANY']"));
		ele.click();
		driver.findElement(By.xpath("//div[.='UNITED STATES']")).click();
		
		Thread.sleep(3000);
		
		wdu.switchToWindow(driver, "Vegan Hair Products");
				Thread.sleep(9000);
		//driver.findElement(By.id("id4y")).click();
		
		
		 List <WebElement> listOfMakeup = driver.findElements(By.xpath("//div[@class='bz-background']//div[@id='imn5w']//font//font[.='SHOP NOW']"));
		 
		 for(WebElement one :listOfMakeup)
		 {
			
			 System.out.println(one.getText());
			 
		 }
		 //driver.close();
	}

}
