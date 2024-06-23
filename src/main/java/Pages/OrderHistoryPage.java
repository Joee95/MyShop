package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage {

    public WebDriver driver;

    protected By orderReference = By.cssSelector("table#order-list tbody tr:first-child td.history_link a");


    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderReference() {
        WebElement referenceLink = driver.findElement(orderReference);
        return referenceLink.getText();
    }
}
