package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressesPage {

    public WebDriver driver;

    private By ProceedBtn = By.xpath("//button[@name='processAddress' and @class='button btn btn-default button-medium']");

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShippingPage ClickOnProceedBtn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        driver.findElement(ProceedBtn).click();
        return new ShippingPage(driver);
    }

}
