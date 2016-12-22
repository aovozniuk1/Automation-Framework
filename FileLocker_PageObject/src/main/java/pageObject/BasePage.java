package pageObject;

/**
 * Created by madja_000 on 20.11.2016.
 */
public class BasePage extends PageObject {
    private LeftMenuBlock leftMenu= new LeftMenuBlock();
    private TopMenuBlock topMenu = new TopMenuBlock();

    public LeftMenuBlock getLeftMenu() {
        return leftMenu;
    }

    public TopMenuBlock getTopMenu() {
        return topMenu;
    }
}
