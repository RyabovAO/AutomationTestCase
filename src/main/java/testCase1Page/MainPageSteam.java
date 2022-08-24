package testCase1Page;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageSteam extends BasePage {

    private final static String ABOUTBUTTON =
            "//*[@class='supernav_container']//*[contains(@href, 'store.steampowered.com/about')]";
    private final static String HOMEPAGE =
            "//*[@class='submenu_store']//*[@href='https://store.steampowered.com/?snr=1_4_4__global-responsive-menu']";
    private final static String NEWANDNOTEWORTHY = "//*[@id='noteworthy_tab']//*[contains(@class, 'desktop')]";
    private final static String TOPSELLERS = "//*[@id='noteworthy_flyout']//*[contains(@href,'topsellers')]";


    public void clickOnAboutButton() {
        findByXpath(ABOUTBUTTON).click();
    }

    public void goToHomePage() {
        findByXpath(HOMEPAGE);
    }

    public void goToTopSellers() {
        new Actions(driver).moveToElement(findByXpath(NEWANDNOTEWORTHY)).perform();
        waitElement(TOPSELLERS).click();
    }
}
