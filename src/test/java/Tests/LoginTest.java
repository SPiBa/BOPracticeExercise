package Tests;

import Helpers.Driver;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Driver {

    public String emailId;
    public String password;

    @Test
    public void LoginFunctionality()  {
        emailId = "sindhu.pai@gmail.com";
        password = "test@123";

        //Click on Login Link
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        //enter emailID and Password and click login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(emailId,password);

        //Assert if the user is logged  in
        Assert.assertEquals(homePage.getLoginMessage(),"Logged in successfully");

        //Click on logout Link
        homePage.clickLogout();

        //Assert if user is logged out
        Assert.assertEquals(homePage.getLogoutMessage(),"Signed out successfully.");

    }


}
