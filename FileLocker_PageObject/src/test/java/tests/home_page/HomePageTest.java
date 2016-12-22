package tests.home_page;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.*;
import tests.BaseTest;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

public class HomePageTest extends BaseTest {

    private BasePage basePage;
    private HomePage home;


    @BeforeMethod
    public void homePagePrepare() {
        home = new HomePage();
        basePage = new BasePage();
    }


    @Test
    public void testLogoutButton() {
        TopMenuBlock topMenu = basePage.getTopMenu();
        PageObject page = topMenu.pressLogoutButton();
        Assert.assertTrue(page instanceof LoginPage);

    }


    @Test
    public void testPresenceOfOfFileSharingFolder() {
        Assert.assertTrue(home.checkPresenceOfFolderByName("File Sharing"));
    }

    @Test
    public void testCreatingNewFolder() {
        SecureRandom random = new SecureRandom();
        String folderName = new BigInteger(130, random).toString(32);
        CreateFolderBox createFolderBox = home.clickOnCreateFolderButton();
        createFolderBox.createNewFolder(folderName);
        Assert.assertTrue(home.checkPresenceOfFolderByName(folderName));
    }

    @Test
    public void deleteAllFoldersExclusivelyFileSharing() {
        List folders = home.getFoldersList();
        folders = home.returnListWithoutElementByName(folders, "File Sharing");
        home.deleteAllFoldersFromList(folders);
        Assert.assertFalse(home.checkPresenceOfFoldersWithNameExclusive(home.getFoldersList(), "File Sharing"));
    }

    @Test
    public void testAddingCommentToFile(){
        SecureRandom random = new SecureRandom();
        String comment = new BigInteger(130, random).toString(32);
        home.addCommentToFirstFileInList(home.getFilesList(), comment);
       Assert.assertTrue(home.checkPresenceOfComment(home.getFilesList(),comment));
    }
}
