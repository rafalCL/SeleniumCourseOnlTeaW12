package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAnAccountPage {
    private WebDriver driver;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(UserData userData) {
        WebElement radioMr = driver.findElement(By.cssSelector("input#id_gender1"));
        WebElement radioMrs = driver.findElement(By.cssSelector("input#id_gender2"));
        if (userData.isMr()) {
            radioMr.click();
        } else {
            radioMrs.click();
        }

        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        firstNameInput.sendKeys(userData.getFirstName());
        WebElement lastNameInput = driver.findElement(By.id("customer_lastname"));
        lastNameInput.sendKeys(userData.getLastName());

        WebElement emailInput = driver.findElement(By.id("email"));
        if (!userData.getEmail().equals("")) {
            emailInput.sendKeys(userData.getEmail());
        }

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys(userData.getPassword());
        WebElement days = driver.findElement(By.id("days"));
        days.sendKeys(String.valueOf(userData.getDays()));
        WebElement months = driver.findElement(By.id("months"));
        months.sendKeys(userData.getMonth().name());
        WebElement years = driver.findElement(By.id("years"));
        years.sendKeys(String.valueOf(userData.getYears()));
        WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
        setCheckbox(newsletterCheckbox, userData.isNewsletter());
        WebElement specialOffersCheckbox = driver.findElement(By.id("optin"));
        setCheckbox(specialOffersCheckbox, userData.isGetSpecialOffers());
    }

    private void setCheckbox(WebElement checkbox, boolean desiredCheckedState) {
        if (checkbox.isSelected() != desiredCheckedState) {
            checkbox.click();
        }
    }

    public void clickRegister() {
        WebElement submit = driver.findElement(By.id("submitAccount"));
        submit.click();
    }
}
