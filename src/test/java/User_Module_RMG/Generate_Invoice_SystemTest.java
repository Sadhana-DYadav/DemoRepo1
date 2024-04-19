package User_Module_RMG;
import java.awt.AWTException;
import java.awt.Robot;
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

public class Generate_Invoice_SystemTest 
{
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, AWTException, InterruptedException
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
		
		FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\FIDUSIAProjectSheet.xlsx");
		Workbook wb= WorkbookFactory.create(fs);
		
		driver.findElement(By.xpath("//div[@id='motherboard']//div[2]//form[1]//div[1]//input[1]")).sendKeys(wb.getSheet("Generate_invoice05").getRow(1).getCell(2).getStringCellValue());
		driver.findElement(By.xpath("//div[@id='motherboard']//div[2]//form[1]//div[1]//input[4]")).click();
		
		
		driver.findElement(By.xpath("//a[.='Monitor']")).click();
		driver.findElement(By.xpath("//div[@id='monitor']//input[@name='quantity']")).sendKeys(wb.getSheet("Generate_invoice05").getRow(1).getCell(4).getStringCellValue());
		driver.findElement(By.xpath("//div[@id='monitor']//input[@name='addpos']")).click();
		driver.findElement(By.xpath("//tbody/tr[2]/td[5]/a[1]/div[1]")).click();
		
		WebElement dropd=driver.findElement(By.xpath("//div[@class='col-sm-12 text-primary btn-group']//select"));
		Select sel=new Select(dropd);
		sel.selectByVisibleText("meena leena");
		
		driver.findElement(By.xpath("//button[.='SUBMIT']")).click();
		
		driver.findElement(By.id("txtNumber")).sendKeys(wb.getSheet("Generate_invoice05").getRow(1).getCell(5).getStringCellValue());
		driver.findElement(By.xpath("//button[.='PROCEED TO PAYMENT']")).click();
		String text=driver.switchTo().alert().getText();
		if(text.equalsIgnoreCase("success."))
		{
			System.out.println("Trangection is successfull");
		}
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver.close();
	}

}
