package vg.sales.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import vg.sales.model.VGSale;

/**
 *
 * @author konstantinos
 */
@Repository
@Qualifier("CsvVGSaleDao")
public class CsvVGSaleDao implements VGSaleDao {

    @Override
    public boolean add(VGSale sale) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<VGSale> getAllVGSales() throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
