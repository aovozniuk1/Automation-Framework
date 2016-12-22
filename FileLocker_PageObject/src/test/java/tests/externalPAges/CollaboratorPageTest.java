package tests.externalPAges;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.CollaboratorPage;
import pageObject.LeftMenuBlock;
import tests.BaseTest;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by madja_000 on 09.12.2016.
 */
public class CollaboratorPageTest extends BaseTest {

    @Test
    public void testAddingCollaborator(){
        LeftMenuBlock leftMenu = new LeftMenuBlock();
        CollaboratorPage collaboratorPage = leftMenu.clickOnAddCollaborators();
        collaboratorPage.fillCollaboratorsData();
        Assert.assertTrue(collaboratorPage.checkOKMessage());
    }
}
