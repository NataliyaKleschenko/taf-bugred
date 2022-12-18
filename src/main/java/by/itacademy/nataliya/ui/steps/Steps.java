package by.itacademy.nataliya.ui.steps;

import by.itacademy.nataliya.ui.pages.UsersPageLoginForm;
import by.itacademy.nataliya.ui.pages.UsersPageRegistrationForm;

public class Steps {
    public void loginWithAuthorization(String email, String password) {
        UsersPageLoginForm pageLogin = new UsersPageLoginForm();
        pageLogin.typeInputEmail(email);
        pageLogin.typeInputPassword(password);
        pageLogin.clickOnLoginButton();
    }
    public void loginWithRegistration(String name, String email, String password) {
        UsersPageRegistrationForm usersPageRegistration = new UsersPageRegistrationForm();
        usersPageRegistration.typeInputName(name);
        usersPageRegistration.typeInputEmail(email);
        usersPageRegistration.typeInputPassword(password);
        usersPageRegistration.clickOnLoginButton();
    }
}
