package vg.sales.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import vg.sales.dao.VGSaleDao;
import vg.sales.model.VGSale;

/**
 *
 * @author konstantinos
 */
@Service
public class VGSaleService {
    
    @Autowired
    @Qualifier("JdbcVGSaleDao")
    private VGSaleDao vgSaleDao;
    
    public boolean addVGSale(VGSale sale) throws DataAccessException {
        return vgSaleDao.add(sale);
    }
    
    public boolean addVGsales(List<VGSale> sales) throws DataAccessException {
        return vgSaleDao.add(sales);
    }
       
}
