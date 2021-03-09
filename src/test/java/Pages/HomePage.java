package Pages;

import Helpers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver driver;

    //Locators
    @FindBy(id ="link-to-login")
        private WebElement loginLink;
    @FindBy(partialLinkText = "Logout")
        private WebElement logoutLink;
    @FindBy(id = "keywords")
        private WebElement searchText;
    @FindBy(css = "input[value='Search']")
        private WebElement searchBtn;
    @FindBy(css = "div[class='alert alert-success']")
        private WebElement loginMessageBar;
    @FindBy(css = "div[class='alert alert-notice']")
        private WebElement noticeMessageBar;
    @FindBy(css = "div[data-hook='search_results']")
        private WebElement searchResultsPage;

    @FindBys(@FindBy(xpath = "//div[@id='products']/following-sibling::div[1]") )
        private List<WebElement> searchResults;

    @FindBys(@FindBy(className = "//h4[Shop by Categories]/following-sibling::div[1]/a") )
        private List<WebElement> shopByCategories;

    //Iinitialization
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Method to click login button
    public void clickLogin() {
        loginLink.click();
    }

    //Method to click logout button
    public void clickLogout() {
        logoutLink.click();
    }

    public String getLoginMessage(){
        return loginMessageBar.getText();
    }

    public String getLogoutMessage(){
        return noticeMessageBar.getText();
    }

    public void searchWithKeywords(String keywords){
        searchText.sendKeys(keywords);
        searchBtn.click();
    }

    public boolean validateSearchResults(String keywords){
        for (WebElement product:searchResults){
            if(!product.getText().contains(keywords))
                return false;
        }
        return true;
    }

    public void clearSearch (){
        searchText.clear();
    }

    public void chooseByCategory(String category){
        for ( WebElement cat: shopByCategories) {
            if (cat.getText().contains(category)) {
                cat.click();
            }
        }
    }


}
