package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;

public class AppConfig {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options()
                        .setDeviceName("emulator-5554")
                        .setAppPackage("com.example.app")
                        .setAppActivity(".LoginActivity")
                        .setAutomationName("UiAutomator2")
                        .setNoReset(true);

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize driver", e);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
