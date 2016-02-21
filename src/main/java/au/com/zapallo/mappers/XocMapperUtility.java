package au.com.zapallo.mappers;

import au.com.zapallo.exceptions.XocMappingException;

import java.lang.reflect.Method;

/**
 * Created by aaron.spiteri on 19/02/2016.
 */
public class XocMapperUtility<T, K, U extends XocMapperInterface> {

    U mapper;
    private final int MAP_TO   = 0;
    private final int MAP_FROM = 1;

    /**
     * Creates a instance of the mapper utility. The enumerated mapper is
     * expected to be the first argument.
     *
     * @param mapper
     * @throws Exception
     */
    public XocMapperUtility(U mapper) throws XocMappingException {
        if (!(mapper instanceof Enum)) {
            throw new XocMappingException("mapper must be enumerated");
        }
        this.mapper = mapper;
    }

    /**
     * Maps input object to output objects. Given a list of keys provided by
     * the mapper.
     *
     * @param inObj
     * @param outObj
     */

    //TODO: Start worrying about what how to handle the exceptions.
    public final void mapTo(T inObj, K outObj) throws XocMappingException {
        performMapping(inObj, outObj, MAP_TO);
    }

    private void performMapping(T inObj, K outObj, int direction) throws XocMappingException {
        try {
            Method m = mapper.getClass().getMethod("values");

            U[] values = (U[]) m.invoke(mapper);
            for (U instance : values) {
                if (direction == MAP_TO) {
                    instance.mapTo(inObj, outObj);
                }
                else if (direction == MAP_FROM) {
                    instance.mapFrom(outObj, inObj);
                }
                else {
                    throw new NoSuchMethodException();
                }
            }

        }
        catch (NoSuchMethodException e) {
            throw new XocMappingException("Could not find method values in mapper", e);
        }
        catch (Exception e) {
            throw new XocMappingException("Unknown exception has occurred", e);
        }
    }

    /**
     * Maps output objects from the value of the input objects. This should
     * be done after the business rules have been applied.
     *
     * @param inObj
     * @param outObj
     */
    public final void mapFrom(K outObj, T inObj) throws XocMappingException {
        performMapping(inObj, outObj, MAP_FROM);
    }
}
