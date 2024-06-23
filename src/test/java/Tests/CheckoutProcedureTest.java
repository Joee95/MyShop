package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CheckoutProcedureTest extends TestBase {

    private String orderConfirmationRef;
    private String orderHistoryRef;
    String address = LoadPropertiesFile.userdata.getProperty("address");
    String city = LoadPropertiesFile.userdata.getProperty("city");
    String postalcode = LoadPropertiesFile.userdata.getProperty("postalcode");
    String homephone = LoadPropertiesFile.userdata.getProperty("homephone");
    String mobilephone = LoadPropertiesFile.userdata.getProperty("mobilephone");
    String addresstitle = LoadPropertiesFile.userdata.getProperty("addresstitle");


    @Test(priority = 7)
    public void AddressPageTest() {
        addressesPage = addressPage.addressPageFields(address , city , postalcode , homephone , mobilephone , addresstitle);
    }

    @Test(priority = 8)
    public void AddressesPageTest() {
        shippingPage = addressesPage.ClickOnProceedBtn();
    }

    @Test(priority = 9)
    public void ShippingPageTest() {
        paymentPage = shippingPage.agreeClick();
    }

    @Test(priority = 10)
    public void PaymentPageTest() {
        orderSummaryPage = paymentPage.pressOnBankWireBtn();
    }

    @Test(priority = 11)
    public void OrderSummaryPageTest() {
        orderConfirmationPage = orderSummaryPage.clickOnConfirm();
    }

    @Test(priority = 12)
    public void OrderConfirmationPageTest() {
        orderConfirmationRef = orderConfirmationPage.getOrderReferenceNumber();
        orderHistoryPage = orderConfirmationPage.clickOnOrderHistory();
    }

    @Test(priority = 13)
    public void OrderHistoryPageTest() {
        orderHistoryRef = orderHistoryPage.getOrderReference();
        Assert.assertEquals("Order not created", orderConfirmationRef, orderHistoryRef);
    }
}