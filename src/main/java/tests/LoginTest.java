package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utils.ExtentManager;
import utils.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyValidLogin() {
        setup();
        ExtentManager.createTest("Verify Valid Login");

        LoginPage loginPage = new LoginPage(driver);
        ExtentManager.logInfo("Entering valid credentials");

        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
        loginPage.clickSubmit();

        boolean result = loginPage.isLoginSuccessful();
        Assert.assertTrue(result, "Login should be successful!");

        ExtentManager.logPass("Login successful and Logged In page displayed");
        tearDown();
    }

    @Test(priority = 2)
    public void verifyInvalidLogin() {
        setup();
        ExtentManager.createTest("Verify Invalid Login");

        LoginPage loginPage = new LoginPage(driver);
        ExtentManager.logInfo("Entering invalid credentials");

        loginPage.enterUsername("wronguser");
        loginPage.enterPassword("wrongpass");
        loginPage.clickSubmit();

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Your username is invalid!", "Error message mismatch");

        ExtentManager.logPass("Proper error message displayed for invalid login");
        tearDown();
    }
}
