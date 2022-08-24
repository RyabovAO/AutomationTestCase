package testCase1Page;

public class AboutPage extends BasePage {

    private final static String STOREBUTTON = "//*[@class='supernav_container']//*[@class='menuitem supernav' and not(contains(@style,'display'))]";
    private final static String GAMERSINGAME = "//*[contains(@class,'gamers_in_game')]//following-sibling::text()//..";
    private final static String GAMERSONLINE = "//*[contains(@class,'gamers_online')]//following-sibling::text()//..";

    private int parseToNum() {
        String gamersOnline = findByXpath(GAMERSONLINE).getText();
        String gamersInGame = findByXpath(GAMERSINGAME).getText();
        int gamersOnLineNum = Integer.parseInt(gamersOnline.replaceAll("[\\D]", ""));
        int gamersOnGameNum = Integer.parseInt(gamersInGame.replaceAll("[\\D]", ""));
        return gamersOnLineNum > gamersOnGameNum ? 1 : 0;
    }

    public boolean compareGamers() {
        return parseToNum() == 1;
    }

    public void clickOnStoreButton() {
        findByXpath(STOREBUTTON).click();
    }
}

