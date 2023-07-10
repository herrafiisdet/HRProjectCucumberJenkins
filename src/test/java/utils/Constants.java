package utils;


// this class holds all the baths we use in this framework ( needs more explanation . why? )


public class Constants {
    public static final String CONFIGURATION_FILEPATH =
            System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    public static final int EXPLICIT_WAIT = 10;
    public static final int IMPLICIT_WAIT = 10;

// Adding the PATH of the Excel file. to use Excel for Data driving testing.
        public static final String TESTDATA_FILEPATH =
            System.getProperty("user.dir") + "/src/test/resources/testdata/EmployeesExcel.xlsx";  // this is the path where the Excel file is located.

//

        public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir") + "/screenshot/";




}
