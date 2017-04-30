package vg.sales.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vg.sales.exception.MergeToCSVException;
import vg.sales.model.VGSale;
import vg.sales.util.SaleUtils;

/**
 *
 * @author Konstantinos Raptis
 */
public class WriteToFile {

    public void write(String file, List<VGSale> sales) {

        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            File fileDir = new File(file);
            
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), StandardCharsets.UTF_8));

            for (VGSale sale : sales) {

                String value = null;

                try {
                    value = SaleUtils.mergeToCSV(sale);
                } catch (MergeToCSVException ex) {
                    Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (value != null) {
                    bw.append(value + "\n");
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

}
