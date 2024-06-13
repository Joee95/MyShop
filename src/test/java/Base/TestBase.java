package Base;

import Pages.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;

public class TestBase extends AbstractTestNGCucumberTests {

    protected static WebDriver driver;
    protected static ChromeOptions options;
    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads\\EncryptedFile";

    protected static LandingPage landingPage;
    protected static SignInPage signInPage;
    protected static RegistrationPage registrationPage;
    protected static  HomePage homePage;
    protected static ProductPage productPage;
    protected static CartPage cartPage;
    protected static AddressPage addressPage;
    protected static AddressesPage addressesPage;
    protected static ShippingPage shippingPage;
    protected static PaymentPage paymentPage;
    protected static OrderSummaryPage orderSummaryPage;
    protected static OrderConfirmationPage orderConfirmationPage;
    protected static OrderHistoryPage orderHistoryPage;

    public static ChromeOptions chromeOption() {
        options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return options;
    }

    @BeforeSuite
    public void SetUpEnvironment() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1024,768");
        driver = new ChromeDriver(options);
        driver.navigate().to("http://www.automationpractice.pl/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.manage().window().maximize();
        landingPage = new LandingPage(driver);
    }


    @AfterSuite
    public void CloseDriver (){
        driver.quit();
    }

}