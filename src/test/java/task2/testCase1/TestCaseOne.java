package task2.testCase1;

import driver_manager.WebDriverCreate;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testCase1Page.AboutPage;
import testCase1Page.BasePage;
import testCase1Page.MainPageSteam;

public class TestCaseOne {

    @BeforeTest
    public void startTest() {
        BasePage bp = new BasePage();
        bp.openSteamPage();
        bp.setLanguage();
    }

    @Test
    public void TestOne() {
        MainPageSteam mps = new MainPageSteam();
        AboutPage ap = new AboutPage();

        mps.goToHomePage();
        Assert.assertEquals(WebDriverCreate.getDriver().getTitle(), "Welcome to Steam",
                "Главная страница открыта");

        mps.clickOnAboutButton();
        Assert.assertEquals(WebDriverCreate.getDriver().getTitle(), "Steam, The Ultimate Online Game Platform",
                "Страница About открыта");

        ap.compareGamers();
        Assert.assertTrue(ap.compareGamers(), "Число игроков в игре не меньше, чем онлаин");

        ap.clickOnStoreButton();
        Assert.assertEquals(WebDriverCreate.getDriver().getTitle(), "Welcome to Steam",
                "Страница магазина открыта");
    }

    @AfterTest
    public void endTest() {
        WebDriverCreate.closeDriver();
    }
}
