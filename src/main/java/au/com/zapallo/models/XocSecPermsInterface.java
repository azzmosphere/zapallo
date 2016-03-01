package au.com.zapallo.models;

/**
 *
 * Interface that allows permission to be managed. It is a implementation of
 * the mixin pattern which is not supported by JAVA at the time of writing
 * this code.
 *
 * To use the interface should be implemented by the calling class and the
 * calling class should create a reference to the XocSecPermsClass
 *
 * Created by aaron.spiteri on 1/03/2016.
 */
public interface XocSecPermsInterface {

    Boolean isPermitted(String right);
    void setIsPermitted(String right, Boolean value);
}
