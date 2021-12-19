package pl.coderslab.seleniumcourse.cucumber.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {
    @FindBy(id = "#id_gender1")
    private WebElement radioMr;
    @FindBy(css = "input#id_gender2")
    private WebElement radioMrs;
    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "days")
    private WebElement days;
    @FindBy(id = "months")
    private WebElement months;
    @FindBy(id = "years")
    private WebElement years;
    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;
    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public CreateAnAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillForm(UserData userData) {
        if (userData.isMr()) {
            radioMr.click();
        } else {
            radioMrs.click();
        }
        firstNameInput.sendKeys(userData.getFirstName());
        lastNameInput.sendKeys(userData.getLastName());
        if (!userData.getEmail().equals("")) {
            emailInput.clear();
            emailInput.sendKeys(userData.getEmail());
        }
        passwordInput.sendKeys(userData.getPassword());
//        days.sendKeys(String.valueOf(userData.getDays()));
//        months.sendKeys(userData.getMonth().name());
//        years.sendKeys(String.valueOf(userData.getYears()));
        setCheckbox(newsletterCheckbox, userData.isNewsletter());
        setCheckbox(specialOffersCheckbox, userData.isGetSpecialOffers());
    }

    private void setCheckbox(WebElement checkbox, boolean desiredCheckedState) {
        if (checkbox.isSelected() != desiredCheckedState) {
            checkbox.click();
        }
    }

    public void clickRegister() {
        registerButton.click();
    }

    public boolean areMandatoryInputsAccessible() {
        boolean isFirstNameInputInteractable = firstNameInput.isDisplayed() && firstNameInput.isEnabled();
        boolean isLastNameInputInteractable = lastNameInput.isDisplayed() && lastNameInput.isEnabled();
        boolean isPasswordInputInteractable = passwordInput.isDisplayed() && passwordInput.isEnabled();

        return isFirstNameInputInteractable
                && isLastNameInputInteractable
                && isPasswordInputInteractable;
    }

    public String getEmail() {
        return emailInput.getAttribute("value");
    }
}
