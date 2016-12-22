package pageObject;

import org.openqa.selenium.Alert;
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
 * Created by madja_000 on 19.11.2016.
 */
public class LoginPage extends PageObject {

    @FindBy(css = "#txtLogin")
    WebElement loginField;
    @FindBy(css = "#txtPassword")
    WebElement passwordField;
    @FindBy(css = "#loginBtnSecText")
    WebElement loginButton;
    @FindBy(css = "#alertBox center")
    WebElement alertBox;

    public LoginPage(){
        PageFactory.initElements(this.driver, this);
    }


    private void login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public HomePage loginWithCorrectData(String login, String password) {
        login(login, password);

        return new HomePage();
    }

    public LoginPage loginWithIncorrectData(String login, String password) {
        login(login, password);

        return new LoginPage();
    }

    public PageObject loginWithEmptyFields(String login, String password) {
        login(login, password);

        return this;
    }

    public String getWarningBoxMessage() {
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        return message;
    }

    public String getAlertBoxErrorMessage() {
        return alertBox.getText();
    }
}
