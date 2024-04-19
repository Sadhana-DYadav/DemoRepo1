package Admin_modul_RMG;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class editProduct_Quantity_Inventory_systemTest 
{
	public static WebDriver driver;
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/AdminCommanData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
	
			String BROWSER=pobj.getProperty("browser");
			String URL=pobj.getProperty("url");
			String USERNAME=pobj.getProperty("username");
			String PASSWORD=pobj.getProperty("password");
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='Login']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//span[.='POS']")).click();
		driver.findElement(By.xpath("//a[.='Motherboard']")).click();
		driver.close();

	}

}
