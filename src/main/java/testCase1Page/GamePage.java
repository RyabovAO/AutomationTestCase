package testCase1Page;

public class GamePage extends BasePage {

    private final static String GAMENAME = "//*[@id='appHubAppName']";
    private final static String GAMEDATE = "//*[@class='release_date']//*[contains(@class, 'date')]";
    private final static String GAMECOST = "//*[contains(@class, 'game_purchase_price price')]";

    public String getGameTitleFromGamePage() {
        return findByXpath(GAMENAME).getText();
    }

    public String getGameDateReleaseFromGamePage() {
        return findByXpath(GAMEDATE).getText();
    }

    public String getGamePriceFromGamePage() {
        return findByXpath(GAMECOST).getText();
    }
}
