package vg.sales.exception;

/**
 *
 * @author Konstantinos Raptis
 */
public class ExtractException extends Exception {
    
    public ExtractException() {
        super();
    }
    
    public ExtractException(String message) {
        super(message);
    }
    
    public ExtractException(Throwable t) {
        super(t);
    }
    
    public ExtractException(String message, Throwable t) {
        super(message, t);
    }
    
}
