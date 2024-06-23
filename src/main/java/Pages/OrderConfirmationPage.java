package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage {

    public WebDriver driver;
    protected By OrderHistoryBtn = By.xpath("//a[@title='Go to your order history page']");
    protected By orderReferenceDiv = By.cssSelector("div.box");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderReferenceNumber() {
        WebElement boxElement = driver.findElement(orderReferenceDiv);
        String fullText = boxElement.getText();
        return fullText.split("order reference")[1].split(" in")[0].trim();
    }

    public OrderHistoryPage clickOnOrderHistory() {
        driver.findElement(OrderHistoryBtn).click();
        return new OrderHistoryPage(driver);
    }
}
