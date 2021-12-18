package pl.coderslab.seleniumcourse.pageobject;

// this is our first implementation of Page Object Pattern

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        WebElement signInBtn = driver.findElement(By.className("hide_xs"));
        signInBtn.click();
    }
}
