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
public class CreateNoteWithEmptyBody extends ParentTest {
    MainPage mainPage;

    public CreateNoteWithEmptyBody(String browser) throws MalformedURLException {
        super(browser);
    }

    @Title("2-nd test!")
    @Description("Test to create new note with empty body")
    @Test
    public void newNoteWithEmptyBody(){
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String title = "new title";

        Assert.assertTrue("Check title", mainPage.isTitleCorect());
        Assert.assertTrue("Check steps",
                mainPage.typeTextintoTitleInput(title)&&
                mainPage.clickDoneButton()
        );
        Assert.assertTrue("Check if note is created",
                mainPage.noteWithTitleCreated(title)
        );
    }

    @After
    public void tearDown(){
        mainPage.closeBrowser();
    }
}
