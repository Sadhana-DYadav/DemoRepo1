package UgadiAssienment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class qus1 
{
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		for(int i = 1 ; i <= 9 ; i++) {
			driver.switchTo().newWindow(WindowType.WINDOW);
			if(i==6) {
				driver.get("https://www.facebook.com/signup");
			}
		}
		Set<String> allWids = driver.getWindowHandles();
		for(String wid : allWids) {
			String title = driver.switchTo().window(wid).getTitle();
			if(title.contains("Sign up for Facebook"))
				break;
		}
		driver.close();
	}
}
