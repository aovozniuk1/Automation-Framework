package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

/**
 * Created by madja_000 on 09.12.2016.
 */
public class CollaboratorPage extends BasePage {

    private List<WebElement> listOfFoldersToShare;


    public void fillCollaboratorsData(){
        SecureRandom random = new SecureRandom();
        String description = new BigInteger(130, random).toString(32);

        chooseFolder();
        setCollaborator();
        setAccessTypeViewing();
        setDescription(description);
        pressInviteCollaboratorsButton();
    }

    private void chooseFolder() {
        driver.findElement(By.cssSelector("#dirPicker")).click();
        listOfFoldersToShare = driver.findElements(By.cssSelector("li[role='treeitem']"));
        if (listOfFoldersToShare.size() > 0) {
            WebElement folderToShare = listOfFoldersToShare.get(1);
            folderToShare.click();
        } else {
            System.out.println("There are no folders");
        }
    }

    private void setCollaborator() {
        driver.findElement(By.id("collab_btn")).click();
        List<WebElement> list = driver.findElements(By.className("suggestion"));
        if (list.size() > 0)
            list.get(0).click();
    }

    private void setAccessTypeViewing() {
        driver.findElement(By.id("s_access_type_viewer")).click();
    }

    private void setDescription(String desc) {
        WebElement field = driver.findElement(By.id("s_folder_desc"));
        field.clear();
        field.sendKeys(desc);
    }

    private void pressInviteCollaboratorsButton() {
        driver.findElement(By.cssSelector("[class='mid']")).click();
    }

    public boolean checkOKMessage() {
        try {
            driver.findElement(By.className("bizOk"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
