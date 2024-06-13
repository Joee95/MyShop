package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ProductPage {
    public WebDriver driver;
    public Select select;

    private By BlouseLink = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a");
    private By SizeList = By.xpath("//select[@name=\"group_1\"]");
    private By AddToCartBtn = By.xpath("//span[text()='Add to cart']");
    private By ProceedToCheckOut = By.xpath("//a[@class=\"btn btn-default button button-medium\"]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickOnBlouse() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        driver.findElement(BlouseLink).click();
    }

    public void ChooseSize() {
        select = new Select(driver.findElement(SizeList));
        select.selectByValue("2");
    }

    public void AddToCart() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(AddToCartBtn));
        button.click();
    }

    public CartPage ProceedToCheckout() {
        driver.findElement(ProceedToCheckOut).click();
        return new CartPage(driver);
    }
}
