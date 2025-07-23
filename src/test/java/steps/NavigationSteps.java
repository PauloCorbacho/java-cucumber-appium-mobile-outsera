package steps;

import config.AppConfig;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MenuPage;

import static org.junit.Assert.assertTrue;

public class NavigationSteps {
    private AndroidDriver driver;
    private MenuPage menuPage;

    @Given("I open the ApiDemos app")
    public void openApp() throws Exception {
        driver = AppConfig.getDriver();
        menuPage = new MenuPage(driver);
    }

    @When("I navigate to {string} menu")
    public void navigateToMenu(String menuName) {
        menuPage.selectMenu(menuName);
    }

    @Then("I should see text {string} on screen")
    public void verifyText(String text) {
        assertTrue(menuPage.isTextDisplayed(text));
    }
}