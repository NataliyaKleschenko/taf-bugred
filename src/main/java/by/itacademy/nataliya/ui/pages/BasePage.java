package by.itacademy.nataliya.ui.pages;

import by.itacademy.nataliya.ui.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final long WAIT_FOR_ELEMENT = 4;
    protected WebDriver driver;
    protected Actions builder;
    private static final String URL = "http://users.bugred.ru/";

    public BasePage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public void openPage() {
        driver.navigate().to(URL + "user/login/index.html");
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    protected void sendTextToForm(By locator, String input) {
        builder = new Actions(driver);
        WebElement element = driver.findElement(locator);
        element.clear();
        builder.sendKeys(element, input).perform();
    }

    protected String getTextFromWebElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}
