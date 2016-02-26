package au.com.zapallo.mappers;

import au.com.zapallo.exceptions.XocMappingException;

import java.lang.reflect.Method;

/**
 * Created by aaron.spiteri on 26/02/2016.
 *
 * This class is injected into the mapper via the XocMapperInterface, it is
 * used to perform boiler plate tasks.
 */
public class XocMapperHelper<T, S> {

    private String methodSet;
    private String methodGet;
    private Class returnType;

    public String getMethodSet() {
        return methodSet;
    }

    public void setMethodSet(String methodSet) {
        this.methodSet = methodSet;
    }

    public String getMethodGet() {
        return methodGet;
    }

    public void setMethodGet(String methodGet) {
        this.methodGet = methodGet;
    }



    //CHECKSOFF: Cyclomatic Complexity
    private boolean hasChanged(T inObj, S outObj) throws XocMappingException {
        boolean hasChanged = true;

        try {
            Method mOutObjGet = outObj.getClass().getMethod(methodGet);
            Method mInObjGet = inObj.getClass().getMethod(methodGet);
            returnType = mInObjGet.getReturnType();

            if (returnType.equals(Long.class) && (mInObjGet.invoke(inObj) != mOutObjGet.invoke(outObj))) {
                hasChanged = true;
            } else if (mInObjGet.invoke(inObj) == null || mOutObjGet.invoke(outObj) == null) {
                if (mInObjGet.invoke(inObj) != mOutObjGet.invoke(outObj)) {
                    hasChanged = true;
                }
            } else {
                Object r1 = mInObjGet.invoke(inObj);
                Object r2 = mOutObjGet.invoke(outObj);
                Method equalsMethod = r1.getClass().getMethod("equals", r2.getClass());
                hasChanged = ((boolean) equalsMethod.invoke(r1, r2)) ? false : true;
            }
        }
        catch (Exception e) {
            throw new XocMappingException("Unable to perform tyoe conversion for " + methodGet, e);
        }

        return hasChanged;
    }
    //CHECKSON: Cyclomatic Complexity


    /**
     * Maps inObj to outObj and vice versa depending on how the direction
     * variable is set.
     *
     * @param inObj
     * @param outObj
     * @param direction
     * @throws XocMappingException
     */
    public void mapObj(T inObj, S outObj, boolean direction)
            throws XocMappingException {
        if (hasChanged(inObj, outObj)) {
            try {
                Method m1 = (direction) ? outObj.getClass().getMethod(methodSet, returnType) : inObj.getClass().getMethod(methodSet);
                Method m2 = (direction) ? inObj.getClass().getMethod(methodGet) : inObj.getClass().getMethod(methodGet);

                m1.invoke(outObj, m2.invoke(inObj));
            }
            catch (Exception e) {
                throw new XocMappingException("Could not set outObj from Obj", e);
            }
        }
    }
}
