package tests;

import initialisers.InitBrowser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

@RunWith(Parameterized.class)
public class TitleTest {
    private WebDriver browser;
    private String baseUrl;
    private String expectedTitle;

    public TitleTest(WebDriver browser) {
        super();
        this.browser = browser;
    }

    @Before
    public void setup() {
        baseUrl = "http://demo.guru99.com/test/newtours/";
        expectedTitle = "Welcome: Mercury Tours";
    }

    @Parameterized.Parameters
    public static Collection browsers() {
        return InitBrowser.initialiseBrowsers();
    }

    @Test
    public void testTitleTest() {
        browser.get(baseUrl);
        assertEquals(expectedTitle, browser.getTitle());
        browser.close();
    }
}
