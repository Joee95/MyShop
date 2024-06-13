package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    public WebDriver driver;

    protected By PayByBankWireBtn = By.xpath("//a[@title='Pay by bank wire']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderSummaryPage PressOnBankWireBtn() {
        driver.findElement(PayByBankWireBtn).click();
        return new OrderSummaryPage(driver);
    }
}
