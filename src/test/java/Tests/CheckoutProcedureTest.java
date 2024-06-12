package Tests;

import Base.TestBase;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CheckoutProcedureTest extends TestBase {

    private String orderConfirmationRef;
    private String orderHistoryRef;

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
