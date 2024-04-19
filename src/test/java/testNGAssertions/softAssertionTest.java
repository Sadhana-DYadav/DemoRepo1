package testNGAssertions;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class softAssertionTest 
{
	@Test
	public void stringValueCompair() 
	{
		SoftAssert sa=new SoftAssert();
		//System.out.println("----Line1----");
		
		int a=5;
		int b=5;
		//sa.assertNotSame("A","B","Both are not same");
		//sa.assertSame("A", "B","Both are same");
		//System.out.println("----Line3----");
		//sa.assertEquals("Asa", "Sas","Both are equal");
		sa.assertNotNull(a);
		sa.assertNull(a);
		sa.assertTrue(a>b, "this is true");
		System.out.println("----Line2----");
		//sa.assertAll();
		
		
				
	}

	

}
