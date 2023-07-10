package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {

    @When("user clicks on EmployeeList option")
    public void user_clicks_on_employee_list_option() {
    //WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
    //click(empListOption);
        click(dashboard.empListOption);
    }

    @When("user enter valid employee id")
    public void user_enter_valid_employee_id() {
       // WebElement empIdField = driver.findElement(By.id("empsearch_id"));
        //sendText(empIdField,"9133104");
        sendText(employeeList.empSearchIdField, "9133104");
        //another way using config.properties
       // sendText(empIdField, ConfigReader.getPropertyValue("empId"));

    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        //WebElement searchButton = driver.findElement(By.id("searchBtn"));
        //click(searchButton);
        click(employeeList.searchButton);


    }
    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("@@******** Employee information can be Seen *********@@");
    }

    @When("user enter valid employee name")
    public void user_enter_valid_employee_name() {
       //WebElement empNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
       //sendText(empNameField,"Ilya");
        sendText(employeeList.empSearchNameField, "Ilya");
       //or we can use
        //sendText(empNameField,ConfigReader.getPropertyValue("empNameField"));
    }
}
