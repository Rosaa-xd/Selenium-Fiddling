import org.openqa.selenium.WebDriver;

public class Initialiser {
    public static void main(String[] args) {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle;

        WebDriver firefox = InitBrowser.openFirefox(false);
        firefox.get(baseUrl);
        actualTitle = firefox.getTitle();

        if (actualTitle.contentEquals(expectedTitle)) System.out.println("Passed");
        else System.out.println("Failed");

        firefox.close();
    }
}
