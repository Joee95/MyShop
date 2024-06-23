package Tests;

import Base.BaseTest;
import LoadProperties.LoadPropertiesFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutProcedureTest extends BaseTest {

    private String orderConfirmationRef;

    String address = LoadPropertiesFile.userdata.getProperty("address");
    String city = LoadPropertiesFile.userdata.getProperty("city");
    String postalCode = LoadPropertiesFile.userdata.getProperty("postalCode");
    String homePhone = LoadPropertiesFile.userdata.getProperty("homePhone");
    String mobilePhone = LoadPropertiesFile.userdata.getProperty("mobilePhone");
    String addressTitle = LoadPropertiesFile.userdata.getProperty("addressTitle");

    @Test(priority = 7)
    public void addressPageTest() {
        addressesPage = addressPage.addressPageFields(address, city, postalCode, homePhone, mobilePhone, addressTitle);
        Assert.assertNotNull(addressesPage, "Filling address page failed!");
    }

    @Test(priority = 8)
    public void addressesPageTest() {
        shippingPage = addressesPage.ClickOnProceedBtn();
        Assert.assertNotNull(shippingPage, "Proceed to shipping page failed!");
    }

    @Test(priority = 9)
    public void shippingPageTest() {
        paymentPage = shippingPage.agreeClick();
        Assert.assertNotNull(paymentPage, "Proceed to payment page failed!");
    }

    @Test(priority = 10)
    public void paymentPageTest() {
        orderSummaryPage = paymentPage.pressOnBankWireBtn();
        Assert.assertNotNull(orderSummaryPage, "Proceed to order summary page failed!");
    }

    @Test(priority = 11)
    public void orderSummaryPageTest() {
        orderConfirmationPage = orderSummaryPage.clickOnConfirm();
        Assert.assertNotNull(orderConfirmationPage, "Order confirmation failed!");
    }

    @Test(priority = 12)
    public void orderConfirmationPageTest() {
        orderConfirmationRef = orderConfirmationPage.getOrderReferenceNumber();
        orderHistoryPage = orderConfirmationPage.clickOnOrderHistory();
        Assert.assertNotNull(orderHistoryPage, "Navigation to order history page failed!");
    }

    @Test(priority = 13)
    public void orderHistoryPageTest() {
        String orderHistoryRef = orderHistoryPage.getOrderReference();
        Assert.assertEquals(orderConfirmationRef, orderHistoryRef, "Order reference mismatch!");
    }
}