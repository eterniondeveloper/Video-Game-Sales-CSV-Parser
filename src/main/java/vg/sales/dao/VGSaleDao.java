package vg.sales.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import vg.sales.model.VGSale;

/**
 *
 * @author konstantinos
 */
public interface VGSaleDao {
    
    boolean add(VGSale sale) throws DataAccessException;
    
    List<VGSale> getAllVGSales() throws DataAccessException;
    
}
