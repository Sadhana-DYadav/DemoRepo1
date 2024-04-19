package UgadiAssienment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.event.ListDataEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.WebDriverUtility;

public class closeTheSeventhWindow 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wdu= new WebDriverUtility();
		wdu.maximizeWindow(driver);
		wdu.waitForPageLoad(driver, 20);
		driver.get("https://www.aveda.de");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.facebook.com");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.instagram.com");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.amazon.in");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.lekme.com");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.youtube.com");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.alibaba.com");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.online.citibank.co.in");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://best.aliexpress.com");
		Set<String> wh = driver.getWindowHandles();
		 
		
		
		ArrayList<String> al=new ArrayList<String>();
		al.addAll(wh);
		
		
		 if(al.equals(al.get(7)))
		 {
			driver.close(); 
		 }
		
		

		
		

	}

}
