package by.itacademy.nataliya.ui;

import by.itacademy.nataliya.ui.pages.UsersPageRegistrationForm;
import by.itacademy.nataliya.ui.steps.Steps;
import by.itacademy.nataliya.ui.util.RandomString;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsersPageRegistrationFormTest extends BaseTest {
    UsersPageRegistrationForm page = new UsersPageRegistrationForm();

    @Test(priority = 0)
    public void testGetTextFromRegistrationFieldRegisterForm() {
        Assert.assertEquals(page.getTextFromRegistrationFieldRegisterForm(), UsersPageRegistrationForm.REGISTRATION_REGISTER_FORM);

    }

    @Test(priority = 1)
    public void testGetTextFromNameFieldRegisterForm() {
        Assert.assertEquals(page.getTextFromNameFieldRegisterForm(), UsersPageRegistrationForm.NAME_REGISTER_FORM);
    }

    @Test(priority = 2)
    public void testGetTextFromEmailFieldRegisterForm() {
        Assert.assertEquals(page.getTextFromEmailFieldRegisterForm(), UsersPageRegistrationForm.EMAIL_REGISTER_FORM);
    }

    @Test(priority = 3)
    public void testGetTextFromPasswordFieldRegisterForm() {
        Assert.assertEquals(page.getTextFromPasswordFieldRegisterForm(), UsersPageRegistrationForm.PASSWORD_REGISTER_FORM);
    }

    @Test(priority = 4)
    public void testGetTextFromRegistrationButtonRegisterForm() {
        Assert.assertEquals(page.getTextFromRegistrationButtonRegisterForm(), UsersPageRegistrationForm.DO_REGISTER_BUTTON_REGISTER_FORM);
    }

    @DataProvider(name = "testRegisterWithInvalidEmail")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"dog", "!@#/*-@gmail.com", "123"},
                {"dog", " bob.gmail.com", " 123"},
                {"dog", "     ", " 123"},
                {"dog", "собака@gmail.com", " 123"},
                {"dog", "dogHunter@gmail/com", " 123"},
                {"dog", "dogHunter$gmail.com", " 123"},
                {"dog", "dogHanter@gmailcom", " 123"},
        };
    }

    @Test(dataProvider = "testRegisterWithInvalidEmail", priority = 5)
    public void testRegisterWithInvalidData(String name, String email, String password) {
        Steps steps = new Steps();
        steps.loginWithRegistration(name, email, password);
        Assert.assertTrue(page.isNotRegisterUser());
    }

    @DataProvider(name = "testRegisterWithEmptyFields")
    public Object[][] dataProviderEmpty() {
        return new Object[][]{
                {"", "bill@gmail.com", "123"},
                {"dog", "", "123"},
                {"dog", "bill@gmail.com", ""},
                {"dog", "", ""},
                {"", "", ""},
                {"   ", "   ", ""},
                {"", "", "   "},
        };
    }

    @Test(dataProvider = "testRegisterWithEmptyFields", priority = 6)
    public void testRegisterWithEmptyField(String name, String email, String password) {
        Steps steps = new Steps();
        steps.loginWithRegistration(name, email, password);
        Assert.assertTrue(page.isNotRegisteredWithEmptyField());
    }

    @DataProvider(name = "testRegisterWithValidData")
    public Object[][] dataProv() {
        return new Object[][]{
                {RandomString.generateRandomString(), RandomString.generateRandomString() + "@gmail.com", "123"},
        };
    }

    @Test(dataProvider = "testRegisterWithValidData", priority = 7)
    public void testEnterWithValidData(String name, String email, String password) {
        Steps steps = new Steps();
        steps.loginWithRegistration(name, email, password);
        Assert.assertTrue(page.isRegisterUser());
    }
}
