package au.com.zapallo.models;

/**
 * Created by aaron.spiteri on 1/03/2016.
 */

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.comparator.BooleanComparator;

import java.io.Serializable;

public class XocSecGrantedAuthority implements GrantedAuthority, Serializable, XocSecPermsInterface {
    private String authority;
    private final XocSecPermsBase xocSecPermsBase = new XocSecPermsBase();

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public Boolean isPermitted(String right) {
        return xocSecPermsBase.isPermitted(right);
    }

    @Override
    public void setIsPermitted(String right, Boolean value) {
        xocSecPermsBase.setIsPermitted(right, value);
    }

    public Boolean hasPermission(String right) {
        return xocSecPermsBase.hasPermission(right);
    }
}
