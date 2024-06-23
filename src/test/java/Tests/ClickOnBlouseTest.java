package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickOnBlouseTest extends BaseTest {

    @Test(priority = 5)
    public void clickOnBlouseLink() {
        productPage.clickOnBlouse();
        productPage.chooseSize();
        productPage.addToCart();
        cartPage = productPage.proceedToCheckout();
        Assert.assertNotNull(cartPage, "Proceed to checkout failed!");
    }
}