package vg.sales.model;

/**
 *
 * @author Konstantinos Raptis
 */
public class CSVFactory {
    
    public <T extends CSVSheetValue> T create(Class<? extends CSVSheetValue> cls) {
        
        if (cls == VGSale.class) {
            return (T) new VGSale();
        } 
            
        return null;
    }
    
}
