package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import profileData.ProfileData;
import profileData.ProfileDataBuilder;
import util.PropertiesManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by madja_000 on 22.11.2016.
 */
public class ProfilePage extends BasePage {

   public ProfilePage() {
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(name = "s_first_name")
    WebElement firstName;
    @FindBy(name = "s_last_name")
    WebElement lastName;
    @FindBy(name = "s_company_name")
    WebElement companyName;
    @FindBy(name = "s_website")
    WebElement webSite;
    @FindBy(name = "s_title")
    WebElement title;
    @FindBy(name = "s_phone")
    WebElement phone;
    @FindBy(name = "s_timezone")
    WebElement timeZone;
    @FindBy(name = "s_file_listing_page_size")
    WebElement itemsPerPage;
    @FindBy(name = "s_policy_file_age")
    WebElement maxAge;
    @FindBy(name = "btnSaveChanges")
    WebElement buttonSaveChanges;

    public void fillProfileData(ProfileData profile) {
        fillProfileFieldFirstName(profile);
        fillProfileFieldLastName(profile);
        fillProfileFieldCompanyName(profile);
        fillProfileFieldWebSite(profile);
        fillProfileFieldTitle(profile);
        fillProfileFieldPhone(profile);
        fillProfileFieldTimeZone(profile);
        fillProfileFieldItemsPerPage(profile);
        fillProfileFieldMaxAge(profile);
    }

    private void fillProfileFieldFirstName(ProfileData profile) {
        firstName.clear();
        firstName.sendKeys(profile.getFirstName());
    }

    private void fillProfileFieldLastName(ProfileData profile) {
        lastName.clear();
        lastName.sendKeys(profile.getLastName());
    }

    private void fillProfileFieldCompanyName(ProfileData profile) {
        companyName.clear();
        companyName.sendKeys(profile.getCompanyName());
    }

    private void fillProfileFieldWebSite(ProfileData profile) {

        webSite.clear();
        webSite.sendKeys(profile.getWebSite());
    }

    private void fillProfileFieldTitle(ProfileData profile) {
        title.clear();
        title.sendKeys(profile.getTitle());
    }

    private void fillProfileFieldPhone(ProfileData profile) {
        phone.clear();
        phone.sendKeys(profile.getPhone());
    }

    private void fillProfileFieldTimeZone(ProfileData profile) {

        Select dropDown = new Select(timeZone);
        dropDown.selectByValue(profile.getTimeZone());
    }

    private void fillProfileFieldItemsPerPage(ProfileData profile) {
     ;
        Select dropDown = new Select(itemsPerPage);
        dropDown.selectByValue(Integer.toString(profile.getItemsPerPage()));
    }


    private void fillProfileFieldMaxAge(ProfileData profile) {
        maxAge.clear();
        maxAge.sendKeys(Integer.toString(profile.getMaximumFileAge()));
    }

    public void clickOnSaveChangesButton() {
        buttonSaveChanges.click();

    }

    public ProfileData readFields() {
        ProfileDataBuilder profileBuilder = new ProfileDataBuilder();
        ProfileData profile = profileBuilder
                .setFirstName(readFirstName())
                .setLastName(readLastName())
                .setCompanyName(readCompanyName())
                .setWebSite(readWebSite())
                .setTitle(readTitle())
                .setPhone(readPhone())
                .setTimeZone(readTimeZone())
                .setItemsPerPage(Integer.parseInt(readItemsPerPage()))
                .setMaximumFileAge(Integer.parseInt(readFileMaxAge()))
                .build();

        return profile;
    }

    private String readFirstName() {
        return firstName.getAttribute("value");
    }

    private String readLastName() {
        return lastName.getAttribute("value");
    }

    private String readCompanyName() {return companyName.getAttribute("value");
    }

    private String readWebSite() {
        return webSite.getAttribute("value");
    }

    private String readTitle() {
        return title.getAttribute("value");
    }

    private String readPhone() {
        return phone.getAttribute("value");
    }

    private String readTimeZone() {
        return timeZone.getAttribute("value");
    }

    private String readItemsPerPage() {
        return itemsPerPage.getAttribute("value");
    }

    private String readFileMaxAge() {
        return maxAge.getAttribute("value");
    }


}
