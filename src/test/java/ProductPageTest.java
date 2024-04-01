import dev.page.LoginPage;
import dev.page.ProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends MainDriver{
    private ProductsPage productsPage;

    @BeforeMethod
    public void loginBefore(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");
    }
    @Test
    public void canOpenCartPage() {
        productsPage = new ProductsPage(driver);
        productsPage.header().openCartPageByIcon();
    }
}
