package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    public WebDriver driver;

    private By ProceedToCheckOut = By.xpath("//body[@id='order']");

    public CartPage (WebDriver driver){
        this.driver = driver;
    }

    public AddressPage ClickOnProceed (){
    driver.findElement(ProceedToCheckOut).click();
    return new AddressPage(driver);
    }
}

