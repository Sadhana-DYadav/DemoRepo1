package utilityClassPractice;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.comcast.FidusiaObjectRepsitory.createProductPage;
import com.comcast.FidusiaObjectRepsitory.homePage;
import com.comcast.FidusiaObjectRepsitory.productDetailPage;
import com.genericUtility.Baseclass;
public class newedit_ProductDetails_SystemTest extends Baseclass
{
	@Test
	public void editProduct() throws Throwable
	{
		
		wdu.acceptAlert(driver);
		Thread.sleep(2000);
		
		homePage hmp=new homePage(driver);
		//hmp.getProductBtn().click();
		
		hmp.getViewProductBtn().click();
		hmp.getSlidetogalBtn().click();;
		
		productDetailPage ProDePg=new productDetailPage(driver);
		ProDePg.getPriceAceBtn().click();
		ProDePg.getProductDetailElipsBtn().click();
		ProDePg.getProductEditBtn().click();
		
		String data = eu.readDataFromExcel("Create_product_Integration02", 2, 1);
		
		ProDePg.getProductDiscriptionTxt(data);
		
		createProductPage cProPg=new createProductPage(driver);
		WebElement dropd =cProPg.getCategoryDropD();
		cProPg.getCategoryDropD().click();
		wdu.SelectOptionFromDropDownVISIBLETEXT(cProPg.getCategoryDropD(), "CPU");
		ProDePg.getProductUpdateBtn().click();
		String text =driver.switchTo().alert().getText();
		if(text.equalsIgnoreCase("You've Update Product Successfully."))
		{
			System.out.println("Item is Added");
		}
		
		wdu.robotObj();
		wdu.enterKey(driver);
		wdu.enterRelease();
		Thread.sleep(4000);
		//for log out
		homePage hmPg=new homePage(driver);
		hmPg.imgLogoutUSer();
		System.out.println("User is createdS");
		
		
}
}
