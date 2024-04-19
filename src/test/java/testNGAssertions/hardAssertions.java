package testNGAssertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class hardAssertions 
{
	@Test
	public void hardAssertSoft() 
	{
		
		String expectedTitle="Sales and Inventory";
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		String ActulTitle=driver.getTitle();
//		Assert.assertEquals(ActulTitle, expectedTitle);
		Assert.assertNotEquals(ActulTitle, expectedTitle);
//		Assert.assertSame(ActulTitle, expectedTitle,"This is not same");
//		Assert.assertNotSame(ActulTitle, expectedTitle,"This is not same");
		//int a=9;
//		int b=5;
//		
//		Assert.assertFalse(a<b, "Assert Method Checking");
//		Assert.assertTrue(a<b, "Assert Method Checking");
		
//		Assert.assertNull(a, "Assert Method Checking");
		
		
//		Assert.assertNotNull(a, "Assert Method Checking");
		
		System.out.println(ActulTitle);
		
	}

}
