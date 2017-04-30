package vg.sales.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import vg.sales.model.VGSale;
import vg.sales.service.VGSaleService;

/**
 *
 * @author konstantinos
 */
public class CSVReader {

    private final int lineSize;
    @Autowired
    private VGSaleService service;

    public CSVReader(int lineSize) {
        this.lineSize = lineSize;
    }

    public List<VGSale> read(String file, boolean isFirstLineHeaders) throws IOException {
        
        List<VGSale> vgSaleList = new ArrayList<>();
        
        String line;
        String cvsSplitBy = ",";

        BufferedReader br = new BufferedReader(new FileReader(file));
        VGSale sale;
        String[] data;

        while ((line = br.readLine()) != null) {

            if (isFirstLineHeaders) {
                isFirstLineHeaders = false;
                continue;
            }

            // use comma as separator
            data = line.split(cvsSplitBy);
            sale = new VGSale();

            // data length validation
            if (data.length != this.lineSize) {
                continue;
            }

            // extract sales data
            sale.setRank(Long.parseLong(data[0]));
            sale.setName(data[1]);
            sale.setPlatform(data[2]);

            try {
                sale.setYear(Integer.parseInt(data[3]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            sale.setGenre(data[4]);
            sale.setPublisher(data[5]);

            try {
                sale.setNaSales(Double.parseDouble(data[6]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            try {
                sale.setEuSales(Double.parseDouble(data[7]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            try {
                sale.setJpSales(Double.parseDouble(data[8]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            try {
                sale.setOtherSales(Double.parseDouble(data[9]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            try {
                sale.setGlobalSales(Double.parseDouble(data[10]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            
            vgSaleList.add(sale);
            System.out.println(sale);
        }
        
        return vgSaleList;
    }

    public void readAndSaveToDB(String file, boolean isFirstLineHeaders, int size) throws IOException {

        List<VGSale> buffer = new ArrayList<>(size);

        String line;
        String cvsSplitBy = ";";

        BufferedReader br = new BufferedReader(new FileReader(file));
        VGSale sale;
        String[] data;

        while ((line = br.readLine()) != null) {

            if (isFirstLineHeaders) {
                isFirstLineHeaders = false;
                continue;
            }

            // use comma as separator
            data = line.split(cvsSplitBy);
            sale = new VGSale();

            // data length should be 11
            if (data.length != this.lineSize) {
                continue;
            }

            // clear buffer
            if (buffer.size() == size) {
                // store data to db
                try {
                    service.addVGsales(buffer);
                } catch (DataAccessException ex) {
                    Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
                }
                // init buffer
                buffer = new ArrayList<>(size);
            }

            // extract sales data
            sale.setRank(Long.parseLong(data[0]));
            sale.setName(data[1]);
            sale.setPlatform(data[2]);

            try {
                sale.setYear(Integer.parseInt(data[3]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            sale.setGenre(data[4]);
            sale.setPublisher(data[5]);

            try {
                sale.setNaSales(Double.parseDouble(data[6]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            try {
                sale.setEuSales(Double.parseDouble(data[7]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            try {
                sale.setJpSales(Double.parseDouble(data[8]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            try {
                sale.setOtherSales(Double.parseDouble(data[9]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            try {
                sale.setGlobalSales(Double.parseDouble(data[10]));
            } catch (NumberFormatException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }

            System.out.println(sale);

            buffer.add(sale);
        }

        // store rest data to db
        try {
            if (service == null) {
                System.out.println("null");
            }
            service.addVGsales(buffer);
        } catch (DataAccessException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }

}
