package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.junit.Assert;
import org.testng.annotations.Test;


public class AutomationTaskTest extends TestBase {


    String email = LoadPropertiesFile.userdata.getProperty("email");
    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String lastname = LoadPropertiesFile.userdata.getProperty("lastname");
    String password = LoadPropertiesFile.userdata.getProperty("password");

    private String orderConfirmationRef;
    private String orderHistoryRef;

    @Test(priority = 1)
    public void ClickOnSignInButton() throws InterruptedException {
        signInPage = landingPage.ClickOnSignInBtn();
    }

    @Test(priority = 2)
    public void ClickOnCreateNewUser() throws InterruptedException {
        registrationPage = signInPage.ClickOnCreateNewUserBtn(email, firstname, lastname, password);
    }

    @Test(priority = 3)
    public void RegisterNewUser() throws InterruptedException {
        homePage = registrationPage.UserRegistration(firstname, lastname, password);
    }
    @Test(priority = 4)
    public void SearchForBlouses() {
    String expectedText = "Your account has been created.";
    Assert.assertTrue("Element does not contain the expected text",
            homePage.getSuccessAlertText().contains(expectedText));
    productPage = homePage.ClickOnWomenCategory();
    }


    @Test(priority = 5)
    public void ClickOnBlouseLink() {
        productPage.ClickOnBlouse();
        productPage.ChooseSize();
        productPage.AddToCart();
        cartPage = productPage.ProceedToCheckout();
    }

    @Test(priority = 6)
    public void ProceedCartPage() {
        addressPage = cartPage.ClickOnProceed();
    }

    @Test(priority = 7)
    public void AddressPageTest() {
        addressesPage = addressPage.AddressPageFields();
    }

    @Test(priority = 8)
    public void AddressesPageTest() {
        shippingPage = addressesPage.ClickOnProceedBtn();
    }

    @Test(priority = 9)
    public void ShippingPageTest() {
        paymentPage = shippingPage.AgreeClick();
    }

    @Test(priority = 10)
    public void PaymentPageTest() {
        orderSummaryPage = paymentPage.PressOnBankWireBtn();
    }

    @Test(priority = 11)
    public void OrderSummaryPageTest() {
        orderConfirmationPage = orderSummaryPage.ClickOnConfirm();
    }

    @Test(priority = 12)
    public void OrderConfirmationPageTest(){
        orderConfirmationRef = orderConfirmationPage.getOrderReferenceNumber();
     orderHistoryPage =  orderConfirmationPage.ClickOnOrderHistory();
    }
    @Test(priority = 13)
    public void OrderHistoryPageTest(){
        orderHistoryRef = orderHistoryPage.getOrderReference();
        Assert.assertEquals("Order not created", orderConfirmationRef, orderHistoryRef);
    }


}