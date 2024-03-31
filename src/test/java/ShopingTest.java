import dev.page.CheckoutFormPage;
import dev.page.LoginPage;
import dev.page.ProductsPage;
import dev.page.ShoppingCart;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ShopingTest extends MainDriver{

    CheckoutFormPage checkoutFormPage;
    LoginPage loginPage;
    ProductsPage productsPage;
    @Test
    public  void testAddtoShopingCart() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");

       loginPage.clickLoginButton();
       productsPage = new ProductsPage(driver);

       productsPage.addProduct();
       productsPage.openShoppingCart();

        ShoppingCart cart = new ShoppingCart(driver);
        assertTrue(cart.isItemAdded());

    }
    @Test
    public  void checkout() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);

        productsPage.addProduct();
        productsPage.openShoppingCart();
        productsPage.checkoutButton();

        assertEquals(productsPage.getPageTitle(),"Checkout: Your Information");
    }

    @Test
    public  void fillCheckoutForm() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);

        productsPage.addProduct();
        productsPage.openShoppingCart();
        productsPage.checkoutButton();

        checkoutFormPage = new CheckoutFormPage(driver);
        checkoutFormPage.setFirstNameField("Svilen");
        checkoutFormPage.setLastNameField("Dimitrov");
        checkoutFormPage.setZipCode("9000");
        checkoutFormPage.clickContinueButton();

        assertEquals(productsPage.getPageTitle(),"Checkout: Overview");
    }

    @Test
    public  void checkFormMissingFirstName() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);

        productsPage.addProduct();
        productsPage.openShoppingCart();
        productsPage.checkoutButton();

        checkoutFormPage = new CheckoutFormPage(driver);
        checkoutFormPage.setFirstNameField("");
        checkoutFormPage.setLastNameField("Dimitrov");
        checkoutFormPage.setZipCode("9000");
        checkoutFormPage.clickContinueButton();

        assertEquals(loginPage.getErrorMessage(), "Error: First Name is required");
    }
    @Test
    public  void checkFormMissingLastName() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);

        productsPage.addProduct();
        productsPage.openShoppingCart();
        productsPage.checkoutButton();

        checkoutFormPage = new CheckoutFormPage(driver);
        checkoutFormPage.setFirstNameField("Svilen");
        checkoutFormPage.setLastNameField("");
        checkoutFormPage.setZipCode("9000");
        checkoutFormPage.clickContinueButton();

        assertEquals(loginPage.getErrorMessage(), "Error: Last Name is required");
    }
    @Test
    public  void checkFormMissingZipCode() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);

        productsPage.addProduct();
        productsPage.openShoppingCart();
        productsPage.checkoutButton();

        checkoutFormPage = new CheckoutFormPage(driver);
        checkoutFormPage.setFirstNameField("Svilen");
        checkoutFormPage.setLastNameField("Dimitrov");
        checkoutFormPage.setZipCode("");
        checkoutFormPage.clickContinueButton();

        assertEquals(loginPage.getErrorMessage(), "Error: Postal Code is required");
    }
    @Test
    public  void finishPurshase() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);

        productsPage.addProduct();
        productsPage.openShoppingCart();
        productsPage.checkoutButton();

        checkoutFormPage = new CheckoutFormPage(driver);
        checkoutFormPage.setFirstNameField("Svilen");
        checkoutFormPage.setLastNameField("Dimitrov");
        checkoutFormPage.setZipCode("9000");
        checkoutFormPage.clickContinueButton();
        checkoutFormPage.clickFinishButton();

        assertEquals(productsPage.getPageTitle(),"Checkout: Complete!");
    }
}
