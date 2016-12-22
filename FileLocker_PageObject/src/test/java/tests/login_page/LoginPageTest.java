package tests.login_page;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PageObject;
import tests.BaseTest;
import util.PropertiesManager;

/**
 * Created by madja_000 on 20.11.2016.
 */
public class LoginPageTest extends BaseTest {

    private static String CORRECT_LOGIN = PropertiesManager.getInstance().getResourceByName("correctLogin");
    ;//= "minchekov160@hotmail.com";
    private static String CORRECT_PASSWORD = PropertiesManager.getInstance().getResourceByName("correctPassword");
    ;// = "Qw1111";
    private static String ALERT_BOX_ERROR_MESSAGE = PropertiesManager.getInstance().getResourceByName("alertBoxMessage");
    ;// = "Unable to verify credentials";

    LoginPage login;

//    @BeforeClass
//    public void beforeClassLogin(){
//        try {
//            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
//            Properties property = new Properties();
//            property.load(inputStream);
//            CORRECT_LOGIN=property.getProperty("correctLogin");
//            CORRECT_PASSWORD=property.getProperty("correctPassword");
//            ALERT_BOX_ERROR_MESSAGE=property.getProperty("alertBoxMessage");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @BeforeMethod
    public void beforeLoinPage() {
        login = new LoginPage();
    }

    @Test
    public void testLoginWithCorrectData() {
        //  login = new LoginPage();
        PageObject page = login.loginWithCorrectData(CORRECT_LOGIN, CORRECT_PASSWORD);
        Assert.assertTrue(page instanceof HomePage);
        Assert.assertTrue(((HomePage) page).checkPresenceOfTopMenuBlock());
    }

    @Test(dataProvider = "loginFullData",groups = "freeAccount , admin")
    public void testLoginWithIncorrectData(String log, String pass) {
        // login = new LoginPage();
        PageObject page = login.loginWithIncorrectData(log, pass);
        Assert.assertTrue(page instanceof LoginPage);
        Assert.assertTrue(login.getAlertBoxErrorMessage().equals(ALERT_BOX_ERROR_MESSAGE));
    }

    @Test(dataProvider = "loginEmptyData")
    public void testLoginWithEmptyFields(String log, String pass, String err) {
        // login = new LoginPage();
        PageObject page = login.loginWithEmptyFields(log, pass);
        Assert.assertTrue(page instanceof LoginPage);
        Assert.assertTrue(((LoginPage) page).getWarningBoxMessage().equals(err));
    }

    @DataProvider
    public Object[][] loginEmptyData() {
        return new Object[][]{
                {CORRECT_LOGIN, "", "Password must be supplied"},
                {"", CORRECT_PASSWORD, "Username must be supplied"}
        };
    }

    @DataProvider
    public Object[][] loginFullData() {
        return new Object[][]{
                {"wrongLogin", CORRECT_PASSWORD},
                {CORRECT_LOGIN, "wrongLogin"}
        };
    }
}
