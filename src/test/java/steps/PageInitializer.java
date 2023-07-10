package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;

public class PageInitializer {

    public static LoginPage login;  // create object  "login" is the object name for the "LoginPage" class.
    public static DashboardPage dashboard;
    public static AddEmployeePage addEmployee;
    public static EmployeeListPage employeeList;


    public static void initializePageObjects() {  // and this is the method to initialize the object "login"
        login = new LoginPage();
        //now we need to go to "CommonMethods" class and "inherent" this class using "Extends"
        // keyword to inherent PageInitializer (Extends PageInitializer)  and call the "initializePageObjects"
        // method on our first Method which is openBrowserAndLunchApplication method at the end right after lunching the application.
        dashboard = new DashboardPage();
        addEmployee =new AddEmployeePage();
        employeeList = new EmployeeListPage();


    }
}
