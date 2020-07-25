package Tests;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UtilsCSV
{
    static String csvReadPath = "src/test/resources/Pages.csv";
    static String csvWritePath1 = "src/test/resources/PagesTestResults.csv";
    static String csvWritePath2 = "src/test/resources/200PagesTestResults.csv";

    public static CSVReader readCSV(String csvReadPath) throws IOException
    {
        return new CSVReader(new FileReader(csvReadPath));
    }

    public static CSVWriter writeCSV(String csvWritePath) throws IOException
    {
        return new CSVWriter(new FileWriter(csvWritePath));
    }
}
