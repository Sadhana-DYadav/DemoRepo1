package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// copied from the Internet should practice over it

public class validateTheProject 
{
	@Test(dataProvider = "login-data")
	public void dataProviderpractice(String user, String password, String exp)
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.gnail.com");
	
	driver.findElement(By.id("email")).sendKeys("asd@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.id("btn")).click();
	
	

	String exp_title="hgfdsdfghjkhgfd";
	String act_title="hgfdsfghjkhgfds";
	
	if(exp.equals("Valid"))
	{
		if(exp_title.equals(act_title))
		{
			driver.findElement(By.id("logout")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	else if(exp.equals("Invalid"))
	{
		if(exp_title.equals(act_title))
		{
			driver.findElement(By.id("logout")).click();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	
	}
	
}
	@DataProvider(name="login-data")
	public String [][] getData()
	{
		String loginData[][]= 
		{
				{"admin1@gmail.com","admin","Valid"},
				{"admin45@gmail.com","admn","Invalid"},
				{"admin3@gmail.com","amin","Invalid"},
				{"admi4@gmail.com","amin","Invalid"}
		};
		return loginData;
	}

}