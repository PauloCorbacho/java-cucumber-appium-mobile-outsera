package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final AndroidDriver driver;

    private final By usernameField = By.id("com.example.app:id/username");
    private final By passwordField = By.id("com.example.app:id/password");
    private final By loginButton = By.id("com.example.app:id/loginButton");
    private final By errorMessage = By.id("com.example.app:id/errorMessage");
    private final By homeScreen = By.id("com.example.app:id/homeContainer");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField))
                .sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void tapLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isHomeScreenDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeScreen))
                .isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}