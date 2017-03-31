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
public class TestCreateNoteWithEmptyTitle extends ParentTest {
    MainPage mainPage;

    public TestCreateNoteWithEmptyTitle(String browser) throws MalformedURLException {
        super(browser);
    }

    @Title("3-rd test!")
    @Description("Test to create new note with empty title")
    @Test
    public void newNoteWithEmptyTitle(){
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String note = "new note";

        Assert.assertTrue("Check title", mainPage.isTitleCorect());
        Assert.assertTrue("Check steps",
                mainPage.typeTextintoNoteBodyInput(note)&&
                        mainPage.clickDoneButton()
        );
        Assert.assertTrue("Check if note is created",
                mainPage.noteWithBodyCreated(note)
        );
    }

    @After
    public void tearDown(){
        mainPage.closeBrowser();
    }
}
