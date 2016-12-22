package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.PropertiesManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by madja_000 on 20.11.2016.
 */
public class LeftMenuBlock extends PageObject {

    @FindBy(css = "div[class='navBoxHeader menu-settings accordion-toggle']")
    WebElement settings;
    @FindBy(css = "a[href='/settings']")
    WebElement profile;
    @FindBy(css = "div[class='navBoxHeader menu-collaborators accordion-toggle']" )
    WebElement collaborators;
    @FindBy(css = "a[href='/collab/add']")
    WebElement addCollaborators;

    public LeftMenuBlock() {
        PageFactory.initElements(this.driver, this);
    }


    public void clickOnSettings() {
        settings.click();
    }


    public ProfilePage clickOnProfile() {
        profile.click();
        return new ProfilePage();
    }

    public void clickOnCollaborators(){
        collaborators.click();
    }

    public CollaboratorPage clickOnAddCollaborators(){
        addCollaborators.click();
        return new CollaboratorPage();
    }

}
