package TestNGPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationPractice 
{
	@BeforeSuite
	public void s1()
	{
		System.out.println("Before Suits");
	}
	
	
	@AfterSuite
	public void s2()
	{
		System.out.println("After Suits");
	}
	
	@BeforeClass
	public void c1()
	{
		System.out.println("before class");
	}
	
	
	@AfterClass
	public void c2()
	{
		System.out.println("After Class");
	}
	
	
	@BeforeMethod
	public void m1()
	{
		System.out.println("before method");
	}
	
	
	@AfterMethod
	public void m2()
	{
		System.out.println("After method");
	}
	
	@Test
	public void mainScript()
	{
		System.out.println("MainScript");
	}
	
	@Test
	public void MainScript1()
	{
		System.out.println("MainScript2");
	}
}
