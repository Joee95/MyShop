package Tests;

import Base.BaseTest;
import LoadProperties.LoadPropertiesFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest extends BaseTest {

    String email = LoadPropertiesFile.userdata.getProperty("email");
    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String lastname = LoadPropertiesFile.userdata.getProperty("lastname");
    String password = LoadPropertiesFile.userdata.getProperty("password");

    @Test(priority = 1)
    public void clickOnSignInButton() {
        signInPage = landingPage.clickOnSignInBtn();
    }

    @Test(priority = 2)
    public void clickOnCreateNewUser() throws InterruptedException {
        registrationPage = signInPage.clickOnCreateNewUserBtn(email, firstname, lastname, password);
    }

    @Test(priority = 3)
    public void registerNewUser() throws InterruptedException {
        homePage = registrationPage.userRegistration(firstname, lastname, password);
        String expectedText = "Your account has been created.";
        Assert.assertTrue(homePage.getSuccessAlertText().contains(expectedText), "Account creation failed!");
    }

    @Test(priority = 4)
    public void verifyNavigationToWomenCategory() {
        productPage = homePage.clickOnWomenCategory();
        Assert.assertNotNull(productPage, "Navigation to Women Category failed!");
    }
}