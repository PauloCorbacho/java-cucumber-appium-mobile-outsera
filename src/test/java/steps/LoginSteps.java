package steps;

import config.AppConfig;
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

    @When("I enter a valid username")
    public void iEnterAValidUsername() {
        loginPage.enterUsername("valid_user");
    }

    @When("I enter a valid password")
    public void iEnterAValidPassword() {
        loginPage.enterPassword("validPass123");
    }

    @When("I enter an invalid username")
    public void iEnterAnInvalidUsername() {
        loginPage.enterUsername("invalid_user");
    }

    @When("I enter an invalid password")
    public void iEnterAnInvalidPassword() {
        loginPage.enterPassword("wrongPass");
    }

    @When("I tap the login button")
    public void iTapTheLoginButton() {
        loginPage.tapLoginButton();
    }

    @Then("I should see the home screen")
    public void iShouldSeeTheHomeScreen() {
        assertTrue(loginPage.isHomeScreenDisplayed());
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        assertTrue(loginPage.isErrorMessageDisplayed());
    }
}