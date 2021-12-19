package pl.coderslab.seleniumcourse.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QwantSearchSteps {
    private WebDriver driver;

    @Given("^Web page https://www.qwant.com/ opened in browser$")
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get("https://www.qwant.com/");
    }
    @When("^Search phrase \"W pustyni i w puszczy\" entered in search input box$")
    public void enterSearchPhrase() {
        WebElement inputBox = driver.findElement(By.name("q"));
        inputBox.clear();
        inputBox.sendKeys("W pustyni i w puszczy");
    }
    @And("^key enter pressed$")
    public void pressEnter() {
        WebElement inputBox = driver.findElement(By.name("q"));
        inputBox.sendKeys(Keys.ENTER);
    }
    @Then("^First 3 search results titles contain phrase \"W pustyni i w puszczy\"$")
    public void checkSearchResults() {
        List<WebElement> searchResults = driver.findElements(By.cssSelector("div.WebResult-module__container___18c35 a"));
        assertTrue(searchResults.get(0).getText().contains("W pustyni i w puszczy"));
        assertTrue(searchResults.get(1).getText().contains("W pustyni i w puszczy"));
        assertTrue(searchResults.get(2).getText().contains("W pustyni i w puszczy"));
    }
}
