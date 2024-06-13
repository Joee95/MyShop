package Tests;

import Base.TestBase;
import org.testng.annotations.Test;

public class ClickOnBlouseTest extends TestBase {
    @Test(priority = 5)
    public void ClickOnBlouseLink() {
        productPage.ClickOnBlouse();
        productPage.ChooseSize();
        productPage.AddToCart();
        cartPage = productPage.ProceedToCheckout();
    }

}