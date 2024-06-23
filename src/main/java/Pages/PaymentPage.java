package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    public WebDriver driver;

    protected By payByBankWireBtn = By.xpath("//a[@title='Pay by bank wire']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderSummaryPage pressOnBankWireBtn() {
        driver.findElement(payByBankWireBtn).click();
        return new OrderSummaryPage(driver);
    }
}
