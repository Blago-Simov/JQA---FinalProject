package PomPages;

import Helpers.WaitForElements;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[@id='react-burger-menu-btn']//self::button")
    @CacheLookup
    WebElement mainBurgerButton;
    @FindBy(how = How.XPATH, using = "//a[@id='logout_sidebar_link']//self::a")
    @CacheLookup
    WebElement logoutButton;

    @FindBy(how = How.XPATH, using = "//*[@class='inventory_list']//child::div[2][@class = 'pricebar']/button")
    @CacheLookup
    WebElement firstElAddToCartButton;

    @FindBy(how = How.XPATH, using = "//div[@id='shopping_cart_container']")
    @CacheLookup
    WebElement shoppingCart;
    @FindBy(how = How.XPATH, using = "//div[@class = 'cart_quantity']/self::div")
    @CacheLookup
    WebElement shoppingCartQuantity ;
    @FindBy(how = How.XPATH, using = "//div[@class = 'inventory_item_name']/self::div")
    @CacheLookup
    WebElement shoppingCartInventoryName ;

    @FindBy(how = How.XPATH, using = "//button[@id='continue-shopping']//self::button")
    @CacheLookup
    WebElement continueShopping   ;
    @FindBy(how = How.XPATH, using = "//button[@id='remove-sauce-labs-backpack']//self::button")
    @CacheLookup
    WebElement shoppingCartRemoveButton  ;


    WaitForElements wait;

    public MainPage(WebDriver driver) {
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

   public void addToCart(){
        wait.customWaitForElement(firstElAddToCartButton,2);
        firstElAddToCartButton.click();
   }

    public void clickOnShoppingCart(){
        wait.customWaitForElement(shoppingCart,2);
        shoppingCart.click();
    }


   public String getShoppingCartQuantity(){
        wait.customWaitForElement(shoppingCartQuantity,2);
        return  shoppingCartQuantity.getText();
   }

    public String getShoppingCartInventoryName(){
        wait.customWaitForElement(shoppingCartInventoryName,2);
        return  shoppingCartInventoryName.getText();
    }

    public void clickOnRemoveItemButton(){
        wait.customWaitForElement(shoppingCartRemoveButton,2);
        shoppingCartRemoveButton.click();
    }

    public void clickOnContinueShoppingButton(){
        wait.customWaitForElement(continueShopping,2);
        continueShopping.click();
    }

}
  
