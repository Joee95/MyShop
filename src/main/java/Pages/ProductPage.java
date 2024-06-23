package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private Select select;
    private WebDriverWait wait;

    private static final By BLOUSE_LINK = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a");
    private static final By SIZE_LIST = By.xpath("//select[@name=\"group_1\"]");
    private static final By ADD_TO_CART_BTN = By.xpath("//span[text()='Add to cart']");
    private static final By PROCEED_TO_CHECKOUT = By.xpath("//a[@class=\"btn btn-default button button-medium\"]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnBlouse() {
        driver.findElement(BLOUSE_LINK).click();
    }

    public void chooseSize() {
        select = new Select(driver.findElement(SIZE_LIST));
        select.selectByValue("2");
    }

    public void addToCart() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BTN));
        button.click();
    }

    public CartPage proceedToCheckout() {
        driver.findElement(PROCEED_TO_CHECKOUT).click();
        return new CartPage(driver);
    }
}
