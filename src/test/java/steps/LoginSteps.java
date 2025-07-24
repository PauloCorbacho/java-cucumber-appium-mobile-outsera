package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import pages.LoginPage;
import static org.junit.Assert.*;

public class LoginSteps {
    private AndroidDriver driver;
    private LoginPage loginPage;

    @Given("I am on the login screen")
    public void iAmOnTheLoginScreen() {
        driver = AppConfig.getDriver();
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I tap the login button")
    public void iTapTheLoginButton() {
        loginPage.tapLoginButton();
    }

    @Then("I should see {string}")
    public void iShouldSee(String expectedResult) {
        switch(expectedResult.toLowerCase()) {
            case "home screen":
                assertTrue("Home screen not displayed", loginPage.isHomeScreenDisplayed());
                break;
            case "error message":
                assertTrue("Error message not displayed", loginPage.isErrorMessageDisplayed());
                break;
            case "password expired message":
                assertTrue("Password expired message not displayed",
                        loginPage.isPasswordExpiredMessageDisplayed());
                break;
            default:
                throw new IllegalArgumentException("Unknown expected result: " + expectedResult);
        }
    }
}