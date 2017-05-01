package vg.sales.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Konstantinos Raptis
 * @param <T> Generic Type 
 */
public class CSVSheet<T extends CSVSheetValue> {
    
    private final List<String> headers;
    private final List<T> values; 
    private final boolean isFirstLineHeaders;
    
    public CSVSheet(boolean isFirstLineHeaders) {
        this.isFirstLineHeaders = isFirstLineHeaders;
        this.headers = new ArrayList<>();
        this.values = new ArrayList<>();
    }
    
    public List<String> getHeaders() {
        return this.headers;
    }

    public void addHeader(String header) {
        this.headers.add(header);
    }

    public List<T> getValues() {
        return this.values;
    }

    public void addValue(T value) {
        this.values.add(value);
    }
    
    public String mergeHeaders() {
        StringBuilder builder = new StringBuilder();
        
        this.headers.forEach((header) -> {
            builder.append(header).append(",");
        });
                
        String resultWithLastComma = builder.toString();
        
        // remove last comma
        return resultWithLastComma.substring(0, resultWithLastComma.length() - 1);
    }

    public boolean isIsFirstLineHeaders() {
        return isFirstLineHeaders;
    }
    
}
