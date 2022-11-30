package by.itacademy.nataliya.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UsersPageLoginForm extends BasePage {
    private final By TEXT_FROM_ENTER_BUTTON_LOGIN_FORM_LOCATOR = By.xpath("//h2[1]");
    private final By TEXT_FROM_HEADER_LOGIN_FORM_LOCATOR = By.xpath("//html/body/div[3]/div[1]/div[1]/p");
    private final By TEXT_FROM_EMAIL_LOGIN_FORM_LOCATOR = By.xpath("//table/tbody/tr[1]/td[1]");
    private final By TEXT_FROM_PASSWORD_LOGIN_FORM_LOCATOR = By.xpath("//table/tbody/tr[2]/td[1]");
    private final By LOGIN_INPUT_EMAIL_LOCATOR = By.xpath("//input[@name='login']");
    private final By LOGIN_INPUT_PASSWORD_LOCATOR = By.xpath("//div[1]/form/table/tbody/tr[2]/td[2]/input");
    private final By LOGIN_BUTTON_LOCATOR = By.xpath("//h2[contains(text(),'Вход')]/ancestor::div[@class = 'col-md-6']//input[@value='Авторизоваться']");
    private final By USER_NAME_LOCATOR = By.xpath("//a[@class='dropdown-toggle']");
    public static final String ENTER_LOGIN_FORM = "Вход";
    public static final String HEADER_LOGIN_FORM = "С помощью формы ниже,вы сможете авторизоваться на нашем ресурсе";
    public static final String EMAIL_LOGIN_FORM = "Email";
    public static final String PASSWORD_LOGIN_FORM = "Пароль";
    public static final String LOGIN_BUTTON_LOGIN_FORM = "Авторизоваться";

    public UsersPageLoginForm() {
        super();
    }

    public String getTextFromEnterButtonLoginForm() {
        return getTextFromWebElement(TEXT_FROM_ENTER_BUTTON_LOGIN_FORM_LOCATOR);
    }

    public String getTextFromHeaderLoginForm() {
        return getTextFromWebElement(TEXT_FROM_HEADER_LOGIN_FORM_LOCATOR);
    }

    public String getTextFromEmailLoginForm() {
        return getTextFromWebElement(TEXT_FROM_EMAIL_LOGIN_FORM_LOCATOR);
    }

    public String getTextFromPasswordLoginForm() {
        return getTextFromWebElement(TEXT_FROM_PASSWORD_LOGIN_FORM_LOCATOR);
    }

    public String getTextFromLoginButtonLoginForm() {
        return driver.findElement(LOGIN_BUTTON_LOCATOR).getAccessibleName();
    }

    public String getTextFromUserNameLocator() {
        return getTextFromWebElement(USER_NAME_LOCATOR);
    }

    public void typeInputEmail(String input) {
        sendTextToForm(LOGIN_INPUT_EMAIL_LOCATOR, input);
    }

    public void typeInputPassword(String input) {
        sendTextToForm(LOGIN_INPUT_PASSWORD_LOCATOR, input);
    }

    public void clickOnLoginButton() {
        clickOnElement(LOGIN_BUTTON_LOCATOR);
    }

    public boolean isUserFound() {
        String textFromUserNameLocator = getTextFromUserNameLocator();
        return textFromUserNameLocator.equals("bob");
    }

    public boolean isUserNotFound() {
        WebElement element = driver.findElement(LOGIN_BUTTON_LOCATOR);
        return element.isDisplayed();
    }
}
