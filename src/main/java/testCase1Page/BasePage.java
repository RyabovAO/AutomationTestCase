package testCase1Page;

import driver_manager.WebDriverCreate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private final static String URL = "URL";
    private final static String LANGUAGEBUTTON = "//*[@class='pulldown global_action_link']";
    private final static String ENGLISHBUTTON = "//*[@href='?l=english']";

    protected XmlHandler xmlHandler = new XmlHandler();

    protected WebDriver driver;

    public BasePage() {
        this.driver = WebDriverCreate.getDriver();
    }

    public WebElement findByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void openSteamPage() {
        driver.get(xmlHandler.getValueFromXml(URL));
    }

    public void setLanguage() {
        findByXpath(LANGUAGEBUTTON).click();
        findByXpath(ENGLISHBUTTON).click();
        driver.navigate().refresh();
    }

    public WebElement waitElement(String elem) {
        return new WebDriverWait(this.driver, 5).
                until(ExpectedConditions.elementToBeClickable(findByXpath(elem)));
    }
}
