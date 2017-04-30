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
    
    boolean add(List<VGSale> sales) throws DataAccessException;
    
}
