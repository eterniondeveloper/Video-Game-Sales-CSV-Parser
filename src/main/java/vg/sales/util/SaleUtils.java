package vg.sales.util;

import vg.sales.exception.MergeToCSVException;
import vg.sales.model.VGSale;

/**
 *
 * @author Konstantinos Raptis
 */
public class SaleUtils {

    public static String mergeToCSV(VGSale sale) throws MergeToCSVException {

        StringBuilder builder = new StringBuilder();

        try {
            builder.append(sale.getRank()).append(",");
            builder.append("\"").append(sale.getName()).append("\"").append(",");
            builder.append("\"").append(sale.getPlatform()).append("\"").append(",");
            builder.append(sale.getYear()).append(",");
            builder.append("\"").append(sale.getGenre()).append("\"").append(",");
            builder.append("\"").append(sale.getPublisher()).append("\"").append(",");
            builder.append(sale.getNaSales()).append(",");
            builder.append(sale.getEuSales()).append(",");
            builder.append(sale.getJpSales()).append(",");
            builder.append(sale.getOtherSales()).append(",");
            builder.append(sale.getGlobalSales());
        } catch (Exception ex) {
            throw new MergeToCSVException("Merge to CSV exception for " + sale.toString(), ex);
        }
        
        return builder.toString();
    }

}
