package vg.sales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import vg.sales.exception.MergeToCSVException;
import vg.sales.model.VGSale;
import vg.sales.util.SaleUtils;

/**
 *
 * @author Konstantinos Raptis
 */
public class VGSaleUtilTest {
    
    @Ignore
    @Test
    public void testMergeValuesToCSV() throws MergeToCSVException {
        
        VGSale sale = new VGSale();        
        
        sale.setRank(1);
        sale.setName("Wii Sports");
        sale.setPlatform("Wii");
        sale.setYear(2006);
        sale.setGenre("Sports");
        sale.setPublisher("Nintento");
        sale.setNaSales(41.49);
        sale.setEuSales(29.02);
        sale.setJpSales(3.77);
        sale.setOtherSales(8.46);
        sale.setGlobalSales(82.74);
        
        String value = SaleUtils.mergeValuesToCSV(sale);
        System.out.println(value);        
    }
    
    @Test
    public void testMergeHeadersToCSV() {
        
        List<String> headers = Arrays.asList("A", "B", "C");
        
        String result = SaleUtils.mergeHeadersToCSV(headers);
        System.out.println(result);        
    }
    
}
