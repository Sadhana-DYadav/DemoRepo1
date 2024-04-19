package Admin_modul_RMG;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class create_Product_Integration02_test 
{
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException, AWTException 
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
		driver.findElement(By.xpath("//span[.='Product']")).click();
		driver.findElement(By.xpath("//div[@class='card-header py-3']//a")).click();
		
		FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\FIDUSIAProjectSheet.xlsx");
		Workbook wb= WorkbookFactory.create(fs);
		
		driver.findElement(By.xpath("//input[@placeholder='Product Code']")).sendKeys(wb.getSheet("Create_product_Integration02").getRow(1).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(wb.getSheet("Create_product_Integration02").getRow(1).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//textarea[@placeholder='Description']")).sendKeys(wb.getSheet("Create_product_Integration02").getRow(1).getCell(2).getStringCellValue());
		driver.findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys(wb.getSheet("Create_product_Integration02").getRow(1).getCell(3).getStringCellValue());
		driver.findElement(By.xpath("//input[@placeholder='On Hand']")).sendKeys(wb.getSheet("Create_product_Integration02").getRow(1).getCell(4).getStringCellValue());
		driver.findElement(By.xpath("//input[@placeholder='Price']")).sendKeys(wb.getSheet("Create_product_Integration02").getRow(1).getCell(5).getStringCellValue());
		
		
		WebElement category = driver.findElement(By.xpath("//select[@name='category']"));
		Select sel=new Select(category);
		sel.selectByVisibleText(wb.getSheet("Create_product_Integration02").getRow(1).getCell(6).getStringCellValue());
		
		driver.findElement(By.xpath("//select[@name='supplier']")).sendKeys(wb.getSheet("Create_product_Integration02").getRow(1).getCell(7).getStringCellValue());
		driver.findElement(By.xpath("//input[@placeholder='Date Stock In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Date Stock In']")).sendKeys(wb.getSheet("Create_product_Integration02").getRow(1).getCell(8).getStringCellValue());
		
		
		
		driver.findElement(By.xpath("//input[@type='date']/ancestor::div[@class='modal-body']/descendant::button[.='Save']")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("24111990");
		String expdata="24111990";
		String verification = driver.findElement(By.xpath("//tr[@class='odd']//td[.='24111990']")).getText();
		
		if(verification.equals(expdata))
		{
			System.out.println("Data is present");
		}
		Thread.sleep(2000);
		driver.close();
	}
	}


