package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SmartBearHomePage;
import utils.Driver;

public class BaseSteps {
    WebDriver driver;
    WebDriverWait explicitWait;



    @Before
    public void setUp(){
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 15);

    }
    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }
}














