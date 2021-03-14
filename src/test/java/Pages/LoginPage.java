package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    //Locators
    @FindBy(id = "link-to-login")
    private WebElement loginLink;
    @FindBy(partialLinkText = "Logout")
    private WebElement logoutLink;
    @FindBy(id = "spree_user_email")
    private WebElement emailId;
    @FindBy(id = "spree_user_password")
    private WebElement password;
    @FindBy(css = "input[name ='commit']")
    private WebElement loginBtn;

    @FindBy(css = "div[class='alert alert-success']")
    private WebElement loginMessageBar;
    @FindBy(css = "div[class='alert alert-notice']")
    private WebElement noticeMessageBar;

    //Initialization
    public LoginPage (WebDriver driver) {
       super(driver);
    }

    public void login(String email, String pswd) {
        //waitFor("spree_user_email");
        emailId.sendKeys(email);
        password.sendKeys(pswd);
        loginBtn.click();
    }

    //Method to click login button
    public void clickLogin() {
        loginLink.click();
    }

    //Method to click logout button
    public void clickLogout() {
        logoutLink.click();
    }

    public String getLoginMessage() {
        return loginMessageBar.getText();
    }

    public String getLogoutMessage() {
        return noticeMessageBar.getText();
    }


}
