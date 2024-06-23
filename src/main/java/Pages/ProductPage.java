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
    private static final int TIMEOUT_SECONDS = 10;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
    }

    public void clickOnBlouse() {
        try {
            driver.findElement(BLOUSE_LINK).click();
        } catch (Exception e) {
            System.out.println("Failed to click on Blouse link: " + e.getMessage());
        }
    }

    public void chooseSize() {
        try {
            select = new Select(driver.findElement(SIZE_LIST));
            select.selectByValue("2");
        } catch (Exception e) {
            System.out.println("Failed to select size: " + e.getMessage());
        }
    }

    public void addToCart() {
        try {
            driver.navigate().refresh();
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BTN));
            button.click();
        } catch (Exception e) {
            System.out.println("Failed to add to cart: " + e.getMessage());
        }
    }

    public CartPage proceedToCheckout() {
        try {
            driver.findElement(PROCEED_TO_CHECKOUT).click();
            return new CartPage(driver);
        } catch (Exception e) {
            System.out.println("Failed to proceed to checkout: " + e.getMessage());
            return null;
        }
    }
}
