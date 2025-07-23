package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MenuPage {
    private final AndroidDriver driver;

    private final By menuList = By.id("android:id/list");
    private final By menuItems = By.className("android.widget.TextView");

    public MenuPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectMenu(String menuName) {
        driver.findElements(menuItems)
                .stream()
                .filter(e -> e.getText().equals(menuName))
                .findFirst()
                .orElseThrow()
                .click();
    }

    public boolean isTextDisplayed(String text) {
        return driver.findElement(By.xpath("//*[contains(@text, '" + text + "')]")).isDisplayed();
    }
}