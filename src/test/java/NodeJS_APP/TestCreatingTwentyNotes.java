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
public class CreatingTwentyNotes extends ParentTest {
    MainPage mainPage;

    public CreatingTwentyNotes(String browser) throws MalformedURLException {
        super(browser);
    }

    @Title("5-th test!")
    @Description("Test to create 20 new notes")
    @Test
    public void createTwentyNewNotes(){
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String title = "new title";
        String note = "new note";
        Assert.assertTrue("Check title", mainPage.isTitleCorect());
        for (int i = 4; i < 21; i++){
            Assert.assertTrue("Check creating " + i + "note!",
                    mainPage.typeTextintoTitleInput(i + " " + title)&&
                    mainPage.typeTextintoNoteBodyInput(i + " " + note)&&
                    mainPage.clickDoneButton()
            );
            Assert.assertTrue("Check if note is created",
                    mainPage.noteWithTitleCreated(i + " " + title)&&
                    mainPage.noteWithBodyCreated(i + " " + note)
            );
        }


    }

    @After
    public void tearDown(){
        mainPage.closeBrowser();
    }
}
