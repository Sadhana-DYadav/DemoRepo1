package TestNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class assignment 
{
	@Test(dataProviderClass = dataProviderStud.class, dataProvider ="data" )
	public void StudentData(String Sub, String Sch, String shh)
	{
		System.out.println("Subject"+"School"+"location");
	}
	
	@Test
	@DataProvider 
	public Object[][] SubjectData()
	{
	Object[][] k=new Object[2][2];
	k[0][0]="Subject";
	k[0][1]="Math";
	return k;
	}
	
	@DataProvider
	public Object[][] SchoolData()
	{
	Object[][] k1=new Object[2][2];
	k1[1][0]="School";
	k1[1][1]="Adarsh";
	return k1;
	}
	
	@Test
	@DataProvider
	public Object[][]StandardData()
	{
	Object[][] k2=new Object[2][2];
	k2[2][0]="Standard";
	k2[2][1]="metrix";
	return k2;
	}
	
	
}
