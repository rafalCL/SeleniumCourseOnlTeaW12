package pl.coderslab.seleniumcourse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJunitSeleniumTest {
    WebDriver driver;

    @Test
    public void shouldSearchInQwant() {
        driver.get("https://www.qwant.com/");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("coders lab");
        searchInput.submit();
    }

    @Test
    public void shouldSearchInDuckDuckGo() {
        driver.get("https://duckduckgo.com/");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("kawalerowicz faraon");
        searchInput.submit();
    }

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
    }
}
