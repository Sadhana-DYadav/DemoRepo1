package User_Module_RMG;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class add_User_InAccounts_SystemTest 
{
	public static WebDriver driver;
	public static void main(String[] args) throws EncryptedDocumentException, IOException, AWTException, InterruptedException 
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
		
		driver.findElement(By.xpath("//span[.='Accounts']")).click();
		driver.findElement(By.xpath("//a[@data-toggle='modal']//i[@class='fas fa-fw fa-plus']")).click();
		
		
		WebElement dropd = driver.findElement(By.xpath("//select[@name='empid']"));
		dropd.click();
		Select sel=new Select(dropd);
		sel.selectByValue("82");
		
		FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\FIDUSIAProjectSheet.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		driver.findElement(By.xpath("//div[@class='form-group']//input[@placeholder='Username']")).sendKeys(wb.getSheet("AddUser_InAccounts09").getRow(1).getCell(6).getStringCellValue());
		driver.findElement(By.xpath("//div[@class='form-group']//input[@placeholder='Password']")).sendKeys(wb.getSheet("AddUser_InAccounts09").getRow(1).getCell(7).getStringCellValue());
		driver.findElement(By.xpath("//div[@class='modal fade show']/div/div//button[@type='submit']")).click();	
		
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		driver.findElement(By.xpath("//a[@data-target='#logoutModal']")).click();
		driver.findElement(By.xpath("//div[@class='modal-footer']//a[.='Logout']")).click();
		
		
		String URL_USER=pobj.getProperty("url-user");
		String USERNAME_USER=pobj.getProperty("username-user");
		String PASSWORD_USER=pobj.getProperty("password-user");
		driver.findElement(By.xpath("//input[@name='user']")).sendKeys(USERNAME_USER);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD_USER);
		driver.findElement(By.xpath("//button[.='Login']")).click();
		//driver.get(URL_USER);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//a[.='CPU']")).click();
		driver.findElement(By.xpath("//div[@id='cpu']//div[@class='row']//div[1]//form[1]//div[1]//input[4]")).click();
		driver.findElement(By.xpath("//a[@type='button']")).click();
		
		driver.findElement(By.xpath("//div[@class='modal fade show']//div/div[@class='modal-body']//input[@name='firstname']")).sendKeys(wb.getSheet("AddUser_InAccounts09").getRow(1).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//div[@class='modal fade show']//div/div[@class='modal-body']//input[@name='lastname']")).sendKeys(wb.getSheet("AddUser_InAccounts09").getRow(1).getCell(2).getStringCellValue());
		driver.findElement(By.xpath("//div[@class='modal fade show']//div/div[@class='modal-body']//input[@name='phonenumber']")).sendKeys(wb.getSheet("AddUser_InAccounts09").getRow(1).getCell(3).getStringCellValue());
		driver.findElement(By.xpath("//div[@class='modal fade show']//div/div[@class='modal-body']//button[@type='submit']")).click();
		driver.switchTo().alert().accept();
		
		WebElement dropd1=driver.findElement(By.xpath("//select[@name='customer']"));
		dropd1.click();
		Select sel1=new Select(dropd1);
		sel1.selectByValue("476");
		
		driver.findElement(By.xpath("//button[normalize-space()='SUBMIT']")).click();
		
		driver.findElement(By.id("txtNumber")).sendKeys("10000");
		driver.findElement(By.xpath("//button[.='PROCEED TO PAYMENT']")).click();
		String text=driver.switchTo().alert().getText();
		if(text.equalsIgnoreCase("success."))
		{
			System.out.println("Trangection is successfull");
		}
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.close();
	}
	
	
	}


