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
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class Topic_02_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);

	}

	// @Test
	public void TC_01_Login_With_Empty_Data() {

		// Click to "Login" link
		homePage.clickToLoginLink();

		// Click "Login" button
		loginPage.clickToLoginButton();

		// Verify error message
		Assert.assertEquals(loginPage.getErrorMessageAtEmail(), "Please enter your email");

	}

	// @Test
	public void TC_02_Login_With_Invalid_Email() {
		// Click to "Login" link
		homePage.clickToLoginLink();
		// Input invalid email
		loginPage.sendKeyToEmail("abc");
		// Click login button
		loginPage.clickToLoginButton();
		// Verify error message
		Assert.assertEquals(loginPage.getWrongEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void TC_03_Login_With_Unregister_Email() {
		// Click to "Login" link
		homePage.clickToLoginLink();
		// Input unregister email
		loginPage.sendKeyToEmail("abdt@gmail.com");
		loginPage.sendKeyToPassword("123456");
		// Click login button
		loginPage.clickToLoginButton();
		// Verify error message
		Assert.assertEquals(loginPage.getUnregisterEmailErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
