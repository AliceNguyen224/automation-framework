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

	 //@Test
	public void TC_02_01_Login_With_Empty_Data() {

		// Click to "Login" link
		homePage.clickToLoginLink();

		// Click "Login" button
		loginPage.clickToLoginButton();

		// Verify error message
		Assert.assertEquals(loginPage.getErrorMessageAtEmail(), "Please enter your email");

	}

	 //@Test
	public void TC_02_02_Login_With_Invalid_Email() {
		// Click to "Login" link
		homePage.clickToLoginLink();
		// Input invalid email
		loginPage.sendKeyToEmail("abc");
		// Click login button
		loginPage.clickToLoginButton();
		// Verify error message
		Assert.assertEquals(loginPage.getWrongEmailErrorMessage(), "Wrong email");

	}

	//@Test
	public void TC_02_03_Login_With_Unregister_Email() {
		// Click to "Login" link
		homePage.clickToLoginLink();
		// Input unregister email
		loginPage.sendKeyToEmail("abdt@gmail.com");
		loginPage.sendKeyToPassword("123456");
		// Click login button
		loginPage.clickToLoginButton();
		// Verify error message
		Assert.assertEquals(loginPage.getIncorrectCredetialsErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");

	}
	

	@Test
	public void TC_02_04_Login_With_Bland_Password() {
		//Click to "Login" link
		homePage.clickToLoginLink();
		//Click to "Register" button to navigate to register page
		loginPage.clickToRegisterButton();
		//Input 
		
		
		//Input bland password
		loginPage.sendKeyToEmail("ngannguyen2@gmail.com");
		loginPage.sendKeyToPassword("");
		//Click login button
		loginPage.clickToLoginButton();
		//Verify error message
		Assert.assertEquals(loginPage.getIncorrectCredetialsErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found");
	}
	
	@Test
	public void TC_02_05_Login_With_Incorrect_Password() {
		//Click to "Login" link
		homePage.clickToLoginLink();
		//Input incorrect Password
		loginPage.sendKeyToEmail("abc123@gmail.com");
		loginPage.sendKeyToPassword("237311");
		//CLick to "Login" button
		loginPage.clickToLoginButton();
		//Verify error message
		Assert.assertEquals(loginPage.getIncorrectCredetialsErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
		
		
	}
	
	@Test
	public void TC_02_06_Login_With_Valid_User() {
		//Click to "Login" link
		homePage.clickToLoginLink();
		//Input valid credentials
		loginPage.sendKeyToEmail("abc123@gmail.com");
		loginPage.sendKeyToPassword("123456");
		//Click to "Login" button
		loginPage.clickToLoginButton();
		//Verify login page navigate to HomePage		
		Assert.assertEquals(homePage.getCurrentURL(), "https://demo.nopcommerce.com/");
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
