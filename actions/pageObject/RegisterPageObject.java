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
		return getTextElement(driver, RegisterPageLocator.ERROR_MESSAGE_FIRST_NAME);
	}

	public String getErrorMessageAtLastName() {
		return getTextElement(driver, RegisterPageLocator.ERROR_MESSAGE_LAST_NAME);
	}

	public String getErrorMessageAtEmail() {
		return getTextElement(driver, RegisterPageLocator.ERROR_MESSAGE_EMAIL);
	}

	public String getErrorMessageAtPassword() {
		return getTextElement(driver, RegisterPageLocator.ERROR_MESSAGE_PASSWORD);
	}

	public String getErrorMessageAtConfirmPassword() {
		return getTextElement(driver, RegisterPageLocator.ERROR_MESSAGE_CONFIRM_PASSWORD);
	}

}
