package initialisers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class InitBrowser {
    public static List<WebDriver> initialiseBrowsers() {
        List<WebDriver> browsers = new ArrayList<>();

        browsers.add(openChrome(true));
        browsers.add(openFirefox(true));
        browsers.add(openMSEdge());

        return browsers;
    }

    public static ChromeDriver openChrome(boolean headless) {
        System.setProperty("webdriver.chrome.driver", getDriver(Browser.CHROME));
        if (headless) return new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        else return new ChromeDriver();
    }

    public static FirefoxDriver openFirefox(boolean headless) {
        System.setProperty("webdriver.gecko.driver", getDriver(Browser.FIREFOX));
        if (headless) return new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
        else return new FirefoxDriver();
    }

    public static EdgeDriver openMSEdge() {
        System.setProperty("webdriver.edge.driver", getDriver(Browser.MSEDGE));
        return new EdgeDriver();
    }

    private static String getDriver(Browser browser) {
        try (InputStream input = InitBrowser.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            switch (browser) {
                case CHROME: return properties.getProperty("driverLocation.chrome");
                case FIREFOX: return properties.getProperty("driverLocation.firefox");
                case MSEDGE: return properties.getProperty("driverLocation.msedge");
                default: return null;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private enum Browser {
        CHROME,
        FIREFOX,
        MSEDGE
    }
}
