package NodeJS_APP.pages;

import NodeJS_APP.libs.WebElementOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import static NodeJS_APP.libs.ConfigData.getCfgValue;

/**
 * Created by roman on 3/31/17.
 */
public class MainPage {
    WebDriver driver;
    Logger log;
    WebElementOnPage webElementOnPage;
    String MAIN_PAGE_URL;
    String MAIN_PAGE_TITLE;

    /**
     * Constructor for MainPage
     * @param externalDriver
     */
    public MainPage(WebDriver externalDriver){
        this.driver = externalDriver;
        log = Logger.getLogger(getClass());
        webElementOnPage = new WebElementOnPage(driver);
        MAIN_PAGE_URL = getCfgValue("MAIN_PAGE_URL");
        MAIN_PAGE_TITLE =getCfgValue("MAIN_PAGE_TITLE");
    }
    /**
     * method opens main page
     */
    @Step("Opening main page")
    public void openMainPage(){
        try {
            webElementOnPage.openBrowserAndUrl(MAIN_PAGE_URL);
            log.info("Main page was opened!");
        } catch (Exception e) {
            log.error("Main page WASN'T opened!" + e);
        }
    }

    /**
     * method close browser from main page
     */
    public void closeBrowser(){
        webElementOnPage.closeBrowser();
        log.info("Browser was closed from page " + MAIN_PAGE_URL);
    }

    /**
     * method close window, not browser instance
     */
    public void closeMainPage(){
        webElementOnPage.closePage();
        log.info( MAIN_PAGE_URL + " page was closed!");
    }
    /**
     * get page title
     * @return String title
     */
    @Step("Get page title")
    public String getMainTitle() {
        String title = webElementOnPage.getPAgeTitle();
        log.info("Get page title: " + title);
        return title;
    }

    /**
     * Method checks is page title is correct
     * @return boolean
     */
    @Step("Checking is title is correct")
    public boolean isTitleCorect(){
        if(webElementOnPage.getPAgeTitle().equals(MAIN_PAGE_TITLE)) {
            log.info("Title is correct");
            return true;
        }
        else
            log.error("Title is not correct!");
            return false;

    }

    /**
     * method types test into title input
     * @param title
     * @return boolean
     */
    @Step("Typing text {0} into title input")
    public boolean typeTextintoTitleInput(String title) {
        boolean tempElement =
                webElementOnPage.typeTextIntoInput(title, "MainPage.Title.Input");
        log.info("Text " + title + " was typed into title input: " + tempElement);
        return tempElement;

    }
    /**
     * method types test into note body
     * @param note
     * @return boolean
     */
    @Step("Typing text {0} into note body")
    public boolean typeTextintoNoteBodyInput(String note) {
        boolean tempElement =
                webElementOnPage.typeTextIntoInput(note, "MainPage.NoteBody.Input");
        log.info("Text " + note + " was typed into note body: " + tempElement);
        return tempElement;

    }

    /**
     * method clicks DONE button
     * @return boolean
     */
    @Step("Clicks DONE button")
    public boolean clickDoneButton() {
        boolean tempElement =
                webElementOnPage.clickButton("MainPage.Done.Button");
        log.info("Button DONE was clicked: " + tempElement);
        return tempElement;
    }

    /**
     *
     * @param text
     * @return
     */
    @Step("Check is text: {0} is present on the page")
    public boolean isTextOnPage(String text){
        String pageSource=driver.findElement(By.tagName("body")).getText();
        boolean result = pageSource.contains(text);
        log.info("Text: " + text + " is on the page");
        return result;
    }

    /**
     * Check is note with title created
     * @param title
     * @return
     */
    @Step("Check is note with title {0} created")
    public boolean noteWithTitleCreated(String title) {
        boolean result = isTextOnPage(title);
        log.info("Note with title "+ title + " is created: " + result);
        return result;
    }
    /**
     * Check is note with body created
     * @param note
     * @return
     */
    @Step("Check is note with body {0} created")
    public boolean noteWithBodyCreated(String note) {
        boolean result = isTextOnPage(note);
        log.info("Note with body "+ note + " is created: " + result);
        return result;

    }
    /**
     * method clicks Retain link
     * @return boolean
     */
    @Step("Clicks Retain link")
    public boolean clickRetainLink() {
        boolean tempElement =
                webElementOnPage.clickLink("MainPage.Retain.Link");
        log.info("Retain link was clicked: " + tempElement);
        return tempElement;

    }

    /**
     * method for refreshing page
     */
    @Step("Refreshing page")
    public void refreshPage() {
        webElementOnPage.refreshPage();
        log.info("Page was refreshed!");
    }
    /**
     * method clicks Settings link
     * @return boolean
     */
    @Step("Clicks Settings link")
    public boolean clickSettingsLink() {
        boolean tempElement =
                webElementOnPage.clickLink("MainPage.Settings.Link");
        log.info("Settings link was clicked: " + tempElement);
        return tempElement;
    }
    /**
     * method clicks Signout link
     * @return boolean
     */
    @Step("Clicks Signout link")
    public boolean clickSignoutLink() {
        boolean tempElement =
                webElementOnPage.clickLink("MainPage.SignOut.Link");
        log.info("Settings link was clicked: " + tempElement);
        return tempElement;
    }

    /**
     * Method get page body (html)
     * @return
     */
    public String getPageBody() {
        String pageBody =
                driver.findElement(By.tagName("body")).getText();
        log.info("Getting page body");
        return pageBody;
    }


}
