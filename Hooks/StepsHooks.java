package Hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class StepsHooks {
    private WebDriver driver;

    public void SetUpDriver(String browserName) {

        switch (browserName) {
            case "Chrome":
                System.setProperty("web-driver.chrome.driver", "E:\\installers\\drivers\\Chromedriver\\chromedriver.exe");
                driver = new ChromeDriver();
            case "Firefox":
                System.setProperty("web-driver.gecko.driver", "E:\\installers\\drivers\\geckodriver-v0.27.0-win64\\geckodriver");
                driver = new FirefoxDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }


    public void CloseDriver() {
        driver.quit();
    }


    public WebDriver getDriver() {
        return driver;
    }
}
