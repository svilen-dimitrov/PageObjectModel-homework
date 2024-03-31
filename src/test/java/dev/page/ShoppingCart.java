package dev.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import java.util.List;

public class ShoppingCart extends BasePage {
    @FindBy(css = ".cart_button")
    private List<WebElement> listofRemoveButtons;


    public ShoppingCart(WebDriver driver){

        super(driver);
    }

    public boolean isItemAdded(){
     return listofRemoveButtons.size() != 0;
    }
}
