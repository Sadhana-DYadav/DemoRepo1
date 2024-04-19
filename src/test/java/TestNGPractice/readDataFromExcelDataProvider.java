package TestNGPractice;

import org.testng.annotations.Test;

public class readDataFromExcelDataProvider 
{
	@Test(dataProviderClass =genericDataProvider.class, dataProvider = "Data" )
	public void readdata(String col, String data)
	{
		System.out.println(col+"----------"+data);
	}
}
