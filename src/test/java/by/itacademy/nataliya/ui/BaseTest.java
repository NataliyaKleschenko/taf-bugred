package by.itacademy.nataliya.ui;

import by.itacademy.nataliya.ui.driver.WebDriverSingleton;
import by.itacademy.nataliya.ui.pages.UsersPageLoginForm;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    @BeforeClass
    public void setUp() {
        UsersPageLoginForm page = new UsersPageLoginForm();
        page.openPage();
    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
