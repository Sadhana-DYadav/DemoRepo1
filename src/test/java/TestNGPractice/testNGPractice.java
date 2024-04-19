package TestNGPractice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class testNGPractice
{
@Test ( priority=0, dataProviderClass = dataProviderStud.class, dataProvider = "data")


public void createTest()
{
	int []a= {1};
	System.out.println("---hii-----");
	System.out.println(a[3]);
	Assert.fail();
	}

@Test ( priority=1, dependsOnMethods = {"createTest()"})
public void Edit()
{
	System.out.println("---hii-----");
	}

@Test (invocationTimeOut = 1, priority=1)
public void Delete()
{
	System.out.println("---hii-----");
	Reporter.log("Sadhana");
	}

}
