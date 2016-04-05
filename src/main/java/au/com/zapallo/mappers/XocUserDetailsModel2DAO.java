package au.com.zapallo.mappers;

import au.com.zapallo.exceptions.XocMappingException;
import au.com.zapallo.models.XocSecUserDetails;
import au.com.zapallo.repositories.dao.XocSecUserDetailsDAO;


/**
 * Created by aaron.spiteri on 23/02/2016.
 */
public enum  XocUserDetailsModel2DAO implements XocMapperInterface<XocSecUserDetails, XocSecUserDetailsDAO> {
    ACCOUNT_ID("setAccountId", "getAccountId"),
    USERNAME("setUsername", "getUsername"),
    ENCRYPTED_PASSWORD("setEncryptedPassword", "getEncryptedPassword"),
    CDATE("setCdate", "getCdate"),
    MDATE ("setMdate", "getMdate"),
    LOCALE("setLocale", "getLocale"),
    EMAIL_ADDRESS("setEmailAddress", "getEmailAddress"),
    ACCOUNT_STATE("setAccountState", "getAccountState"),
    LONGITUDE_CORD("setLongitudeCord", "getLongitudeCord"),
    LATITUDE_CORD("setLatitudeCord", "getLatitudeCord");

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
