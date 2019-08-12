package pkg1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	
@BeforeTest
  public void LunchBrowser() {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shivam Soni\\Documents\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	  
  }

@Test  
  public void PerformTest() {
	System.out.println("Hello World");
}

@AfterTest
  public void BrowserExit()	{
	  driver.close();
	  driver.quit();	
}

}