package testCase1Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TopSellersPage extends BasePage {

    private final static String CHECKOS = "//*[@data-loc='SteamOS + Linux']//*[contains(@class, 'checkbox')]";
    private final static String NUMOFGAMERS =
            "//*[@id='additional_search_options']//*[contains(@data-collapse-name, 'category3')]//*[contains(@class,'block_header')]";
    private final static String COOPLAN =
            "//*[contains(@data-loc,'(LAN)')][not(contains(@data-value,'47'))]//*[contains(@class, 'checkbox')]";
    private final static String TAGFIELD = "//*[@id='TagSuggest']";
    private final static String TAGNAME = "Экшен";
    private final static String ACTION = "//*[@data-value='19']//*[contains(@class, 'checkbox')]";
    private final static String FIRSTRESULT = "//*[@id='search_resultsRows']//*[contains(@href,'')]";
    private final static String GAMETITLE = "//*[@id='search_resultsRows']//*[contains(@href,'')]//*[@class='title']";
    private final static String GAMEDATERELEASED =
            "//*[@id='search_resultsRows']//*[contains(@href,'')]//*[contains(@class,'released')]";
    private final static String GAMEPRICE =
            "//*[@id='search_resultsRows']//*[contains(@href,'')]//*[contains(@class,'search_price  responsive_secondrow')]";
    private final static String GAMESONPAGE = "//*[contains(@class, 'search_results_count')]";
    private final static String GAMECOUNT = "//*[@id='search_resultsRows']//*[@onmouseout]";

    public void selectOS() {
        WebElement elem = findByXpath(CHECKOS);
        elem.click();
        Assert.assertTrue(elem.isEnabled(), "Чекбокс SteamOS + Linux не выбран");
    }

    public void selectNumbersOfPlayers() {
        findByXpath(NUMOFGAMERS).click();
        WebElement elem = waitElement(COOPLAN);
        elem.click();
        Assert.assertTrue(elem.isEnabled(),
                "Чекбокс Кооператив (LAN) не выбран");
    }

    public void selectTag() {
        findByXpath(TAGFIELD).sendKeys(TAGNAME);
        WebElement elem = waitElement(ACTION);
        elem.click();
        Assert.assertTrue(elem.isEnabled(), "Чекбокс Экшен не выбран");
        driver.navigate().refresh();
    }

    public void gameInfo() {
        System.out.println(getGameTitle());
        System.out.println(getGameDateReleased());
        System.out.println(getGamePrice());
    }

    public void clickOnFirstResult() {
        findByXpath(FIRSTRESULT).click();
    }

    public String getGameTitle() {
        return findByXpath(GAMETITLE).getText();
    }

    public String getGameDateReleased() {
        return findByXpath(GAMEDATERELEASED).getText();
    }

    public String getGamePrice() {
        return findByXpath(GAMEPRICE).getText();
    }

    public boolean gamesNumEquals() {
        int countElement = driver.findElements(By.xpath(GAMECOUNT)).size();
        return countElement == gamesNumOnPage();
    }

    private int gamesNumOnPage() {
        String gamesNumStr = findByXpath(GAMESONPAGE).getText();
        return Integer.parseInt(gamesNumStr.replaceAll("[\\D]", ""));
    }
}
