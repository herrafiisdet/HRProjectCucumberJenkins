package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("user verify dashboard page")
    public void user_verify_dashboard_page() {
        System.out.println("****** I M HAPPY NOW :) ******");
    }


    //below we are using Table Data values only (not list of maps) see explaination by Sohel cucumberbatch14 v#6 time: 1:40
    @Then("user verify all the dashboard tabs")
    public void user_verify_all_the_dashboard_tabs(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();
        List<String> actualTabs = new ArrayList<>();  // we need ArryList to get the values in order
        for (WebElement ele :dashboard.dashboardTabs){
            actualTabs.add(ele.getText());
        }
        //printing the text for both feature file and from application
        System.out.println(expectedTabs);
        System.out.println(actualTabs);

        //.equals is the methode we use to compare 2 lists together.
        //asserTrue is a boolean condition with returns true if condition is satisfy
        Assert.assertTrue(expectedTabs.equals(actualTabs));


    }
}
