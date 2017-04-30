package vg.sales.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Konstantinos Raptis
 */
public class CSVSheet {
    
    private final List<String> headers;
    private final List<VGSale> values; 
    
    public CSVSheet() {
        this.headers = new ArrayList<>();
        this.values = new ArrayList<>();
    }
    
    public List<String> getHeaders() {
        return headers;
    }

    public void addHeader(String header) {
        this.headers.add(header);
    }

    public List<VGSale> getValues() {
        return values;
    }

    public void addValue(VGSale value) {
        this.values.add(value);
    }
    
}
