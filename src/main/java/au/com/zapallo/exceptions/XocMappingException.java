package au.com.zapallo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aaron.spiteri on 22/02/2016.
 */
public class XocMappingException extends Exception {
    private static final Logger logger = LoggerFactory.getLogger(XocMappingException.class);

    public XocMappingException(String message) {
        super(message);
        logger.error(message);
    }

    public XocMappingException(String message, Exception e) {
        logger.error(message, e);
    }
}
