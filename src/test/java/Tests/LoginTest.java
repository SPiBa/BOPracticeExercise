package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {


    @DataProvider(name = "login")
    public static Object[][] LoginLogout() {
        return new Object[][]{{"sindhu.pai@gmail.com", "test@123"}};
    }

    @Test(dataProvider = "login")
    public void loginUsingValidCredentialsAndLogout(String emailId, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        loginPage.login(emailId, password);
        Assert.assertEquals(loginPage.getLoginMessage(), "Logged in successfully");
        loginPage.clickLogout();
        Assert.assertEquals(loginPage.getLogoutMessage(), "Signed out successfully.");
    }

}