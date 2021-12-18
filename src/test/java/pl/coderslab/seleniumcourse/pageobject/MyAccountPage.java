package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountCreationConfirmed() {
        WebElement accountCreationConfirmationPanel = driver.findElement(By.cssSelector("p.alert-success"));
        String confirmationText = accountCreationConfirmationPanel.getText();

        return confirmationText.equals("Your account has been created.");
    }
}
