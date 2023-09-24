package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:/Projects/SeleniumCucumber/src/test/java/Features/Login.feature",
        glue = "Steps",
        tags = "@smoke or @sanity",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"})

public class TestRunner {
}
