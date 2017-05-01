package vg.sales.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Konstantinos Raptis
 */
public class CSVSheet {

    private final List<String> headers;
    private final List<CSVSheetValue> values;
    private final boolean firstLineHeaders;

    public CSVSheet(boolean firstLineHeaders) {
        this.firstLineHeaders = firstLineHeaders;
        this.headers = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public List<String> getHeaders() {
        return this.headers;
    }

    public void addHeader(String header) {
        this.headers.add(header);
    }

    public List<CSVSheetValue> getValues() {
        return this.values;
    }

    public void addValue(CSVSheetValue value) {
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

    public boolean isFirstLineHeaders() {
        return firstLineHeaders;
    }
    
    public boolean isHeadersAdded() {
        boolean result = false;
        
        if (firstLineHeaders && !headers.isEmpty()) {
            result = true;
        }
        
        return result;
    }
    
}
