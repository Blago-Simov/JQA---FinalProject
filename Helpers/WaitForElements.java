package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForElements {

    public WebDriver driver;
    public WebDriverWait wait;

    public WaitForElements(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(WebElement element, long timeOfSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void customWaitForElement(WebElement el, long timeOfSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until((ExpectedCondition<Boolean>) driver -> {
            WebElement element;
            element = (el);
            if (element != null) {
                return element.isEnabled() && element.isDisplayed();
            }
            return false;
        });

    }

}
