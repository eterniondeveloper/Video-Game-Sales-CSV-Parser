package vg.sales.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import vg.sales.exception.MergeException;
import vg.sales.model.CSVSheet;
import vg.sales.model.CSVSheetValue;
import vg.sales.model.VGSale;

/**
 *
 * @author Konstantinos Raptis
 * @param <T>
 */
public class WriteToFile<T extends CSVSheetValue> {

    public void write(final String filename, CSVSheet<T> sheet) {

        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            String outputFilename = createOutputFilename(filename);
            File fileDir = new File(outputFilename);
            
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), StandardCharsets.UTF_8));
            
            // apply headers
            if (!sheet.getHeaders().isEmpty()) {
                bw.append(sheet.mergeHeaders() + "\n");
            }
            
            for (T sale : sheet.getValues()) {

                String value = null;

                try {
                    value = sale.mergeValue();
                } catch (MergeException ex) {
                    Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (value != null) {
                    bw.append(value + "\n");
                }
            }
            
            sheet.getValues().stream()
                    .filter(value -> value instanceof VGSale)
                    .map(value -> (VGSale) value).collect(Collectors.toList());
            
            bw.flush();

        } catch (IOException ex) {
            Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }

                if (pw != null) {
                    pw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    private String createOutputFilename(final String filename) {
                
        Path oldPath = Paths.get(filename);
        String oldFilename = oldPath.getFileName().toString();
        String[] fileChunks = oldFilename.split("\\.");
        String newPathAsString = oldPath.getParent().toString() + "\\" + fileChunks[0] + "_new.csv";
        
        return newPathAsString;
    }
       
}
