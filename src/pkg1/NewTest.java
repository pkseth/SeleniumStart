package pkg1;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	  
  }

@Test (priority=1)  
  public void NavigateToGmail() {
	driver.navigate().to("https://gmail.com");
	String TitleName=driver.getTitle();
	String expected;
	expected="Gmail";
	if (TitleName==expected); 
	{
		System.out.println("Successfully verified title :"+TitleName);
	}
}

@Test (priority=2)  
public void LoginToGmail() throws InterruptedException {
	WebElement UserID=driver.findElement(By.id("identifierId"));
	UserID.click();
	UserID.sendKeys("princeseth708@gmail.com");
	WebElement btnNextUsr=driver.findElement(By.id("identifierNext"));
	btnNextUsr.click();	
	Thread.sleep(6000);
	WebElement UserPwd=driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));
	UserPwd.click();
	Thread.sleep(6000);
	UserPwd.sendKeys("Enter in Run Time");
	WebElement btnNextPwd=driver.findElement(By.id("passwordNext"));
	btnNextPwd.click();	
	Thread.sleep(1000);
	String CurUrl=driver.getCurrentUrl();
	String ExpUrl;
	ExpUrl="https://mail.google.com/mail/u/0/#inbox";	
	if (CurUrl==ExpUrl); 
	{
		System.out.println("Login Successfully");
	}
}

@AfterTest
  public void BrowserExit()	{
	  driver.close();
	  driver.quit();	
}

}