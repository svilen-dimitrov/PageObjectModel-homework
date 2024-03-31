package dev.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    private WebDriver driver;

    // Assuming there's an element to verify on the Products page, like a header
    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement item;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement ShopingCartBadge;

    @FindBy(id = "checkout")
    private WebElement checkout;

    @FindBy(css = ".title")
    WebElement yourInformationText;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void addProduct(){
        item.click();
    }
   public void openShoppingCart(){
        ShopingCartBadge.click();
    }
    public void checkoutButton(){
        checkout.click();
    }

}
