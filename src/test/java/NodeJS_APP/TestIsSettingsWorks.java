package NodeJS_APP;

import NodeJS_APP.libs.ParentTest;
import NodeJS_APP.pages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.MalformedURLException;

/**
 * Created by roman on 3/31/17.
 */
public class TestIsSettingsWorks extends ParentTest {
    MainPage mainPage;

    public TestIsSettingsWorks(String browser) throws MalformedURLException {
        super(browser);
    }

    @Title("6-th test!")
    @Description("Test to check is Settings menu works")
    @Test
    public void isSettingsWorks(){
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String title = "new title";
        String note = "new note";
        Assert.assertTrue("Check title", mainPage.isTitleCorect());
        Assert.assertTrue("Check steps",
                mainPage.typeTextintoTitleInput(title)&&
                        mainPage.typeTextintoNoteBodyInput(note)&&
                        mainPage.clickDoneButton()
        );
        Assert.assertTrue("Check if note is created",
                mainPage.noteWithTitleCreated(title)&&
                        mainPage.noteWithBodyCreated(note)
        );
        String pageBody = mainPage.getPageBody();
        mainPage.clickSettingsLink();
        Assert.assertFalse(pageBody.equals(mainPage.getPageBody()));
    }

    @After
    public void tearDown(){
        mainPage.closeBrowser();
    }


}
