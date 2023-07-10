package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    @FindBy(xpath = "//*[@id='txtUsername']")
    public WebElement usernameTextField;

    @FindBy(id = "txtPassword")
    public WebElement passwordTextField;

    @FindBy(xpath ="//*[@id='btnLogin']")
    public WebElement loginButton;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;

    public LoginPage(){

        PageFactory.initElements(driver,this);   //call selenium page factory
        //page factory is the concept of selenium which we use to implement page
        // object model design pattern which is responsible to initialize all the objects
        //of the class. here when we say objects, we mean locators what we also call
        //object repository.
        //if someone ask this to you in the interview you have to write the same thing

    }

}
