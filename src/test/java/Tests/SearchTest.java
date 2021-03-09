package Tests;

import Helpers.Driver;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends Driver {
    public String searchKeyword;

    @Test
    public void Search (){
        HomePage homePage = new HomePage(driver);

        homePage.chooseByCategory("Bags");

        //Search with keyword Ruby and validate if results have 'Ruby' in it
        searchKeyword = "Ruby";
        homePage.searchWithKeywords(searchKeyword);
        Assert.assertEquals(homePage.validateSearchResults(searchKeyword), true);
        homePage.clearSearch();

        //Search with keyword Apache and validate if results have 'Apache' in it
        searchKeyword = "Apache";
        homePage.searchWithKeywords(searchKeyword);
        Assert.assertEquals(homePage.validateSearchResults(searchKeyword), true);
        homePage.clearSearch();




    }

    public void validateSearchResults(){

    }



}
