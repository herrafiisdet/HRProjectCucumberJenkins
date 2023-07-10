package utils;

// this class is created under utils to read data from testdata directory/package. will call it excelreader
// because anything under resources directory is not java, its data and we need a reader

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    static Workbook book;
    static Sheet sheet;  // it could be more then one sheet in a workbook.


// 1- this method for opening the excel file
    public static void openExcel (String filePath){     // so first of all we need to open the Excel file (so we named the methode "openExcel".
        // and method asking which excel file need to open? so i said : file path take this file path to open (String filepath)
        // and the path already provided in constants class (TESTDATA_FILEPATH)
        try {
            FileInputStream fis =new FileInputStream(filePath); // fis = file input stream  means here the file is coming from the "filePath"
            book = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

// 2- this method for opening the sheet
    public static void getSheet(String sheetName){
        sheet = book.getSheet(sheetName);
    }

// 3- this method for get rows count
    public static int getRowCount(){
        return  sheet.getPhysicalNumberOfRows();
    }

// 4- this method for get column count
    public static int getColsCount(int rowIndex){
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

// 5- this method to get the cell data in string format

    public static String getCellData(int rowIndex, int colIndex){
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }

// 6- this method will return list of maps having all the data from excel file

    public static List<Map<String, String>> excelListIntoMap
            (String filePath, String sheetName){
        openExcel(filePath);
        getSheet(sheetName);

// creating a list of maps for all the rows
        List<Map<String, String>> listData = new ArrayList<>();

// loops - outer loop is always take care of rows
        for (int row=1; row<getRowCount();row++){

            // creating a map for every row
            Map<String,String> map = new LinkedHashMap<>();

            for(int col=0; col<getColsCount(row); col++){
                map.put(getCellData(0,col),getCellData(row,col));
            }
            listData.add(map);
        }
    return listData;
    }

}
