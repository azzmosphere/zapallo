package au.com.zapallo.mappers;

/**
 * Created by aaron.spiteri on 19/02/2016.
 *
 * Should be implemented by all Zapallo mappers.
 */
public interface XocMapperInterface<T, S> {

    /**
     * Accepts a input object and maps it to a model object.
     *
     * ** HINT ** Your input object should be generic, such
     * as the JSON object not the node.
     *
     * @param inObj   Object supplied by input
     * @param outObj  Object that is getting populated.
     */
    void mapTo(T inObj, S outObj);

    /**
     *
     * @param outObj
     * @param inObj
     */
    void mapFrom(S outObj, T inObj);
}
