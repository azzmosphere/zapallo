package au.com.zapallo.mappers;

import au.com.zapallo.models.XocSecGrantedAuthority;

/**
 * Created by aaron.spiteri on 1/03/2016.
 */
public class XocPerms2GrantAuth extends XocAbstractAttributeMapper<XocSecGrantAuthPermissionsDAO, XocSecGrantedAuthority> {
    @Override
    protected String getMethodSet() {
        return "setIsPermitted";
    }

    @Override
    protected String getMethodGet() {
        return "getIsAllowed";
    }

    @Override
    protected String getMethodKey() {
        return "getPermKey";
    }
}
