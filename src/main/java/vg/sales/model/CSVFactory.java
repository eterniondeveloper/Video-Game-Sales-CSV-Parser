package vg.sales.model;

/**
 *
 * @author Konstantinos Raptis
 */
public class CSVFactory {
    
    public CSVSheetValue create(Class<? extends CSVSheetValue> cls) {
        
        if (cls == VGSale.class) {
            return new VGSale();
        } 
            
        return null;
    }
    
}
