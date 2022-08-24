package task2.testCase2;

import driver_manager.WebDriverCreate;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testCase1Page.BasePage;
import testCase1Page.GamePage;
import testCase1Page.MainPageSteam;
import testCase1Page.TopSellersPage;

public class TestCase2 {

    @BeforeTest
    public void startTest() {
        new BasePage().openSteamPage();
    }

    @Test
    public void testTwo() {
        MainPageSteam mps = new MainPageSteam();
        TopSellersPage tsp = new TopSellersPage();
        GamePage gp = new GamePage();

        mps.goToHomePage();
        Assert.assertEquals(WebDriverCreate.getDriver().getTitle(), "Добро пожаловать в Steam",
                "Главная страница открыта");

        mps.goToTopSellers();
        Assert.assertEquals(WebDriverCreate.getDriver().getTitle(), "Поиск Steam",
                "Открыта страница с продуктами-лидерами продаж");

        tsp.selectOS();

        tsp.selectNumbersOfPlayers();

        tsp.selectTag();

        tsp.gamesNumEquals();
        Assert.assertTrue(tsp.gamesNumEquals(),
                "Указанное количество результатов по запросу не соответствует количеству игр в списке");

        tsp.gameInfo();

        String name = tsp.getGameTitle();
        String date = tsp.getGameDateReleased();
        String price = tsp.getGamePrice();

        tsp.clickOnFirstResult();


        String nameGame = gp.getGameTitleFromGamePage();
        Assert.assertEquals(name, nameGame, "Названия игр одинаковы");

        String gameDateRelease = gp.getGameDateReleaseFromGamePage();
        Assert.assertEquals(date, gameDateRelease, "Даты выхода игр одинаковы");
        String gamePrice = gp.getGamePriceFromGamePage();
        Assert.assertEquals(price, gamePrice, "Цена игр одинакова");
    }

    @AfterTest
    public void endTest() {
        WebDriverCreate.closeDriver();
    }
}
