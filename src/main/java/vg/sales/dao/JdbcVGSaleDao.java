package vg.sales.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import vg.sales.model.VGSale;

/**
 *
 * @author konstantinos
 */
@Repository
@Qualifier("JdbcVGSaleDao")
public class JdbcVGSaleDao implements VGSaleDao {

    protected static final String TABLE_VG_SALE = "vg_sale";
    protected static final String RANK = "rank";
    protected static final String NAME = "name";
    protected static final String PLATFORM = "platform";
    protected static final String YEAR = "year";
    protected static final String GENRE = "genre";
    protected static final String PUBLISHER = "publisher";
    protected static final String NA_SALES = "na_sales";
    protected static final String EU_SALES = "eu_sales";
    protected static final String JP_SALES = "jp_sales";
    protected static final String OTHER_SALES = "other_sales";
    protected static final String GLOBAL_SALES = "global_sales";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean add(VGSale sale) throws DataAccessException {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName(TABLE_VG_SALE);
        Map<String, Object> params = new HashMap<>();
        params.put(RANK, sale.getRank());
        params.put(NAME, sale.getName());
        params.put(PLATFORM, sale.getPlatform());
        params.put(YEAR, sale.getYear());
        params.put(GENRE, sale.getGenre());
        params.put(PUBLISHER, sale.getPublisher());
        params.put(NA_SALES, sale.getNaSales());
        params.put(EU_SALES, sale.getEuSales());
        params.put(JP_SALES, sale.getJpSales());
        params.put(OTHER_SALES, sale.getOtherSales());
        params.put(GLOBAL_SALES, sale.getGlobalSales());
        int rows = jdbcInsert.execute(new MapSqlParameterSource(params));
        return rows > 0;
    }

    @Override
    public boolean add(List<VGSale> sales) throws DataAccessException {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName(TABLE_VG_SALE);
        Map<String, Object> params = new HashMap<>();

        for (VGSale sale : sales) {
            params.put(RANK, sale.getRank());
            params.put(NAME, sale.getName());
            params.put(PLATFORM, sale.getPlatform());
            params.put(YEAR, sale.getYear());
            params.put(GENRE, sale.getGenre());
            params.put(PUBLISHER, sale.getPublisher());
            params.put(NA_SALES, sale.getNaSales());
            params.put(EU_SALES, sale.getEuSales());
            params.put(JP_SALES, sale.getJpSales());
            params.put(OTHER_SALES, sale.getOtherSales());
            params.put(GLOBAL_SALES, sale.getGlobalSales());
        }

        int rows = params.isEmpty() ? 0 : jdbcInsert.execute(new MapSqlParameterSource(params));
        return rows > 0;
    }
    
}
