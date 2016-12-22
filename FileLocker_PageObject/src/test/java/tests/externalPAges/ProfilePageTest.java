package tests.externalPAges;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.*;
import profileData.ProfileData;
import profileData.ProfileDataBuilder;
import tests.BaseTest;

/**
 * Created by madja_000 on 27.11.2016.
 */
public class ProfilePageTest extends BaseTest {

    @Test(dataProvider = "profileInput")
    public void testChangeProfile(ProfileData profile) {
        LeftMenuBlock leftMenu = new LeftMenuBlock();
        ProfilePage profilePage = leftMenu.clickOnProfile();


        profilePage.fillProfileData(profile);
        profilePage.clickOnSaveChangesButton();
        leftMenu.clickOnProfile();
        Assert.assertEquals(profilePage.readFields(), profile);

    }

    @DataProvider
    public Object[][] profileInput() {
        return new Object[][]{
                {new ProfileDataBuilder().setFirstName("aa").setLastName("ss").setCompanyName("dd").setWebSite("http://j").setTitle("").setPhone("1234567").setTimeZone("Africa/Abidjan").setItemsPerPage(20).setMaximumFileAge(0).build()},
                {new ProfileDataBuilder().setFirstName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").setLastName("ssssssssssssssssssssssssssssss").setCompanyName("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd").setWebSite("http://jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj").setTitle("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk").setPhone("12345678901234567890").setTimeZone("UTC").setItemsPerPage(250).setMaximumFileAge(9999).build()}
        };
    }
}
