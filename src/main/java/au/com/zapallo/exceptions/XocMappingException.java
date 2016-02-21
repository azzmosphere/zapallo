package au.com.zapallo.exceptions;

/**
 * Created by aaron.spiteri on 22/02/2016.
 */
public class XocMappingException extends Exception {
    public XocMappingException(String message) {
        super(message);
    }

    //TODO Add logging support for Exception
    public XocMappingException(String message, Exception e) {

    }
}
