package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private By WomenCategory = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
    private By Blouses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a");
    private By SuccessAlert = By.xpath("//p[@class='alert alert-success']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getSuccessAlertText() {
        return driver.findElement(SuccessAlert).getText();
    }

    public void ClickOnWomenCategory () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SuccessAlert)));
        System.out.println(driver.findElement(SuccessAlert).getText());
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(WomenCategory)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Blouses)));
        driver.findElement(Blouses).click();
    }

}
