package by.itacademy.nataliya.ui;

import by.itacademy.nataliya.ui.domain.User;
import by.itacademy.nataliya.ui.pages.UsersPageRegistrationForm;
import by.itacademy.nataliya.ui.steps.Steps;
import by.itacademy.nataliya.ui.util.RandomString;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsersPageRegistrationFormTest extends BaseTest {
    UsersPageRegistrationForm page;

    @Test(priority = 0)
    public void testGetTextFromRegistrationFieldRegisterForm() {
        page = new UsersPageRegistrationForm();
        Assert.assertEquals(page.getTextFromRegistrationFieldRegisterForm(), UsersPageRegistrationForm.REGISTRATION_REGISTER_FORM);
    }

    @Test(priority = 1)
    public void testGetTextFromNameFieldRegisterForm() {
        page = new UsersPageRegistrationForm();
        Assert.assertEquals(page.getTextFromNameFieldRegisterForm(), UsersPageRegistrationForm.NAME_REGISTER_FORM);
    }

    @Test(priority = 2)
    public void testGetTextFromEmailFieldRegisterForm() {
        page = new UsersPageRegistrationForm();
        Assert.assertEquals(page.getTextFromEmailFieldRegisterForm(), UsersPageRegistrationForm.EMAIL_REGISTER_FORM);
    }

    @Test(priority = 3)
    public void testGetTextFromPasswordFieldRegisterForm() {
        page = new UsersPageRegistrationForm();
        Assert.assertEquals(page.getTextFromPasswordFieldRegisterForm(), UsersPageRegistrationForm.PASSWORD_REGISTER_FORM);
    }

    @Test(priority = 4)
    public void testGetTextFromRegistrationButtonRegisterForm() {
        page = new UsersPageRegistrationForm();
        Assert.assertEquals(page.getTextFromRegistrationButtonRegisterForm(), UsersPageRegistrationForm.DO_REGISTER_BUTTON_REGISTER_FORM);
    }

    @DataProvider(name = "testRegisterWithInvalidEmail")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"dog", "!@#/*-@gmail.com", "123"},
                {"dog", " bob.gmail.com", " 123"},
                {"dog", "     ", " 123"},
                {"dog", "собака@gmail.com", "123"},
                {"dog", "dogHunter@gmail/com", " 123"},
                {"dog", "dogHunter$gmail.com", " 123"},
                {"dog", "dogHanter@gmailcom", " 123"},
        };
    }

    @Test(dataProvider = "testRegisterWithInvalidEmail", priority = 5)
    public void testRegisterWithInvalidData(String name, String email, String password) {
        page = new UsersPageRegistrationForm();
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
        page = new UsersPageRegistrationForm();
        Steps steps = new Steps();
        steps.loginWithRegistration(name, email, password);
        Assert.assertTrue(page.isNotRegisteredWithEmptyField());
    }
    @Test
    public void testRegisterField() {
        page = new UsersPageRegistrationForm();
        User user = new User(RandomString.generateRandomString(), RandomString.generateRandomString() + "@gmail.ru",RandomString.generateRandomString());
        Steps steps = new Steps();
        steps.loginWithRegistrationEmpty(user);
        Assert.assertTrue(page.isRegisterUser());
    }

    @DataProvider(name = "testRegisterWithValidData")
    public Object[][] dataProv() {
        return new Object[][]{
                {RandomString.generateRandomString(), RandomString.generateRandomString() + "@gmail.com", "123"},
        };
    }

    @Test(dataProvider = "testRegisterWithValidData", priority = 7)
    public void testEnterWithValidData(String name, String email, String password) {
        page = new UsersPageRegistrationForm();
        Steps steps = new Steps();
        steps.loginWithRegistration(name, email, password);
        Assert.assertTrue(page.isRegisterUser());
    }
}
