package au.com.zapallo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by aaron.spiteri on 2/03/2016.
 */
public class XocUsernameNotFoundException extends UsernameNotFoundException {
    private static final Logger logger = LoggerFactory.getLogger(XocUsernameNotFoundException.class);

    public XocUsernameNotFoundException(String message) {
        super(message);
        logger.error(message);
    }

    public XocUsernameNotFoundException(String message, Exception e) {
        super(message);
        logger.error(message, e);
    }
}
