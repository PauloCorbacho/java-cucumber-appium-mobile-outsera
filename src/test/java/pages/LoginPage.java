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
    private final By passwordExpiredMsg = By.id("com.example.app:id/passwordExpired");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField))
                .clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))
                .clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void tapLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isHomeScreenDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(homeScreen))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPasswordExpiredMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordExpiredMsg))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}