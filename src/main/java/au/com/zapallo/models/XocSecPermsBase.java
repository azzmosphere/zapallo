package au.com.zapallo.models;

import java.util.HashMap;

/**
 * Created by aaron.spiteri on 1/03/2016.
 */
public class XocSecPermsBase implements XocSecPermsInterface {

    private HashMap<String, Boolean> isPermitted = new HashMap<>();

    @Override
    public void setIsPermitted(String right, Boolean value) {
        isPermitted.put(right, value);
    }

    @Override
    public Boolean isPermitted(String right) {
        Boolean rv = false;
        if (isPermitted.containsKey(right)) {
            rv = isPermitted.get(right);
        }

        return rv;
    }
}
