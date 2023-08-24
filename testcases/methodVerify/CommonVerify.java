package methodVerify;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;

public class CommonVerify extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	//@Test
	public void TC_01_getCurrentUrl() {
		driver.get("http://live.techpanda.org/");
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		CommonVerify url = new CommonVerify();
	
		System.out.println("The login Page URL is: " + url);
		Assert.assertEquals(url, "http://live.techpanda.org/index.php/customer/account/login/");
	}

	@Test
	public void TC_02_() {
		driver.getPageSource();
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}


