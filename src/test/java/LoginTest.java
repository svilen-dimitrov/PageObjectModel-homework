import dev.page.LoginPage;
import dev.page.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends MainDriver{

    LoginPage loginPage;
    ProductsPage productsPage;
@Test
    public  void testSuccessfulLogin() {
    loginPage = new LoginPage(driver);
    loginPage.setUsername("standard_user");
    loginPage.setPassword("secret_sauce");

    productsPage = loginPage.clickLoginButton();
   assertEquals(productsPage.getPageTitle(),"Products");
}

    @Test
    public void testLoginMissingUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }
}
