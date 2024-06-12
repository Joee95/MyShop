package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {

    public WebDriver driver;

    protected By AgreeBtn = By.xpath("//input[@id=\"cgv\"]");
    protected By ProceedBtn = By.xpath("//button[@name='processCarrier' and @class='button btn btn-default standard-checkout button-medium']");

    public ShippingPage(WebDriver driver){
        this.driver = driver;
    }
    public PaymentPage AgreeClick(){
        driver.findElement(AgreeBtn).click();
        driver.findElement(ProceedBtn).click();
        return new PaymentPage(driver);
    }

}
