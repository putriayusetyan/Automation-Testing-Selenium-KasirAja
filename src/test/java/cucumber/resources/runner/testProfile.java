package cucumber.resources.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/cucumber/resources/features/profile.feature",
            glue = "cucumber.resources.runner.stepDef" ,
            plugin = {"html:target/HTML_reportProfile.html"}
    )

    public class testProfile{

    }

