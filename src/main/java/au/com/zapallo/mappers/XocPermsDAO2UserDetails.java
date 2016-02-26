package au.com.zapallo.mappers;

import au.com.zapallo.models.XocSecUserDetails;
import au.com.zapallo.repositories.dao.XocSecUserDetailsPermissionsDAO;

/**
 * This a unique mapper as it is not a enumerated class. Instead it relies on attributes returned by
 *
 * Created by aaron.spiteri on 26/02/2016.
 */
public class XocPermsDAO2UserDetails extends XocAbstractAttributeMapper<XocSecUserDetailsPermissionsDAO, XocSecUserDetails> {
    @Override
    protected String getMethodSet() {
        return "setIsPermitted";
    }

    @Override
    protected String getMethodGet() {
        return "getIs_allowed";
    }

    @Override
    protected String getMethodKey() {
        return "getPerm_key";
    }
}
