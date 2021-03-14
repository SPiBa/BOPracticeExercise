package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    //Locators


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateIfProductPageOpened(String product){
        String s =  driver.findElement(By.cssSelector("h1[class='product-title']")).getText();
        if (s.contains(product))
            return true;
        else
            return false;
    }
    public void updateCartItemQuantity(String quantity){
        driver.findElement(By.cssSelector("input[name='quantity']")).clear();
        driver.findElement(By.cssSelector("input[name='quantity']")).sendKeys(quantity);
    }

    public void clickAddToCart(){
        driver.findElement(By.cssSelector("button[id='add-to-cart-button']")).click();
    }

    public String getItemPrice(){
        String price = driver.findElement(By.cssSelector("span[itemprop='price']")).getText();
        return price;
    }
}
