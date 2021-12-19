package pl.coderslab.seleniumcourse.cucumber.pageobject;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/hotel-create-account.feature",
        plugin = {"pretty","html:out"})
public class HotelRegisterUserTest {
}
