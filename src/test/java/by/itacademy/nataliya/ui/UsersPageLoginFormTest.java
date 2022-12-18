package by.itacademy.nataliya.ui;

import by.itacademy.nataliya.ui.pages.UsersPageLoginForm;
import by.itacademy.nataliya.ui.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsersPageLoginFormTest extends BaseTest {
    UsersPageLoginForm page;

    @Test(priority = 0)
    public void testGetTextFromHeaderLoginForm() {
        page = new UsersPageLoginForm();
        Assert.assertEquals(page.getTextFromHeaderLoginForm(), UsersPageLoginForm.HEADER_LOGIN_FORM);
    }

    @Test(priority = 1)
    public void testGetTextFromEnterButtonLoginForm() {
        page = new UsersPageLoginForm();
        Assert.assertEquals(page.getTextFromEnterButtonLoginForm(), UsersPageLoginForm.ENTER_LOGIN_FORM);
    }

    @Test(priority = 2)
    public void testGetTextFromEmailLoginForm() {
        page = new UsersPageLoginForm();
        Assert.assertEquals(page.getTextFromEmailLoginForm(), UsersPageLoginForm.EMAIL_LOGIN_FORM);
    }

    @Test(priority = 3)
    public void testGetTextFromPasswordLoginForm() {
        page = new UsersPageLoginForm();
        Assert.assertEquals(page.getTextFromPasswordLoginForm(), UsersPageLoginForm.PASSWORD_LOGIN_FORM);
    }

    @Test(priority = 4)
    public void testGetTextFromLoginButtonLoginForm() {
        page = new UsersPageLoginForm();
        Assert.assertEquals(page.getTextFromLoginButtonLoginForm(), UsersPageLoginForm.LOGIN_BUTTON_LOGIN_FORM);
    }

    @DataProvider(name = "testLoginWithInvalidData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"", ""},
                {" ", " "},
                {"!@#/*-", "123"},
                {"bob.gmail.com", " 123"},
                {" bob.gmail.com ", " 123 "},
                {" bob.gmail.com", "-123"},
        };
    }

    @Test(dataProvider = "testLoginWithInvalidData", priority = 5)
    public void testEnterWithInvalidData(String email, String password) {
        page = new UsersPageLoginForm();
        Steps steps = new Steps();
        steps.loginWithAuthorization(email, password);
        Assert.assertTrue(page.isUserNotFound());
    }

    @DataProvider(name = "testLoginWithValidData")
    public Object[][] dataProv() {
        return new Object[][]{
                {"jenkins@gmail.com", "123"},
        };
    }

    @Test(dataProvider = "testLoginWithValidData", priority = 6)
    public void testEnterWithValidData(String email, String password) {
        page = new UsersPageLoginForm();
        Steps steps = new Steps();
        steps.loginWithAuthorization(email, password);
        Assert.assertTrue(page.isUserFound());
    }
}
