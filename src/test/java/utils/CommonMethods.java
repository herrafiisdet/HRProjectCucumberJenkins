package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;


    //*************************************** openBrowserAndLaunchApplication & closeBrowser  *************************************
    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                //WebDriverManager.chromedriver().setup(); // not needed with the new Selenium version 4.9

                ChromeOptions ops = new ChromeOptions();  // this line needed for Jenkins job
                ops.addArguments("--no-sandbox");         // this line needed for Jenkins job
                ops.addArguments("--remote-allow-origins=*");  // this line needed for Jenkins job
                if(ConfigReader.getPropertyValue("Headless").equals("true")){   // this line needed for Jenkins job
                    ops.addArguments("--headless=new");   // this line needed for Jenkins job
                }
                driver = new ChromeDriver(ops);  // (ops) needed for Jenkins job
                break;

            case "firefox":
                //WebDriverManager.firefoxdriver().setup(); // not needed with the new Selenium version 4.9
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

        //using inherent to initialize PageInitiliazer class from steps package
        initializePageObjects();

        // *******  here below is the code for the log files  log4j
        // to configure the file and pattern of it, we need to call the file.
        DOMConfigurator.configure("log4j.xml");   // log4j
        Log.startTestCase("My first test case is Login test"); // log4j
        Log.info("My login test is going on"); // log4j
        Log.warning("My test case might be failed"); // log4j
    }
        public static void closeBrowser(){
        // here the Log4j  Methode for after closing browser
            Log.info("My test case is about to complete"); // log4j
            Log.endTestCase("This is my login test again"); // log4j
        driver.quit();
    }

    //************************************************ sendText ***************************************************
    //we use this method instead of send keys method throughout the framework.
    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    //***************************************** getWait / WebdriverWait *******************************************
    //to get webdriver wait
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }

     //***************************************** waitForClickability **********************************************
     //this method will wait for the element to be clickable
        public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        }

    //************************************************** click ****************************************************
    //this method will perform click operation but before perform click, it will wait
    //for the element to be clickable
    public static void click (WebElement element){
        waitForClickability(element);
        element.click();
    }

    //************************************************ getJSExecutor **********************************************
    //this method will return JavascriptExecutor object
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    //************************************************* jsClick ***************************************************
    //this function will perform "click" on element using javascript executor
    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    //******************************************* selectDropdown-usingText ****************************************
    //selecting the dropdown using text
    public static void selectDropdown(WebElement element, String text){
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }

    //*******************************************@@@ screenshots @@@****************************************
// *** important information : cucumber always accept array of byte =>  " byte[]" for screenshots.

    public static byte[] takeScreenShot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte [] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + " " + getTimeStamp("MM-dd-yyyy-HH-mm-ss") + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return picBytes;
        }

        public static String getTimeStamp(String pattern){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
    }



}
