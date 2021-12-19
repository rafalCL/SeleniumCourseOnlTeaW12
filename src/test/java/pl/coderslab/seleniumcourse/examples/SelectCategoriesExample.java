package pl.coderslab.seleniumcourse.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SelectCategoriesExample {
    WebDriver driver;

    @Test
    public void shouldClickCategory() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?id_category=3&controller=category");
        WebElement categoriesHeader = driver.findElement(By.xpath("//section/p[text() = 'Categories']"));
        WebElement categoriesSection = categoriesHeader.findElement(By.xpath("./.."));
        List<WebElement> categories = categoriesSection.findElements(By.cssSelector("li"));
        categories.get(0).click(); // click men category
        // categories.get(1).click(); // click women category
    }

    @Test
    public void shouldClickCategoryCompactedXpath() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?id_category=3&controller=category");
        List<WebElement> categories = driver.findElements(By.xpath("//section/p[text() = 'Categories']/..//li"));
        categories.get(1).click(); // click women category
    }

    @Test
    public void shouldClickSizes() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?id_category=3&controller=category");
        List<WebElement> sizes = driver.findElements(By.xpath("//section/p[text() = 'Size']/..//li"));
        sizes.get(0).click(); // click S
        sizes.get(2).click(); // click L
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
