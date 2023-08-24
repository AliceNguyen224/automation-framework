package nopCommerce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

public class Topic_05_Sort_Display_Paging {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);

	}

	@Test
	public void TC_01_Register_With_Empty_Data() {

		// Click to "Register" link
		homePage.clickToRegisterLink();

		// Click to "Register" button
		registerPage.clickToRegisterButton();

//		// Verify error message
		Assert.assertEquals(registerPage.getErrorMessageAtFistName(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastName(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmail(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPassword(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassword(), "Password is required.");

	}

	// @Test
	public void TC_02_() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
