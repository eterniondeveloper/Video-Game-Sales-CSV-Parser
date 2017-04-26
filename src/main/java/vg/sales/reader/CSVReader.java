package vg.sales.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import vg.sales.model.VGSale;

/**
 *
 * @author konstantinos
 */
public class CSVReader {

    public List<VGSale> read(String file, boolean isFirstLineHeaders) throws IOException {

        List<VGSale> vgSaleList = new ArrayList<>();

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
            
            // extract sales data
            sale.setRank(Long.parseLong(data[0]));
            sale.setName(data[1]);
            sale.setPlatform(data[2]);
            sale.setYear(Integer.parseInt(data[3]));
            sale.setGenre(data[4]);
            sale.setPublisher(data[5]);
            sale.setNaSales(Double.parseDouble(data[6]));
            sale.setEuSales(Double.parseDouble(data[7]));
            sale.setJpSales(Double.parseDouble(data[8]));
            sale.setOtherSales(Double.parseDouble(data[9]));
            sale.setGlobalSales(Double.parseDouble(data[10]));
            
            vgSaleList.add(sale);
            
            // System.out.println(sale);
        }

        return vgSaleList;
    }
    
}
