package pl.coderslab.seleniumcourse.cucumber.pageobject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HotelRegisterUserSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private CreateAnAccountPage createAnAccountPage;
    private String randomEmail;

    @Given("^Login page opened: (.*)$")
    public void loginPageOpened(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.get(url);
    }

    @When("^Unique email entered in 'email address' input box$")
    public void uniqueEmailEntered() {
        this.loginPage = new LoginPage(driver);
        this.randomEmail = UUID.randomUUID() + "@mail.pl";
        loginPage.fillCreateAnAccountEmail(randomEmail);
    }

    @And("^Create an account button clicked$")
    public void clickCreateAccount() {
        loginPage.clickCreateAnAccount();
    }

    @And("^Form filled with data: (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void fillForm(String firstName, String lastName, boolean isMr, String password, boolean isNewsletter, boolean isSpecialOffers) {
        UserData userData = new UserData()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMr(isMr)
                .setEmail("")
                .setPassword(password)
                .setNewsletter(isNewsletter)
                .setGetSpecialOffers(isSpecialOffers);

        this.createAnAccountPage = new CreateAnAccountPage(driver);
        assertTrue(createAnAccountPage.areMandatoryInputsAccessible(), "element not interactable!");
        assertEquals(randomEmail, createAnAccountPage.getEmail());
        createAnAccountPage.fillForm(userData);
    }

    @And("^Register button clicked$")
    public void clickRegisterButton() {
        createAnAccountPage.clickRegister();
    }

    @Then("^User account creation success confirmation panel displayed$")
    public void accountCreationConfirmed() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        assertTrue(myAccountPage.isAccountCreationConfirmed());
    }

    @And("Take screenshot")
    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
//Take screenshot (will be saved in default location) and automatically removed after test
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
//Copy the screenshot to desired location
//Path to the location to save screenshot
//(directory for screenshots MUST exist: C:\test-evidence) e.g.:
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "registration-success-evidence-12-"+currentDateTime+".png"));
    }

    @And("Close browser")
    public void closeBrowser() {
        this.driver.quit();
    }
}
