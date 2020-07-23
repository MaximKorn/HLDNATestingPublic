package Tests;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UtilsCSV
{
    static String CSVReadPath = "src/test/resources/Pages.csv";
    static String CSVWritePath = "src/test/resources/PagesTestResults.csv";

    public static CSVReader readCSV() throws IOException
    {
        return new CSVReader(new FileReader(CSVReadPath));
    }

    public static CSVWriter writeCSV() throws IOException
    {
        return new CSVWriter(new FileWriter(CSVWritePath));
    }
}
