package dev.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutFormPage extends BasePage {
    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement zipCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutFormPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstNameField (String firstName){
      firstNameField.sendKeys(firstName);
    }

    public void setLastNameField (String lastname){
        lastNameField.sendKeys(lastname);
    }
    public void setZipCode (String zipCode){
        zipCodeField.sendKeys(zipCode);
    }
    public void clickContinueButton(){
        continueButton.click();
    }
    public void clickFinishButton(){
        finishButton.click();
    }
}
