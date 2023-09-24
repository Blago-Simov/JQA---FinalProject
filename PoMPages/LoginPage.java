package PomPages;


import Helpers.WaitForElements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='user-name']/self::input")
    @CacheLookup
    WebElement userName;
    @FindBy(how = How.XPATH, using = "//input[@id='password']/self::input")
    @CacheLookup
    WebElement password;
    @FindBy(how = How.XPATH, using = "//input[@id='login-button']//self::input")
    WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]//form[1]/div[3]/h3[1]//self::h3")
    WebElement errorMessageTextField;
    WaitForElements wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitForElements(driver);
    }


    public void enterUsername(String name) {
        userName.clear();
        wait.customWaitForElement(userName, 2);
        userName.sendKeys(name);
    }

    public void enterPassword(String pass) {
        password.clear();
        wait.customWaitForElement(password, 2);
        password.sendKeys(pass);
    }

    public void clicksOnLogin() {
        wait.customWaitForElement(loginButton, 2);
        loginButton.sendKeys(Keys.ENTER);

    }

    public String getErrorMessage() {
        return errorMessageTextField.getText();
    }


}
