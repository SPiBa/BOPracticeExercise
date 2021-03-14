package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchAndFilterTest extends BaseTest {


    @DataProvider (name = "Search")
    public static Object[][] SearchData() {
        return new Object[][] {{"Ruby"}, {"Apache"}};
    }


    @Test (dataProvider = "Search")
    public void SearchUsingKeywords (String keyWord){
        HomePage homePage = new HomePage(driver);

        homePage.searchWithKeywords(keyWord);
        Assert.assertEquals(homePage.validateSearchResults(keyWord), true);
        homePage.clearSearch();
    }

    @DataProvider (name = "Filter")
    public static Object[][] ShopBy() {
        return new Object[][] {{"Bags","$15.00 - $18.00",15.0,18.0}};
    }

    @Test (dataProvider = "Filter")
    public void FilterProductsByCategoryAndPrice( String category, String priceRange, double A, double B) {
        HomePage homePage = new HomePage(driver);
        homePage.chooseByCategory(category);
        homePage.chooseByPrice(priceRange);
        homePage.clickOnFilterSubmit();
        Assert.assertTrue(homePage.validateIfProductsMatchPriceRange(A,B));
    }

}
