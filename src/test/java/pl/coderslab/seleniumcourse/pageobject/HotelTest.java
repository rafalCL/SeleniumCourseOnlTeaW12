package pl.coderslab.seleniumcourse.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.Month;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HotelTest {
    WebDriver driver;

    @Test
    public void shouldCreateNewAccount() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        String randomEmail = UUID.randomUUID() + "@mail.pl";
        loginPage.fillCreateAnAccountEmail(randomEmail);
        loginPage.clickCreateAnAccount();

        UserData userData = new UserData()
                .setFirstName("ala")
                .setLastName("alowska")
                .setMr(false)
                .setEmail("")
                .setPassword("password")
                .setDays(9)
                .setMonth(Month.JANUARY)
                .setYears(2000)
                .setNewsletter(true)
                .setGetSpecialOffers(false);

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        assertTrue(createAnAccountPage.areMandatoryInputsAccessible(), "element not interactable!");
        assertEquals(randomEmail, createAnAccountPage.getEmail());
        createAnAccountPage.fillForm(userData);
        createAnAccountPage.clickRegister();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        assertTrue(myAccountPage.isAccountCreationConfirmed());
    }

    @Test
    public void shouldSearchHotelOnLandingPage() {
        // Sekwencja kroków:
        //
        //logowanie użytkownika : LoginPage.loginAsTestUser() test123@mail.pl
        //wyszukiwarka na stronie głównej
        //wyszukaj dowolny hotel.
        LandingPage lp = new LandingPage(driver);
        lp.searchHotel("","","","");
    }

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

//    @AfterEach
//    public void afterEach() {
//        this.driver.quit();
//    }
}
