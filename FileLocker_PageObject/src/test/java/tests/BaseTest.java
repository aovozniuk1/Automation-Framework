package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.*;
import tests.externalPAges.CollaboratorPageTest;
import tests.externalPAges.ProfilePageTest;
import tests.home_page.HomePageTest;
import tests.login_page.LoginPageTest;
import util.DriverManager;
import util.PropertiesManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by madja_000 on 20.11.2016.
 */
public class BaseTest {

    private static final String URL = PropertiesManager.getInstance().getResourceByName("URL"); //= "https://secure.filelocker.com";

    private WebDriver driver;
    private LoginPage loginPage;
    private BasePage basePage;
    private LeftMenuBlock leftMenu;
    private ProfilePage profilePage;

    @BeforeTest
    public void beforeClass() {
        driver = DriverManager.getInstance().createWebDriver("firefox").getDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        driver.get(URL);
        if (method.getDeclaringClass().equals(LoginPageTest.class)) {
            //  Test t = method.getAnnotation(Test.class);
         //   t.groups()
            return;
        }
        if (method.getDeclaringClass().equals(HomePageTest.class)) {
            loginPage = new LoginPage();

            loginPage.loginWithCorrectData(PropertiesManager.getInstance().getResourceByName("correctLogin"), PropertiesManager.getInstance().getResourceByName("correctPassword"));
        }
        if (method.getDeclaringClass().equals(ProfilePageTest.class)) {
            loginPage = new LoginPage();
            loginPage.loginWithCorrectData(PropertiesManager.getInstance().getResourceByName("correctLogin"), PropertiesManager.getInstance().getResourceByName("correctPassword"));
            basePage = new BasePage();
            leftMenu = basePage.getLeftMenu();
            leftMenu.clickOnSettings();
            profilePage = leftMenu.clickOnProfile();
        }

        if (method.getDeclaringClass().equals(CollaboratorPageTest.class)) {
            loginPage = new LoginPage();
            loginPage.loginWithCorrectData(PropertiesManager.getInstance().getResourceByName("correctLogin"), PropertiesManager.getInstance().getResourceByName("correctPassword"));
            basePage = new BasePage();
            leftMenu = basePage.getLeftMenu();
            leftMenu.clickOnCollaborators();
        }

    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();

    }

     @AfterTest
    public void afterClass() {
        driver.close();
    }
}
