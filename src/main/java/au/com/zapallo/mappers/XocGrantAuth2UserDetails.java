package au.com.zapallo.mappers;

import au.com.zapallo.exceptions.XocMappingException;
import au.com.zapallo.models.XocSecGrantedAuthority;
import au.com.zapallo.models.XocSecUserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by aaron.spiteri on 1/03/2016.
 */
public class XocGrantAuth2UserDetails implements XocMapperInterface<List<XocSecGrantedAuthority>, XocSecUserDetails> {

    @Override
    public void mapTo(List<XocSecGrantedAuthority> inObj, XocSecUserDetails outObj) throws XocMappingException {
        Collection<XocSecGrantedAuthority> collection = inObj;
        outObj.setGrantedAuthorities(inObj);
    }

    @Override
    public void mapFrom(XocSecUserDetails outObj, List<XocSecGrantedAuthority> inObj) throws XocMappingException {
        inObj = (List) outObj.getAuthorities();
    }
}
