package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class FormPage {
    private final AndroidDriver driver;

    private final By nameField = By.id("io.appium.android.apis:id/name");
    private final By emailField = By.id("io.appium.android.apis:id/email");
    private final By submitButton = By.id("io.appium.android.apis:id/submit");
    private final By confirmation = By.id("io.appium.android.apis:id/confirmation");

    public FormPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    public void submit() {
        driver.findElement(submitButton).click();
    }

    public boolean isConfirmationDisplayed() {
        return driver.findElement(confirmation).isDisplayed();
    }
}