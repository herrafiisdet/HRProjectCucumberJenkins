package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        //WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        //pimOption.click();
        click(dashboard.pimOption);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        // WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
        // addEmployeeOption.click();
        click(dashboard.addEmployeeOption);
    }
//*******************************************@@@ using hardcoded data @@@**********************************************
    // # 1- parameters passing using hardcoded data

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        // WebElement firstName = driver.findElement(By.id("firstName"));
        // firstName.sendKeys("Hassan");
        sendText(addEmployee.firstNameField, "joshapn");
        sendText(addEmployee.lastNameField, "Heraro");
        // WebElement lastName = driver.findElement(By.id("lastName"));
        // lastName.sendKeys("Errafii");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //WebElement saveButton = driver.findElement(By.id("btnSave"));
        //saveButton.click();
        click(addEmployee.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("***** Employee Added successfully ******");
    }

//*********************************@@@ passing one set of data from feature file @@@***********************************
    //# 2- parameters passing by passing one set of data from feature file

    @When("user enters {string} and {string}")
    public void user_enters_and(String firstName, String lastName) {
        sendText(addEmployee.firstNameField, firstName);
        sendText(addEmployee.lastNameField, lastName);
    }

//**************************************@@@ scenario outline -Example table @@@****************************************
    // 3- parameters passing using scenario outline -Example table:for passing multiple data sets.

    @When("user  enters {string} and {string} for adding multiple employees")
    public void user_enters_and_for_adding_multiple_employees(String firstNameValue, String lastNameValue) {
        sendText(addEmployee.firstNameField, firstNameValue);
        sendText(addEmployee.lastNameField, lastNameValue);
    }

    //**********************************************@@@ using Data table @@@**********************************************

//# 4- parameters passing using Data table : here hooks and background execute one time for multiple data sets.

    @When("user adds multiple employees and verify they are added successfully")
    public void user_adds_multiple_employees_and_verify_they_are_added_successfully(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        //getting the map from list of maps
        for (Map<String, String> employee : employeeNames) {
            //getting the keys and values from every map
            String firstNameValue = employee.get("firstName");
            String middleNameValue = employee.get("middleName");
            String lastNameValue = employee.get("lastName");

            sendText(addEmployee.firstNameField, firstNameValue);
            sendText(addEmployee.middleNameField, middleNameValue);
            sendText(addEmployee.lastNameField, lastNameValue);

            click(addEmployee.saveButton);
            Thread.sleep(2000);

            //till this point one employee has been added

            //verifying the employee is homework
            click(dashboard.addEmployeeOption);
            Thread.sleep(2000);
        }
    }

//*********************************@@@ using Excel file to Add multiple employees @@@**********************************

        /*@When("user adds multiple employee from excel using {string} and verify it")
        public void user_adds_multiple_employee_from_excel_using_and_verify_it(String sheetName) throws InterruptedException {

        List<Map<String, String>> empFromExcel = ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH,sheetName);

            //it returns one map from list of maps
            Iterator<Map<String,String>> itr = empFromExcel.iterator();
            while (itr.hasNext()){

                //it returns the key and value for employee from excel
                Map<String, String> mapNewEmp = itr.next();

                sendText(addEmployee.firstNameField,mapNewEmp.get("firstName"));
                sendText(addEmployee.middleNameField, mapNewEmp.get("middleName"));
                sendText(addEmployee.lastNameField, mapNewEmp.get("lastName"));
/* For Validation/Assertion: So here after entering username and password and conform password above Here will
                 get the EmployeeID (copy and save the Employee Id number) from the add employ page,
                 so we can use later to validate/verify the data was entered correctly and saved*/
/*                String empIdValue = addEmployee.empIdLocator.getAttribute("value");
                sendText(addEmployee.photograph,mapNewEmp.get("photograph"));
                if(!addEmployee.checkBox.isSelected()){
                    click(addEmployee.checkBox);
                }
                sendText(addEmployee.createusernameField,mapNewEmp.get("username"));
                sendText(addEmployee.createpasswordField,mapNewEmp.get("password"));
                sendText(addEmployee.confirmpasswordField, mapNewEmp.get("confirmPassword"));

//@@@@@@@***********  Validation of data ************@@@@@@@

                click(addEmployee.saveButton);
                System.out.println("save button clicked");

                Thread.sleep(3000);
                click(dashboard.empListOption);
                Thread.sleep(2000);
                System.out.println("emp list option clicked");

/*  For Validation/Assertion:  Now after we entered a new employee, we need to verify and validate that the employee is in
                 database and that the ID number, first name, middle name, and last name, all are there and correct.
                 so to do that we will need to search the employee, by using the employeeid that we captured from attribute*/
/*
                // search the employee, using employeeid we captured from attribute.
                sendText(employeeList.empSearchIdField,empIdValue);
                click(employeeList.searchButton);

                //verifying the employee added from the Excel file
                List<WebElement> rowData = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));

                for (int i = 0; i < rowData.size(); i++){
                    System.out.println("I am inside the loop");
                    //getting the text of every element from here(page) and storing in into string
                    String rowText = rowData.get(i).getText();
                    System.out.println(rowText);

                    String expectedData = empIdValue + " " + mapNewEmp.get("firstName") + " " + mapNewEmp.get("middleName") + " " + mapNewEmp.get("lastName");

                    //verifying the exact details of the employee
                    Assert.assertEquals(expectedData,rowText);
                }

                click(dashboard.addEmployeeOption);
                Thread.sleep(2000);
            }
            */


    @When("user adds multiple employee from excel using {string} and verify it")
    public void user_adds_multiple_employee_from_excel_using_and_verify_it(String sheetName) throws InterruptedException {

        List<Map<String, String>> empFromExcel = ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH, sheetName);


        //it returns one map from list of maps
        Iterator<Map<String, String>> itr = empFromExcel.iterator();
        while (itr.hasNext()) {
            //it returns the key and value for employee from excel
            Map<String, String> mapNewEmp = itr.next();

            sendText(addEmployee.firstNameField, mapNewEmp.get("firstName"));
            sendText(addEmployee.middleNameField, mapNewEmp.get("middleName"));
            sendText(addEmployee.lastNameField, mapNewEmp.get("lastName"));
            String empIdValue = addEmployee.empIdLocator.getAttribute("value");
            //sendText(addEmployee.photograph, mapNewEmp.get("photograph"));     // i skipped this line until i find a way to use the picture.
            if (!addEmployee.checkBox.isSelected()) {
                click(addEmployee.checkBox);
            }
            sendText(addEmployee.createusernameField, mapNewEmp.get("username"));
            sendText(addEmployee.createpasswordField, mapNewEmp.get("password"));
            sendText(addEmployee.confirmpasswordField, mapNewEmp.get("confirmPassword"));

            click(addEmployee.saveButton);
            System.out.println("click taken on save button");
            //verification is in home-work
            Thread.sleep(1000);

            click(dashboard.empListOption);
            Thread.sleep(1000);
            System.out.println("click taken on emp list option");

            //to search the employee, we use emp id what we captured from attribute
            sendText(employeeList.empSearchIdField, empIdValue);
            click(employeeList.searchButton);

            //verifying the employee added from the excel file

            List<WebElement> rowData = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));


            for (int i = 0; i < rowData.size(); i++) {
                System.out.println("I am inside the loop and worried about josh");
                //getting the text of every element from here and storing it into string
                String rowText = rowData.get(i).getText();
                System.out.println(rowText);

                String expectedData = empIdValue + " " + mapNewEmp.get("firstName") + " " + mapNewEmp.get("middleName") + " " + mapNewEmp.get("lastName");

                //verifying the exact details  of the employee
                Assert.assertEquals(expectedData, rowText);

            }

            click(dashboard.addEmployeeOption);
            Thread.sleep(1000);


        }


    }
}
