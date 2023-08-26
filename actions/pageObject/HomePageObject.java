package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.BasePage;
import nopCommerce_Locator.HomePageLocator;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver mappingDriver) {
		this.driver = mappingDriver;
	}

	public void clickToRegisterLink() {
		// waitForElementClickable()
		clickToElement(driver, HomePageLocator.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		clickToElement(driver, HomePageLocator.LOGIN_LINK);
	}

	public String getCurrentURL() {
		return getCurentUrl(driver);

	}

}
