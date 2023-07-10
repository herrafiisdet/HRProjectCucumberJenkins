/*package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "src/test/resources/features",
        glue = "steps",

        //when you set dryRun to true, it stops actual execution
        //it will quickly scan all the gherkin steps whether they are implemented or not
        //when we set dryRun to false, it starts execution again
        //dryRun = true,
        dryRun = false,
        tags = "@regression",
        //to remove irrelevant information from console, you need to set monochrome to true
        monochrome = true,
        //pretty keywords prints the steps in the console to increase readability

        //to generate the reports  we need plugin of runner class
        //when we generate any report this need to be under target folder.
        // "html:target/cucumber.html" this line is the one will create automatically a file/path under target folder
        // "json:target/cucumber.json" this line is the one will create automatically a file/path under target folder
        // to open the Html report => right click on cucumber.html file under target folder, then select open in => chrome

        plugin = {"pretty", "html:target/cucumberRegressionRunner.html", "json:target/cucumberRegressionRunner.json"}

)
public class RegressionRunner {

}
*/