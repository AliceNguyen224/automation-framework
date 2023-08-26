package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetElementText;

import common.BasePage;
import nopCommerce_Locator.RegisterPageLocator;

public class RegisterPageObject extends BasePage {
	WebDriver driver;
	
	public RegisterPageObject(WebDriver mappingDriver) {
		this.driver = mappingDriver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageLocator.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageLocator.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFistName() {
		waitForElementVisible(driver, RegisterPageLocator.ERROR_MESSAGE_FIRST_NAME);
		return getTextElement(driver, RegisterPageLocator.ERROR_MESSAGE_FIRST_NAME);
	}

	public String getErrorMessageAtLastName() {
		waitForElementVisible(driver, RegisterPageLocator.ERROR_MESSAGE_LAST_NAME);
		return getTextElement(driver, RegisterPageLocator.ERROR_MESSAGE_LAST_NAME);
	}

	public String getErrorMessageAtEmail() {
		waitForElementVisible(driver, RegisterPageLocator.ERROR_MESSAGE_EMAIL);
		return getTextElement(driver, RegisterPageLocator.ERROR_MESSAGE_EMAIL);
	}

	public String getErrorMessageAtPassword() {
		waitForElementVisible(driver, RegisterPageLocator.ERROR_MESSAGE_PASSWORD);
		return getTextElement(driver, RegisterPageLocator.ERROR_MESSAGE_PASSWORD);
	}

	public String getErrorMessageAtConfirmPassword() {
		waitForElementVisible(driver, RegisterPageLocator.ERROR_MESSAGE_CONFIRM_PASSWORD);
		return getTextElement(driver, RegisterPageLocator.ERROR_MESSAGE_CONFIRM_PASSWORD);
	}

	public void sendKeyToEmail(String value) {
	waitForElementVisible(driver, RegisterPageLocator.EMAIl);
	sendKeyToElement(driver, RegisterPageLocator.EMAIl, value);
		
	}

	public void sendKeyToFirstName(String value) {
	waitForElementVisible(driver, RegisterPageLocator.FIRSTNAME);
	sendKeyToElement(driver, RegisterPageLocator.FIRSTNAME, value);
		
	}

	public void sendKeyToLastName(String value) {
		waitForElementVisible(driver, RegisterPageLocator.LASTNAME);
		sendKeyToElement(driver, RegisterPageLocator.LASTNAME, value);
	}

	public void sendKeyToPassword(String value) {
		waitForElementVisible(driver, RegisterPageLocator.PASSWORD);
		sendKeyToElement(driver, RegisterPageLocator.PASSWORD, value);
		
	}

	public void sendKeyToConfirmPassword(String value) {
		waitForElementVisible(driver, RegisterPageLocator.CONFIRMPASSWORD);
		sendKeyToElement(driver, RegisterPageLocator.CONFIRMPASSWORD, value);
		
	}

	public String getSuccessMessage() {
		waitForElementVisible(driver, RegisterPageLocator.SUCCESS_MESSAGE);
		return getTextElement(driver, RegisterPageLocator.SUCCESS_MESSAGE);
		
	}

	public String getErrorExistedEmailMessage() {
		waitForElementVisible(driver, RegisterPageLocator.ERROR_EXISTED_EMAIL);
		return getTextElement(driver, RegisterPageLocator.ERROR_EXISTED_EMAIL);
	}

}
