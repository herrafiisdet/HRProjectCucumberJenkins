package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import javax.xml.xpath.XPath;
import java.util.List;

public class DashboardPage extends CommonMethods {
    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement empListOption;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeeOption;

    @FindBy(id = "welcome")
    public WebElement welcomeAdminMessage;

    @FindBy(xpath = "//div[@class='menu']/ul/li")
    public List<WebElement>dashboardTabs;


    // now here create a constructor of DashBoardPage to utilize this page
    public DashboardPage(){
        PageFactory.initElements(driver,this); // and here we call inside this constructor PageFactory.initElements(driver,this)


    }



}
