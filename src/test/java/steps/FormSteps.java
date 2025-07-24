package steps;

import config.AppConfig;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FormPage;
import pages.MenuPage;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FormSteps {
    private AndroidDriver driver;
    private FormPage formPage;

    @Given("I open the form screen")
    public void openFormScreen() throws Exception {
        driver = AppConfig.getDriver();
        new MenuPage(driver).selectMenu("Views");
        new MenuPage(driver).selectMenu("App");
        new MenuPage(driver).selectMenu("Light Theme");
        formPage = new FormPage(driver);
    }

    @When("I fill in:")
    public void fillForm(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> data = dataTable.asMap();
        formPage.fillForm(data.get("Name"), data.get("Email"));
    }

    @Then("I should see confirmation message")
    public void verifyConfirmation() {
        assertTrue(formPage.isConfirmationDisplayed());
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        formPage.submit();
    }
}