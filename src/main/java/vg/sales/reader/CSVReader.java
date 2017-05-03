package vg.sales.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import vg.sales.exception.ExtractException;
import vg.sales.model.CSVSheet;
import vg.sales.model.CSVSheetValue;

/**
 *
 * @author konstantinos
 */
public class CSVReader {
    
    public CSVSheet read(File file, boolean isFirstLineHeaders, Class<? extends CSVSheetValue> cls) throws IOException, InstantiationException, IllegalAccessException {
       
        CSVSheet sheet = new CSVSheet(isFirstLineHeaders);
        String line;
        String cvsSplitBy = ",";

        BufferedReader br = new BufferedReader(new FileReader(file));
        String[] data;
        boolean flag = false;
        int numberOfColumns = 0;
        CSVSheetValue value;
        
        
        
        while ((line = br.readLine()) != null) {
                       
            // use comma as separator
            data = line.split(cvsSplitBy);
            value = cls.newInstance();
            
            // avoid a null value
            if (value == null) {
                continue;
            }
            
            // init number of columns
            if (!flag) {
                numberOfColumns = data.length;
                flag = true;
            }
            
            // add headers to sheet here
            if (sheet.isFirstLineHeaders() && !sheet.isHeadersAdded()) {
                Arrays.asList(data).forEach(header -> sheet.addHeader(header));
                continue;
            }

            // data length validation
            if (data.length != numberOfColumns) {
                continue;
            }
            
            try {
                value.extractValue(data);
                sheet.addValue(value);
                System.out.println(value);
            } catch (ExtractException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            
        }
              
        return sheet;
    }

}
