package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverManager;

/**
 * Created by madja_000 on 19.11.2016.
 */
public class PageObject {
    protected WebDriver driver = DriverManager.getInstance().getDriver();
    protected WebDriverWait wait;

    public PageObject() {
        wait = new WebDriverWait(driver, 15);
    }
}
