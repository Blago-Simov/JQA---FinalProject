package Steps;


import Hooks.StepsHooks;
import PomPages.LoginPage;
import PomPages.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class LoginSteps {


    LoginPage loginPage;

    MainPage productPage;

    StepsHooks stepsHooks;

    @Before
    public void initDriver() {
        stepsHooks = new StepsHooks();
        stepsHooks.SetUpDriver("Firefox");
    }

    @Given("user has been on login page")
    public void userHasBeenOnLoginPage() {
        stepsHooks.getDriver().get("https://www.saucedemo.com");
        stepsHooks.getDriver().manage().deleteAllCookies();
        stepsHooks.getDriver().manage().window().maximize();
    }

    @When("^user enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage(stepsHooks.getDriver());
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("user clicks on loginButton")
    public void userClicksOnLoginButton() {
        loginPage.clicksOnLogin();
        Assert.assertEquals("Swag Labs", stepsHooks.getDriver().getTitle());
    }

    @Then("user is redirected to main page")
    public void userIsRedirectedToMainPage() {
        Assert.assertEquals("Swag Labs", stepsHooks.getDriver().getTitle());
    }

    @When("user clicks on logout button")
    public void userClicksOnLogoutButton() {
        productPage = new MainPage(stepsHooks.getDriver());
        productPage.clickOnBurgerButton();

    }

    @Then("user is redirected to login page")
    public void userIsRedirectedToLoginPage() {
        productPage.clickOnLogoutButton();
        Assert.assertEquals("Swag Labs", stepsHooks.getDriver().getTitle());
    }

    @When("user clicks on login")
    public void userClicksOnLogin() {
        loginPage = new LoginPage(stepsHooks.getDriver());
        loginPage.clicksOnLogin();
    }

    @Then("error message appears")
    public void errorMessageAppears() {
        Assert.assertEquals
                ("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
    }


    @And("user clicks on button add to cart")
    public void userClicksOnButtonAddToCart() {
        productPage = new MainPage(stepsHooks.getDriver());
        productPage.addToCart();
    }
    @Then("user is redirected to shopping basket")
    public void userIsRedirectedToShoppingBasket() {
        productPage.clickOnShoppingCart();
    }
    @And("user can see that product have been added to shopping basket")
    public void userCanSeeThatProductHasBeenAddedToShoppingBasket() {

        Assert.assertEquals("1", productPage.getShoppingCartQuantity());
        Assert.assertEquals("Sauce Labs Backpack", productPage.getShoppingCartInventoryName());

        productPage.clickOnRemoveItemButton();
        productPage.clickOnContinueShoppingButton();


    }
    @After
    public void CloseDriver() {
        stepsHooks.CloseDriver();
    }


}
  
