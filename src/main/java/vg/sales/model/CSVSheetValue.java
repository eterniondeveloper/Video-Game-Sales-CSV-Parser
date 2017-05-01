package vg.sales.model;

import vg.sales.exception.MergeException;

/**
 *
 * @author Konstantinos Raptis
 */
public interface CSVSheetValue {
    
    String mergeValue() throws MergeException;
    
    void extractValue(String[] data);
    
}
