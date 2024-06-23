package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test(priority = 6)
    public void proceedCartPage() {
        addressPage = cartPage.clickOnProceed();
        Assert.assertNotNull(addressPage, "Proceed to address page failed!");
    }
}