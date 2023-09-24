package PomPages;

import Helpers.WaitForElements;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[@id='react-burger-menu-btn']//self::button")
    @CacheLookup
    WebElement mainBurgerButton;
    @FindBy(how = How.XPATH, using = "//a[@id='logout_sidebar_link']//self::a")
    @CacheLookup
    WebElement logoutButton;

    @FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-bike-light']//self::button")
    WebElement sauceLabsBikeLight;
    @FindBy(how = How.XPATH, using = "//*[@id=\"shopping_cart_container\"]//self::div")
    WebElement shoppingContainer;
    @FindBy(how = How.XPATH, using = "//*[@id=\"item_0_title_link\"]/div")
    WebElement shoppingContainerResult;

    WaitForElements wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitForElements(driver);
    }

    public void clickOnBurgerButton() {
        wait.customWaitForElement(mainBurgerButton, 2);
        mainBurgerButton.click();
    }

    public void clickOnLogoutButton() {
        wait.customWaitForElement(logoutButton, 2);
        logoutButton.click();
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

    public void addProduct() {
        wait.customWaitForElement(sauceLabsBikeLight, 2);
        sauceLabsBikeLight.click();
    }

    public void enterInBasket() {
        wait.customWaitForElement(shoppingContainer, 2);
        shoppingContainer.click();
        Assert.assertEquals("Sauce Labs Bike Light", shoppingContainerResult.getText());
    }


}
