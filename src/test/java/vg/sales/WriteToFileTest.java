package vg.sales;

import java.io.IOException;
import java.util.List;
import org.junit.Test;
import vg.sales.model.VGSale;
import vg.sales.reader.CSVReader;
import vg.sales.writer.WriteToFile;

/**
 *
 * @author Konstantinos Raptis
 */
public class WriteToFileTest {
    
    @Test
    public void testWrite() throws IOException {
        
        String readFile = "C:\\Users\\konstantinos\\Google Drive\\Πανεπιστήμιο Πειραιώς\\6ο εξάμηνο\\Αποθήκες και εξόρυξη δεδομένων\\Project\\assets\\videogamesales\\vgsales_small.csv";
        String writeFile = "C:\\Users\\konstantinos\\Desktop\\test\\vgsales_new.csv";
        
        CSVReader reader = new CSVReader(11);
        List<VGSale> sales = reader.read(readFile, true);
        
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.write(writeFile, sales);
        
    }
    
}
