package Utils;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UtilsCSV
{
    public static String csvReadPages = "src/test/resources/Pages.csv";
    public static String csvWritePages1 = "src/test/resources/PagesTestResults.csv";
    public static String csvWritePages2 = "src/test/resources/200PagesTestResults.csv";
    public static String csvUserData = "src/test/resources/UserData.csv";
    public static String csvRequestData = "src/test/resources/RequestData.csv";

    public static CSVReader readCSV(String csvReadPath) throws IOException
    {
       return new CSVReader(new FileReader(csvReadPath));
    }

    public static CSVWriter writeCSV(String csvWritePath) throws IOException
    {
        return new CSVWriter(new FileWriter(csvWritePath));
    }
}
