package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AccountCreationTest extends TestBase {

    private WebDriver driver;

    String email = LoadPropertiesFile.userdata.getProperty("email");
    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String lastname = LoadPropertiesFile.userdata.getProperty("lastname");
    String password = LoadPropertiesFile.userdata.getProperty("password");

    @Test(priority = 1)
    public void ClickOnSignInButton() {
        signInPage = landingPage.clickOnSignInBtn();
    }

    @Test(priority = 2)
    public void ClickOnCreateNewUser() throws InterruptedException {
        registrationPage = signInPage.clickOnCreateNewUserBtn(email, firstname, lastname, password);
    }

    @Test(priority = 3)
    public void RegisterNewUser() throws InterruptedException {
        homePage = registrationPage.userRegistration(firstname, lastname, password);
    }

    @Test(priority = 4)
    public void accountCreationTest() {
        String expectedText = "Your account has been created.";
        Assert.assertTrue("Element does not contain the expected text",
                homePage.getSuccessAlertText().contains(expectedText));
        productPage = homePage.clickOnWomenCategory();
    }
}