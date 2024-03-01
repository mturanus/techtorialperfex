package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//it means run cucumber classes
@CucumberOptions(//It is an annotation that has some special keywords
        features = "/src/test/resources/features",//this is the location of features files but we provide folder
        glue= "src/test/java/stepdefinitions",//this is the location of step definitions classes,but we provide folders(stepdefinitions)
        dryRun = false,//a way to get snips without executing the steps
        tags = "@regression",//a way to filter your test cases based on the request(smoke or regression)
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}

)

public class Runner {

}

