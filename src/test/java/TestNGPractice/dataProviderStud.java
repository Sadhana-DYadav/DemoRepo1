package TestNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderStud 

{

	@Test(dataProvider = "data")
	public void getdata(String org, String loc, String course)
	{
		System.out.println(" organization"+org+"location"+loc+"course"+course);
	}
	@DataProvider
	public Object[]data() 
	{
		Object[][] obj=new Object[3][3];
		obj[0][0]="Qspider";
		obj[0][1]="bang";
		obj[0][2]="Java";
		
		obj[1][0]="Prospider";
		obj[1][1]="Hydra";
		obj[1][2]="c";
		
		obj[2][0]="Pyspider";
		obj[2][1]="mysor";
		obj[2][2]="c++";
		return obj;

	}

}
