package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePage extends BasePage {


    //Locators - Search and filter
    @FindBys(@FindBy(css = "div[id*=product_]"))
    private List<WebElement> searchResults;

    @FindBys(@FindBy(css = "#taxonomies>div:nth-child(2)>*"))
    private List<WebElement> shopByCategories;

    @FindBys(@FindBy(css = ".navigation>ul>*"))
    private List<WebElement> shopByPriceRange;

    //Iinitialization
    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void searchWithKeywords(String keywords) {
        driver.findElement(By.id("keywords")).sendKeys(keywords);
        driver.findElement(By.cssSelector("input[value='Search']")).click();
    }

    public boolean validateSearchResults(String keywords) {
        for (WebElement product : searchResults) {
            if (!product.getText().contains(keywords))
                return false;
        }
        return true;
    }

    public void clearSearch() {
        driver.findElement(By.id("keywords")).clear();
    }

    public void chooseByCategory(String category) {
        for (WebElement options : shopByCategories) {
            if (options.getText().contains(category)) {
                options.click();
                break;
            }
        }
    }

    public void chooseByPrice(String priceRange) {
        for (WebElement price : shopByPriceRange) {
            if (price.getText().contains(priceRange)) {
                price.click();
                break;
            }
        }
    }

    public void clickOnFilterSubmit(){
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();}

    public boolean validateIfProductsMatchPriceRange (double A, double B){
        for (WebElement product : searchResults) {
            double price = Double.parseDouble(product.getText().toString().split("\\$")[1]);
            if (!((price >= A)&& (price <= B))) {
                return false;
            }
        }
        return true;
    }

    public void selectProduct(String productName) {
        for (WebElement product : searchResults) {
            if (product.getText().contains(productName)) {
                product.click();
                break;
            }

        }
    }

}
