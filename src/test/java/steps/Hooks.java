package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    //use @Before from   io.cucumber.java to import this hook
    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication(); }  // here to open browser and launch application.


    /*here we use special class called scenario class from cucumber
    this class holds the complete information of the execution include: test cases executed,
    the status of the test case, the name of the test case, the time took to execute. */
        @After
    public void postCondition(Scenario scenario) {
            /*here we want to take screenshot if test failed, and we're asking to make a folder and
             name it failed "failed/" and name it the name of the scenario (+ scenario.getName)*/
            byte[] pic;
            if (scenario.isFailed()){
                // failed screenshot will be available inside failed folder
                pic = takeScreenShot("failed/" + scenario.getName());
        }else {
                //// passed screenshot will be available inside passed folder
                pic = takeScreenShot("passed/" + scenario.getName());
            }

                // to attach the screenshot in our report
               scenario.attach(pic,"image/png", scenario.getName());
               // close the browser
               closeBrowser();
    }
}
