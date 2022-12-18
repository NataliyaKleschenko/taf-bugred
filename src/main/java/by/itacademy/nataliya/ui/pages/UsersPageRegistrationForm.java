package by.itacademy.nataliya.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UsersPageRegistrationForm extends BasePage {
    private final By TEXT_FROM_REGISTRATION_FIELD_REGISTER_FORM_LOCATOR = By.xpath("//div[2]/h2");
    private final By TEXT_FROM_NAME_REGISTER_FORM_LOCATOR = By.xpath("//div[2]/form/table/tbody/tr[1]/td[1]");
    private final By TEXT_FROM_EMAIL_REGISTER_FORM_LOCATOR = By.xpath("//div[2]/form/table/tbody/tr[2]/td[1]");
    private final By TEXT_FROM_PASSWORD_REGISTER_FORM_LOCATOR = By.xpath("//div[2]/form/table/tbody/tr[3]/td[1]");
    private final By REGISTRATION_BUTTON_REGISTER_FORM_LOCATOR = By.xpath("//div[2]/form/table/tbody/tr[4]/td[2]/input");
    private final By LOGIN_INPUT_NAME_LOCATOR = By.xpath("//div[2]/form/table/tbody/tr[1]/td[2]/input");
    private final By LOGIN_INPUT_EMAIL_LOCATOR = By.xpath("//div[2]/form/table/tbody/tr[2]/td[2]/input");
    private final By LOGIN_INPUT_PASSWORD_LOCATOR = By.xpath("//div[2]/form/table/tbody/tr[3]/td[2]/input");
    private final By USER_NAME_LOCATOR = By.xpath("//a[@class='dropdown-toggle']");
    private final By ERROR_EMAIL_MESSAGE_LOCATOR = By.xpath("//div[3]/div[1]/div[2]/form/p");
    public static final String REGISTRATION_REGISTER_FORM = "Регистрация";
    public static final String NAME_REGISTER_FORM = "Имя";
    public static final String EMAIL_REGISTER_FORM = "Email";
    public static final String PASSWORD_REGISTER_FORM = "Пароль";
    public static final String DO_REGISTER_BUTTON_REGISTER_FORM = "Зарегистрироваться";
    private static final String ERROR_EMAIL_MESSAGE = "Неправильное значение поля (email)";
    private static final String ERROR_NAME_MESSAGE = "Занят (name)";

    public UsersPageRegistrationForm() {
        super();
    }

    public String getTextFromRegistrationFieldRegisterForm() {
        return getTextFromWebElement(TEXT_FROM_REGISTRATION_FIELD_REGISTER_FORM_LOCATOR);
    }

    public String getTextFromNameFieldRegisterForm() {
        return getTextFromWebElement(TEXT_FROM_NAME_REGISTER_FORM_LOCATOR);
    }

    public String getTextFromEmailFieldRegisterForm() {
        return getTextFromWebElement(TEXT_FROM_EMAIL_REGISTER_FORM_LOCATOR);
    }

    public String getTextFromPasswordFieldRegisterForm() {
        return getTextFromWebElement(TEXT_FROM_PASSWORD_REGISTER_FORM_LOCATOR);
    }

    public String getTextFromRegistrationButtonRegisterForm() {
        return driver.findElement(REGISTRATION_BUTTON_REGISTER_FORM_LOCATOR).getAccessibleName();
    }

    public String getTextFromUserNameLocator() {
        return driver.findElement(USER_NAME_LOCATOR).getText();
    }

    public String getTextFromErrorMessageLocator() {
        return driver.findElement(ERROR_EMAIL_MESSAGE_LOCATOR).getText();
    }

    public void typeInputName(String input) {
        sendTextToForm(LOGIN_INPUT_NAME_LOCATOR, input);
    }

    public void typeInputEmail(String input) {
        sendTextToForm(LOGIN_INPUT_EMAIL_LOCATOR, input);
    }

    public void typeInputPassword(String input) {
        sendTextToForm(LOGIN_INPUT_PASSWORD_LOCATOR, input);
    }

    public void clickOnLoginButton() {
        clickOnElement(REGISTRATION_BUTTON_REGISTER_FORM_LOCATOR);
    }

        public boolean isRegisterUser() {
            WebElement element = driver.findElement(USER_NAME_LOCATOR);
            return element.isDisplayed();
        }
    public boolean isNotRegisterUser() {
        String notRegister = getTextFromErrorMessageLocator();
        return notRegister.equals(ERROR_EMAIL_MESSAGE) || notRegister.equals(ERROR_NAME_MESSAGE);
    }
    public boolean isNotRegisteredWithEmptyField() {
        WebElement element = driver.findElement(REGISTRATION_BUTTON_REGISTER_FORM_LOCATOR);
        return element.isDisplayed();
    }
}
