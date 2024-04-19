package Admin_modul_RMG;
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

import com.comcast.FidusiaObjectRepsitory.homePage;
import com.comcast.FidusiaObjectRepsitory.loginPage;
import com.genericUtility.ExcelUtility;
import com.genericUtility.FileUtility;
import com.genericUtility.WebDriverUtility;

public class create_Supplier_Integration01 
{
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException 
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
	
		
		driver.findElement(By.xpath("//span[.='Supplier']")).click();
		driver.findElement(By.xpath("//div[@class='card-header py-3']//a")).click();
		
		FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\FIDUSIAProjectSheet.xlsx");
		Workbook wb= WorkbookFactory.create(fs);
		
		driver.findElement(By.xpath("//input[@placeholder='Company Name']")).sendKeys(wb.getSheet("Create_Supplier_Integration01").getRow(1).getCell(0).getStringCellValue());
		driver.findElement(By.id("province")).sendKeys(wb.getSheet("Create_Supplier_Integration01").getRow(1).getCell(1).getStringCellValue());
		
		 WebElement city=driver.findElement(By.id("city"));
		Select sel=new Select(city);
		sel.selectByVisibleText("Bucay");
		driver.findElement(By.xpath("//option[contains(.,'Select City')]/parent::select[@id='city']/parent::div/following-sibling::div/input[@name='phonenumber']")).sendKeys(wb.getSheet("Create_Supplier_Integration01").getRow(1).getCell(3).getStringCellValue());
		driver.findElement(By.xpath("//option[contains(.,'Select City')]/parent::select[@id='city']/ancestor::div[@class='modal-body']//descendant::button[@class='btn btn-success']")).click();
		
		
				
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Bucay");
		String expdata="Bucay";
		String verification = driver.findElement(By.xpath("//tr[@class='odd']//td[.='Bucay']")).getText();
		
		if(verification.equals(expdata))
		{
			System.out.println("Data is present");
		}
		Thread.sleep(2000);
		driver.close();
	}

}
