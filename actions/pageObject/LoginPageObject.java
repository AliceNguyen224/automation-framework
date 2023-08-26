package pageObject;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import nopCommerce_Locator.LoginPageLocator;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver mappingDriver) {
		this.driver = mappingDriver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver,LoginPageLocator.LOGIN_BUTTON );
		clickToElement(driver, LoginPageLocator.LOGIN_BUTTON);
	}

	public String getErrorMessageAtEmail() {
		waitForElementVisible(driver,LoginPageLocator.ERROR_MESSAGE_AT_EMAIL);
		
		return getTextElement(driver, LoginPageLocator.ERROR_MESSAGE_AT_EMAIL);
	}

	public void sendKeyToEmail(String value) {
		waitForElementVisible(driver, LoginPageLocator.EMAIL);
		sendKeyToElement(driver, LoginPageLocator.EMAIL,value);
	}

	public String getWrongEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageLocator.ERROR_MESSAGE_AT_EMAIL);
		return getTextElement(driver, LoginPageLocator.ERROR_MESSAGE_AT_EMAIL);
	}

	public void sendKeyToPassword(String value) {
		waitForElementVisible(driver, LoginPageLocator.PASSWORD);
		sendKeyToElement(driver, LoginPageLocator.PASSWORD, value);
	}

	public String getIncorrectCredetialsErrorMessage() {
		waitForElementVisible(driver, LoginPageLocator.INCORRECT_CREDETIALS);
		return getTextElement(driver, LoginPageLocator.INCORRECT_CREDETIALS);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, LoginPageLocator.REGISTER_BUTTON);
		clickToElement(driver, LoginPageLocator.REGISTER_BUTTON);
	}



	

}
