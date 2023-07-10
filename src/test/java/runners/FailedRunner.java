package runners;

// this runner class is responsible to run only failed cases

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "@target/failed.txt",   // this is the path to the file.txt under target
        glue = "steps",
        // dryRun = false, // we dont need dryRun
       // tags = "@tc100", // we dont need dryRun
        //to remove irrelevant information from console, you need to set monochrome to true
        monochrome = true,
        //pretty keywords prints the steps in the console to increase readability

        plugin = {"pretty"} // to keep execution details in the console


)
public class FailedRunner {
}
