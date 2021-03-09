package Pages;

import Helpers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    //Locators
    @FindBy(id = "spree_user_email")
            private WebElement emailId;
    @FindBy(id = "spree_user_password")
        private WebElement password;
    @FindBy(css = "input[name ='commit']")
        private WebElement loginBtn;

    //Initialization
    public LoginPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    public void login(String email, String pswd) {
        //wait.until(ExpectedConditions.presenceOfElementLocated((By) emailId));
        emailId.sendKeys(email);
        password.sendKeys(pswd);
        loginBtn.click();
    }



}
