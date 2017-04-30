package vg.sales;

import java.io.IOException;
import org.junit.Ignore;
import org.junit.Test;
import vg.sales.model.CSVSheet;
import vg.sales.reader.CSVReader;
import vg.sales.writer.WriteToFile;

/**
 *
 * @author Konstantinos Raptis
 */
public class WriteToFileTest {
    
    @Ignore
    @Test
    public void testWrite() throws IOException {
        
        String readFile = "C:\\Users\\konstantinos\\Google Drive\\Πανεπιστήμιο Πειραιώς\\6ο εξάμηνο\\Αποθήκες και εξόρυξη δεδομένων\\Project\\assets\\videogamesales\\vgsales_small.csv";
        String writeFile = "C:\\Users\\konstantinos\\Desktop\\test\\vgsales_new.csv";
        
        CSVReader reader = new CSVReader();
        CSVSheet sheet = reader.read(readFile, true);
        
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.write(writeFile, sheet);
        
    }
       
}
