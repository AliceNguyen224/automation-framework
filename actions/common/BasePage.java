package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected String getCurentUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	protected void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	protected String getCurrentUrl(WebDriver driver, String url) {
		return url;
	}

	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	protected void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver).accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver).dismiss();
	}

	protected String getTextAlert(WebDriver driver) {
		return waitAlertPresence(driver).getText();
	}

	protected void sendKeyToAlert(WebDriver driver, String value) {
		waitAlertPresence(driver).sendKeys(value);
	}

	protected void switchWindowByID(WebDriver driver, String ParentID) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String i : allWindow) {
			if (!i.equals(ParentID)) {
				driver.switchTo().window(i);
				break;
			}

		}
	}

	protected void switchWindowByTitle(WebDriver driver, String Title) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String W : allWindow) {
			driver.switchTo().window(W);
			String currentTitle = driver.getTitle();
			if (currentTitle.equals(Title)) {
				break;

			}
		}
	}

	protected void closeAllWindowsWithoutParent(WebDriver driver, String ParentID) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String j : allWindow) {

			if (!j.equals(ParentID)) {
				driver.switchTo().window(j);
				driver.close();
			}

		}
		driver.switchTo().window(ParentID);
	}

	protected WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	protected List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	protected By getByXpath(String locator) {
		return By.xpath(locator);
	}

	protected void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	protected void sendKeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).sendKeys(value);
	}

	protected String getAttributeValue(WebDriver driver, String locator, String value) {
		return getElement(driver, locator).getAttribute(value);
	}

	protected String getTextElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}

	protected String getCssValue(WebDriver driver, String locator, String value) {
		return getElement(driver, locator).getAttribute(value);
	}

	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	protected int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	protected void checkTheCheckBoxOrRadio(WebDriver driver, String locator) {
		if (!getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}

	}

	protected void uncheckTheCheckBox(WebDriver driver, String locator) {
		if (getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isDisplayed();
	}

	protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isSelected();
	}

	protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isEnabled();
	}

	protected void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	protected void hoverMouseToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	protected void rightClick(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	protected void dragAndDrop(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getElement(driver, locator), getElement(driver, locator)).perform();
	}

	protected void pressKeyboard(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	protected void sendKeyToElementByAction(WebDriver driver, String locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), value).perform();
	}

	protected void uploadFile(WebDriver driver, String locator, String...fileNames) {
		String projectPath = System.getProperty("user.dir");
		String filePath = projectPath + "\\uploadFiles\\";
		String fullFilePath = filePath + "\\" +fileNames;
		for (String file:fileNames) {
			fullFilePath = fullFilePath + filePath +file + "n";
		}
		sendKeyToElement(driver, locator, fullFilePath);
	}
	
	protected void switchtoFrameIFrame(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getElement(driver, xpathLocator));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	protected void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	protected void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}

	protected void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String itemText) {
		Select select = new Select(getElement(driver, xpathLocator));
		select.selectByVisibleText(itemText);
	}

	protected String getSelectedItemInDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();

	}

	protected boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver, xpathLocator));
		return select.isMultiple();
	}

	protected void selectItemInCustomDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver, xpathLocator));

	}

}
