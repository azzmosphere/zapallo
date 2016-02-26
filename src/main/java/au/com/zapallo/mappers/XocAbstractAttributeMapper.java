package au.com.zapallo.mappers;

import au.com.zapallo.exceptions.XocMappingException;

import java.util.List;
import java.lang.reflect.Method;

/**
 * Created by aaron.spiteri on 26/02/2016.
 */
public abstract class XocAbstractAttributeMapper<T, K> {

    protected abstract String getMethodSet();
    protected abstract String getMethodGet();
    protected abstract String getMethodKey();


    public void performMap(List<T> inObj, K outObj) throws XocMappingException {
        try {

            if (inObj.size() > 0) {
                Class inClass = inObj.get(0).getClass();
                Method keyMethod = inClass.getMethod(getMethodKey());
                Method getMethod = inClass.getMethod(getMethodGet());
                Method setMethod = outObj.getClass().getMethod(getMethodSet(), keyMethod.getReturnType(), getMethod.getReturnType());

                for (T obj : inObj) {
                    setMethod.invoke(outObj, keyMethod.invoke(obj), getMethod.invoke(obj));
                }
            }
        }
        catch (Exception e) {
            throw new XocMappingException("Could not map attributes", e);

        }
    }
}
