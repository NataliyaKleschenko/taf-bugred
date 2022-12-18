package by.itacademy.nataliya.ui;

import by.itacademy.nataliya.ui.driver.WebDriverSingleton;
import by.itacademy.nataliya.ui.pages.UsersPageLoginForm;
import org.testng.annotations.*;


public class BaseTest {
    @BeforeMethod
    public void setUp() {
        UsersPageLoginForm page = new UsersPageLoginForm();
        page.openPage();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
