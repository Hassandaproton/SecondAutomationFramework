package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json","rerun:target/rerun.txt"} ,
        features = "C:\\Users\\hassa\\IdeaProjects\\ProjectCucumberFramework\\src\\test\\resources\\features",
        glue = "steps",
        dryRun = false,
        tags = "@insurance"
)
public class Runner {
}
