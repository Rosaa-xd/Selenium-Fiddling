import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Initialiser {
    public static void main(String[] args) {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle;

        List<WebDriver> browsers = new ArrayList<>();

        WebDriver firefox = InitBrowser.openFirefox(true);
        WebDriver chrome = InitBrowser.openChrome(true);
        WebDriver msedge = InitBrowser.openMSEdge();

        browsers.add(firefox);
        browsers.add(chrome);
        browsers.add(msedge);

        for (WebDriver browser : browsers) {
            browser.get(baseUrl);
            actualTitle = browser.getTitle();

            if (actualTitle.contentEquals(expectedTitle)) System.out.println(browser.toString() + ": PASSED");
            else System.out.println(browser.toString() + ": Failed");

            browser.close();
        }
    }
}
