package vg.sales.exception;

/**
 *
 * @author Konstantinos Raptis
 */
public class MergeToCSVException extends Exception {
    
    public MergeToCSVException() {
        super();
    }
    
    public MergeToCSVException(String message) {
        super(message);
    }
    
    public MergeToCSVException(Throwable t) {
        super(t);
    }
    
    public MergeToCSVException(String message, Throwable t) {
        super(message, t);
    }
    
}
