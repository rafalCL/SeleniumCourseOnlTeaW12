package pl.coderslab.seleniumcourse.cucumber.pageobject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
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

//    @AfterEach
//    public void afterEach() {
//        this.driver.quit();
//    }
}
