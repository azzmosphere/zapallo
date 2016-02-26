package au.com.zapallo.views;

import au.com.zapallo.exceptions.XocViewNotFoundException;

/**
 * Created by aaron.spiteri on 22/02/2016.
 */
public interface XocViewManagerInterface {
    XocAbstractView getViewMapper(String viewName) throws XocViewNotFoundException;
}
