package Admin_modul_RMG;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class edit_ProductDetails_SystemTest 
{
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, AWTException 
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
		
		driver.findElement(By.xpath("//a[.='View All Products']")).click();
		driver.findElement(By.id("sidebarToggle")).click();
		driver.findElement(By.xpath("//th[@aria-label='Price: activate to sort column ascending']")).click();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/div[1]/div[1]/a[1]")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu text-center show']//a[@type='button'][normalize-space()='Edit']")).click();
		FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\FIDUSIAProjectSheet.xlsx");
		Workbook wb= WorkbookFactory.create(fs);
		driver.findElement(By.xpath("//textarea[@placeholder='Description']")).sendKeys(wb.getSheet("Edit_Product_Details06").getRow(1).getCell(2).getStringCellValue());
		
		WebElement dropd = driver.findElement(By.xpath("//select[@name='category']"));//createproductpage
		dropd.click();
		Select sel=new Select(dropd);
		sel.selectByVisibleText("CPU");
		driver.findElement(By.xpath("//button[.='Update']")).click();
		
		String text =driver.switchTo().alert().getText();
		if(text.equalsIgnoreCase("You've Update Product Successfully."))
		{
			System.out.println("Item is Added");
		}
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.close();
	}
	
	}
	
	


