# Mobile Automation Framework with Java, Cucumber and Appium

A robust test automation framework for mobile applications using:
- Java
- Cucumber (BDD)
- Appium
- Maven

---

## 📋 Prerequisites

- Java JDK 8+
- Maven 3.6+
- Appium Server 2.x
- Android SDK (for Android) / Xcode (for iOS)
- IDE (IntelliJ recommended)

---

## ⚙️ Setup

1. **Clone the repository:**
   git clone https://github.com/PauloCorbacho/java-cucumber-appium-mobile-outsera.git

2. **Install dependencies:**
   mvn clean install

3. **Configuration**

   Edit src/test/resources/config.properties with your device/app details:

   platformName=Android
   platformVersion=11.0
   deviceName=Pixel_4_API_30
   appPackage=com.example.app
   appActivity=.MainActivity

---

## ▶️ Running Tests

- **Run all tests:**
  mvn test

- **Run tests with specific tag:**
  mvn test -Dcucumber.filter.tags="@smoke"

---

## 📁 Project Structure

src/
├── main/java/
│   ├── pages/        # Page Object classes
│   ├── utils/        # Helper classes
│   └── drivers/      # Appium driver setup
├── test/
│   ├── java/
│   │   ├── runners/  # Test runners
│   │   └── steps/    # Step definitions
│   └── resources/
│       ├── features/ # Cucumber feature files
│       └── config/   # Configuration files

---

## 📊 Reporting

HTML reports are automatically generated at:

target/cucumber-reports/cucumber.html

---

## 🔄 CI/CD Integration

Easily integrable with:

- Jenkins
- GitHub Actions
- CircleCI

---

## ✅ Best Practices

- ✅ Page Object Model pattern
- ✅ BDD approach with Cucumber
- ✅ Environment configuration management
- ✅ Parameterized test execution

---

## 📄 License

MIT License
