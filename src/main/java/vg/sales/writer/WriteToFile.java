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
import vg.sales.exception.MergeException;
import vg.sales.model.CSVSheet;
import vg.sales.model.CSVSheetValue;

/**
 *
 * @author Konstantinos Raptis
 */
public class WriteToFile {

    public void write(final String filename, CSVSheet sheet) {

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

            for (CSVSheetValue value : sheet.getValues()) {

                String margedValue = null;

                try {
                    margedValue = value.mergeValue();
                } catch (MergeException ex) {
                    Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (margedValue != null) {
                    bw.append(margedValue + "\n");
                }
            }

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
