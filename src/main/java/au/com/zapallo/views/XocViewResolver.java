package au.com.zapallo.views;

import au.com.zapallo.exceptions.XocViewNotFoundException;
import org.springframework.web.servlet.ViewResolver;
import java.util.Locale;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Created by aaron.spiteri on 22/02/2016.
 */
public class XocViewResolver implements ViewResolver {
    private static final Logger logger = LoggerFactory.getLogger(XocViewResolver.class);
    private XocViewManagerInterface manager;

    public void setManager(XocViewManagerInterface manager) {
        this.manager = manager;
    }

    public XocAbstractView resolveViewName(String viewName, Locale local) throws XocViewNotFoundException {
        logger.debug("viewName = " + viewName);
        return manager.getViewMapper(viewName);
    }
}
