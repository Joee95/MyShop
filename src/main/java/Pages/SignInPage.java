package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {

    public WebDriver driver;
    public Select select;

    private By EmailField = By.xpath("//*[@id=\"email_create\"]");
    private By CreateNewUserBtn = By.id("SubmitCreate");
    private By Gender = By.xpath("//input[@type='radio' and @id='id_gender1']");
    private By FirstNameField = By.id("customer_firstname");
    private By LastNameField = By.id("customer_lastname");
    private By PasswordField = By.id("passwd");
    private By Days = By.id("days");
    private By Months = By.id("months");
    private By Years = By.id("years");
    private By RegisterBtn = By.id("submitAccount");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage ClickOnCreateNewUserBtn(String email, String firstname, String lastname, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(EmailField)));
        driver.findElement(EmailField).sendKeys(email);
        driver.findElement(CreateNewUserBtn).click();
        return new RegistrationPage(driver);

    }
}
