package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCheckOutButton (){
        driver.findElement(By.cssSelector("button[id='checkout-link']")).click();
    }

    public void clickOnEmptyCartButton(){
        driver.findElement(By.cssSelector("input[name='commit']")).click();
    }

    public String getCartAlertMessage(){
        waitFor("content");
        return driver.findElement(By.cssSelector("div[class='alert alert-info']")).getText();
    }

    public String getTotalPrice (){
        return driver.findElement(By.cssSelector("[class='lead']")).getText();
    }
}
