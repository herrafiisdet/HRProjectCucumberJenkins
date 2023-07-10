package utils;

import org.apache.log4j.Logger;

public class Log {

    // initialize log4j logs    // this whole log4j option is optional only if the company asked for it)

    public static Logger Log = Logger.getLogger(Log.class.getName());

    //understand the scope
    //if my test case start   it should be printed
    //if my test case end   it should be printed
    //if any message I need in between  it should be printed

    public static void startTestCase (String testCaseName){
        Log.info("**********************************************");
        Log.info("**********************************************");
        Log.info("################### "+testCaseName+" ####################");
        Log.info("**********************************************");
        Log.info("**********************************************");
    }

    public static void endTestCase(String testCaseName){
        Log.info("###############################################");
        Log.info("###############################################");
        Log.info("################### "+testCaseName+" ####################");
        Log.info("###############################################");
        Log.info("###############################################");

    }

    //to print some text in between my code
    public static void info(String message){
        Log.info(message);
    }

    public static void warning(String warning){
        Log.info(warning);
    }

}

