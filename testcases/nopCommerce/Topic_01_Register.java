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

public class Topic_01_Register {
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
	public void TC_01_01_Register_With_Empty_Data() {

		// Click to "Register" link
		homePage.clickToRegisterLink();

		// Click to "Register" button
		registerPage.clickToRegisterButton();
		

		// Verify error message
		Assert.assertEquals(registerPage.getErrorMessageAtFistName(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastName(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmail(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPassword(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassword(), "Password is required.");

	}

	 @Test
	public void TC_01_02_Register_With_Invalid_Email() {
		// Click to 'Register" link
		homePage.clickToRegisterLink();
		// Click to "Register" button
		registerPage.clickToRegisterButton();
		// Input invalid email
		registerPage.sendKeyToEmail("abc");
		// Click to "Register" button
		registerPage.clickToRegisterButton();
		// Verify error message
		Assert.assertEquals(registerPage.getErrorMessageAtEmail(), "Wrong email");

	}

	 @Test
	public void TC_01_03_Register_With_Valid_Email() {
		// Click to "Register" Login
		homePage.clickToRegisterLink();
		// Input all required information
		registerPage.sendKeyToFirstName("Ngan");
		registerPage.sendKeyToLastName("Nguyen");
		registerPage.sendKeyToEmail("ngannguyen5@gmail.com");
		registerPage.sendKeyToPassword("123456");
		registerPage.sendKeyToConfirmPassword("123456");
		// Click to "Register" button
		registerPage.clickToRegisterButton();

		// Verify success message
		Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

	}

	 @Test
	public void TC_01_04_Register_With_Existing_Email() {
		// Click to "Register" link
		homePage.clickToRegisterLink();
		// Input all required fields
		registerPage.sendKeyToFirstName("Nga");
		registerPage.sendKeyToLastName("Pham");
		registerPage.sendKeyToEmail("ngannguyen5@gmail.com");
		registerPage.sendKeyToPassword("12csaa");
		registerPage.sendKeyToConfirmPassword("12csaa");
		// Click to "Register" button
		registerPage.clickToRegisterButton();
		// Verify error message
		Assert.assertEquals(registerPage.getErrorExistedEmailMessage(), "The specified email already exists");

	}

	@Test
	public void TC_01_05_Register_With_Password_Lessthan6Characters() {
		// Click to "Register" link
		homePage.clickToRegisterLink();
		// Input invalid password value
		registerPage.sendKeyToPassword("abc");
		// Click to "Register" button
		registerPage.clickToRegisterButton();
		// Verify error message
		Assert.assertEquals(registerPage.getErrorMessageAtPassword().replace("\n", " "),
				"Password must meet the following rules: must have at least 6 characters");

	}

	 @Test
	public void TC_01_06_Register_With_Incorrect_ConfirmPassword() {
		// Click to "Register" link
		homePage.clickToRegisterLink();
		// Input invalid confirm password
		registerPage.sendKeyToFirstName("Nga");
		registerPage.sendKeyToLastName("Pham");
		registerPage.sendKeyToEmail("ngannguyen1@gmail.com");
		registerPage.sendKeyToEmail("123456");
		registerPage.sendKeyToConfirmPassword("123097");
		// Click to "Register" button
		registerPage.clickToRegisterButton();
		// Verify error message
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassword(),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
