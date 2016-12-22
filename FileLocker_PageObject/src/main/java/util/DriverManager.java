package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by madja_000 on 19.11.2016.
 */
public class DriverManager {
    //browsers constants
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    private static final String PATH_TO_CHROME_DRIVER = "src/main/java/resources/browsers/chromedriver.exe";

    private static final DriverManager INSTANCE = new DriverManager();

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        return INSTANCE;
    }

    public DriverManager createWebDriver(String name) {
        if (name.equalsIgnoreCase(FIREFOX))
            driver.set(new FirefoxDriver());
        else if (name.equalsIgnoreCase(CHROME)) {
            System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
            driver.set(new ChromeDriver());
        }
        else
            throw new UnsupportedOperationException("Wrong name");
        return this;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

}
