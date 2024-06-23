package Tests;

import Base.TestBase;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {
    @Test(priority = 6)
    public void ProceedCartPage() {
        addressPage = cartPage.clickOnProceed();
    }
}