package pageObject;

/**
 * Created by madja_000 on 21.12.2016.
 */
public class CreateFolderBox {

    public void createNewFolder(String name) {
        HomePage home = new HomePage();
        if (!home.checkPresenceOfFolderByName(name)) {
            home.folderName.sendKeys(name);
            home.createFolderButton.click();
            home.okButtonToCreateFolder.click();
        } else {
            System.out.println("Folder with such name already exists");
        }
    }
}
