package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import util.PropertiesManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by madja_000 on 20.11.2016.
 */
public class TopMenuBlock extends PageObject {

    @FindBy(className = "logout_icon")
    WebElement logOutButton;
    TopMenuBlock(){
        PageFactory.initElements(this.driver, this);
    }

    public PageObject pressLogoutButton(){
        logOutButton.click();
        try {
            driver.findElement(By.id("txtLogin"));
        }catch (NoSuchElementException e){
            return new PageObject();
        }
        return new LoginPage();
    }
}
