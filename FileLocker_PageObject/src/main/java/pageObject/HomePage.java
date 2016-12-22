package pageObject;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import util.PropertiesManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by madja_000 on 20.11.2016.
 */
public class HomePage extends BasePage {

    private static String CSS_SELECTOR_LOGIN_FIELD = PropertiesManager.getInstance().getResourceByName("loginFieldCss");// = "#txtLogin";

    @FindBy(id = "createFolderBtn")
    WebElement createNewFolderButton;

    @FindBy(className = "bizButton")
    WebElement createFolderButton;

    @FindBy(id = "folder_name")
    WebElement folderName;

    @FindBy(id = "w_sm_button")
    WebElement okButtonToCreateFolder;

    @FindBy(css = "[class='dirEntry dirActionContextItem     aclDirPv aclDirDl aclDirUl aclDirRm aclDirMv aclDirMkd aclDirRmd aclDirShare aclDirCm aclDirAa  ']")
    List<WebElement> listOfFolders;

    @FindBy(css = "[class='fileEntry aclFilePv aclFileDl aclFileUl aclFileRm aclFileMv aclFileMkd aclFileRmd aclFileShare aclFileCm aclFileAa fileActionContextItem canPreview']")
    List<WebElement> listOfFiles;

    public CreateFolderBox clickOnCreateFolderButton(){
        createNewFolderButton.click();
        return new CreateFolderBox();
    }

    public HomePage() {
        PageFactory.initElements(this.driver, this);
    }

    public boolean checkPresenceOfTopMenuBlock() {
        try {
            driver.findElement(By.cssSelector(CSS_SELECTOR_LOGIN_FIELD));
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

    public boolean checkPresenceOfFolderByName(String name) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='" + name + "']")));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
//TODO move to create folder boxTest


    public List<WebElement> getFoldersList() {
        return listOfFolders;
    }

    public List<WebElement> getFilesList(){
        return listOfFiles;
    }


    public List<WebElement> returnListWithoutElementByName(List<WebElement> list, String folderName) {
        return list.stream().filter(e -> !e.getAttribute("title").equals(folderName)).collect(Collectors.toList());
    }

    public void deleteAllFoldersFromList(List<WebElement> list) {
        List<String> ids = getIds(list);
        for (int i = 0; i < ids.size(); i++) {
            driver.navigate().refresh();
            WebElement folder = driver.findElement(By.id(ids.get(i)));
            Actions deleting = new Actions(driver);
            deleting.moveToElement(folder).contextClick().build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='remove_folder enabled']"))).click();
            driver.findElement(By.className("bizButton")).click();
            driver.findElement(By.id("w_sm_button")).click();
        }
    }

    private List<String> getIds(List<WebElement> list) {
        return list.stream().map(e -> e.getAttribute("id")).collect(Collectors.toList());
    }

    public boolean checkPresenceOfFoldersWithNameExclusive(List<WebElement> list,String name){
        if(list.stream().filter(e->!e.getAttribute("title").equals(name)).collect(Collectors.toList()).size()>0)
            return true;
        return false;
    }


    public void addCommentToFirstFileInList(List<WebElement> files, String comment){
        if(files.size()>0){
            WebElement file = files.get(0);
           file.findElement(By.className("fileCommentsButton")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("commentTextArea"))).sendKeys(comment);
            file.findElement(By.className("commentAddButton")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bizOk")));
        }else{
            System.out.println("There are no files");
        }
    }
    public boolean checkPresenceOfComment(List<WebElement> files,String check){
        if(files.size()>0){
            WebElement file = files.get(0);
            List<WebElement> allComments = file.findElements(By.className("commentEntry"));
                WebElement commentField = allComments.get(allComments.size()-1);
                String commentAllTxt = commentField.getText();
                String parts[] = commentAllTxt.split("\n");
                String commentTxt = parts[1];
                if (commentTxt.equals(check))
                    return true;
        }
        return false;
    }
}
