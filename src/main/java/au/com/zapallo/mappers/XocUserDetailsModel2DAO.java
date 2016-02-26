package au.com.zapallo.mappers;

import au.com.zapallo.exceptions.XocMappingException;
import au.com.zapallo.models.XocSecUserDetails;
import au.com.zapallo.repositories.dao.XocSecUserDetailsDAO;


/**
 * Created by aaron.spiteri on 23/02/2016.
 */
public enum  XocUserDetailsModel2DAO implements XocMapperInterface<XocSecUserDetails, XocSecUserDetailsDAO> {
    ACCOUNT_ID("setAccount_id", "getAccount_id"),
    USERNAME("setUsername", "getUsername"),
    ENCRYPTED_PASSWORD("setEncrypted_password", "getEncrypted_password"),
    CDATE("setCdate", "getCdate"),
    MDATE ("setMdate", "getMdate"),
    LOCALE("setLocale", "getLocale"),
    EMAIL_ADDRESS("setEmail_address", "getEmail_address"),
    ACCOUNT_STATE("setAccount_state", "getAccount_state"),
    LONGITUDE_CORD("setLongitude_cord", "getLongitude_cord"),
    LATITUDE_CORD("setLatitude_cord", "getLatitude_cord");

    protected XocMapperHelper<XocSecUserDetails, XocSecUserDetailsDAO> helper;
    private String methodSet;
    private String methodGet;

    XocUserDetailsModel2DAO(String methodSet, String methodGet) {
        this.methodGet = methodGet;
        this.methodSet = methodSet;
    }

    private void assignHelper() throws XocMappingException {
        if (helper == null) {
            helper = new XocMapperHelper<>();
        }
        helper.setMethodGet(methodGet);
        helper.setMethodSet(methodSet);
    }

    @Override
    public void mapTo(XocSecUserDetails inObj, XocSecUserDetailsDAO outObj) throws XocMappingException {
        assignHelper();
        helper.mapObj(inObj, outObj, true);
    }

    @Override
    public void mapFrom(XocSecUserDetailsDAO outObj, XocSecUserDetails inObj) throws XocMappingException {
        assignHelper();
        helper.mapObj(inObj, outObj, false);
    }
}
