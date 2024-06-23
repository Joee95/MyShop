package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    public WebDriver driver;
    public Select select;


    private By Gender = By.xpath("//input[@type='radio' and @id='id_gender1']");
    private By FirstNameField = By.id("customer_firstname");
    private By LastNameField = By.id("customer_lastname");
    private By PasswordField = By.id("passwd");
    private By Days = By.id("days");
    private By Months = By.id("months");
    private By Years = By.id("years");
    private By RegisterBtn = By.id("submitAccount");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage userRegistration(String firstname, String lastname, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Gender)));
        driver.findElement(Gender).click();
        driver.findElement(FirstNameField).sendKeys(firstname);
        driver.findElement(LastNameField).sendKeys(lastname);
        driver.findElement(PasswordField).sendKeys(password);
        select = new Select(driver.findElement(Days));
        select.selectByValue("14");
        select = new Select(driver.findElement(Months));
        select.selectByValue("5");
        select = new Select(driver.findElement(Years));
        select.selectByValue("1995");
        driver.findElement(RegisterBtn).click();
        Thread.sleep(1000);
        return new HomePage(driver);
    }
}