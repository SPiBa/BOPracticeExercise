package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{

    @DataProvider(name = "login")
    public static Object[][] LoginLogout() {
        return new Object[][]{{"sindhu.pai@gmail.com", "test@123", "Ruby on Rails Mug"}};
    }

    @Test(dataProvider = "login")
    public void addProductToCart (String emailId,String password, String keyword){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        loginPage.login(emailId, password);
        Assert.assertEquals(loginPage.getLoginMessage(), "Logged in successfully");

        HomePage homePage = new HomePage(driver);
        homePage.searchWithKeywords(keyword);
        homePage.selectProduct(keyword);

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.validateIfProductPageOpened(keyword));
        String itemPrice = productPage.getItemPrice();
        System.out.println(itemPrice);
        productPage.clickAddToCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        String totalItemCost = shoppingCartPage.getTotalPrice();
        Assert.assertEquals(totalItemCost,itemPrice);
    }

}
