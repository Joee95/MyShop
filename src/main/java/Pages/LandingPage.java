package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {

    private WebDriver driver;

    private By SignIn = By.xpath("//a[@class='login']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage clickOnSignInBtn() {
        driver.findElement(SignIn).click();
        return new SignInPage(driver);
    }
}