package lesson_10.task4;

import lesson_10.utils.DriverUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {

    private static final String PAGE = "http://www.automationpractice.pl/index.php";
    private static final String DRESS_1 = "Printed chiffon dress";
    private static final String DRESS_2 = "Faded Short";

    @Test
    public void compareTest() {
        DriverUtil.getDriver().get(PAGE);
        MainPage mainPage = new MainPage();
        mainPage.searchInput(DRESS_1);
        mainPage.clickOnSearchBtn();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.isPageOpen());
        searchResultsPage.clickOnListBtn();
        searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickOnAddToCompareBtn();
        searchResultsPage.waitNewNumber(1);
        mainPage = new MainPage();
        mainPage.clickOnWomenBtn();
        mainPage = new MainPage();
        mainPage.searchInput(DRESS_2);
        mainPage.clickOnSearchBtn();
        searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.isPageOpen());
        searchResultsPage.clickOnAddToCompareBtn();
        searchResultsPage.waitNewNumber(2);
        searchResultsPage.clickOnCompareBtn();
        ComparisonPage comparisonPage = new ComparisonPage();
        Assert.assertTrue(comparisonPage.isPageOpen());
    }
}
