package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressPage {
    public WebDriver driver;
    public Select select;

    protected By Address = By.xpath("//input[@id='address1']");
    protected By City = By.xpath("//input[@id='city']");
    protected By State = By.xpath("//select[@id='id_state']");
    protected By PostalCode = By.xpath("//input[@id='postcode']");
    protected By Country = By.xpath("//select[@name='id_country']");
    protected By HomePhone = By.xpath("//input[@id='phone']");
    protected By MobilePhone = By.xpath("//input[@id='phone_mobile']");
    protected By AddressTitle = By.xpath("//input[@id='alias']");
    protected By SaveBtn = By.xpath("//button[@name='submitAddress' and @id='submitAddress']");


    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddressesPage addressPageFields(String address , String city , String postalcode , String homephone , String mobilephone , String addresstitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        driver.findElement(Address).sendKeys(address);
        driver.findElement(City).sendKeys(city);
        select = new Select(driver.findElement(State));
        select.selectByVisibleText("California");
        driver.findElement(PostalCode).sendKeys(postalcode);
        select = new Select(driver.findElement(Country));
        select.selectByValue("21");
        driver.findElement(HomePhone).sendKeys(homephone);
        driver.findElement(MobilePhone).sendKeys(mobilephone);
        driver.findElement(AddressTitle).sendKeys(addresstitle);
        driver.findElement(SaveBtn).click();
        return new AddressesPage(driver);
    }

}
