package dev.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    // private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private  WebElement loginButton;

    @FindBy(className = "error-message-container")
    private WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
        //  this.driver = driver;
        //  PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage(driver);
    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public void loginAs(String username, String password){
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }
}