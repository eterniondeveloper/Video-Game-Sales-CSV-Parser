package vg.sales.exception;

/**
 *
 * @author Konstantinos Raptis
 */
public class MergeException extends Exception {
    
    public MergeException() {
        super();
    }
    
    public MergeException(String message) {
        super(message);
    }
    
    public MergeException(Throwable t) {
        super(t);
    }
    
    public MergeException(String message, Throwable t) {
        super(message, t);
    }
    
}
