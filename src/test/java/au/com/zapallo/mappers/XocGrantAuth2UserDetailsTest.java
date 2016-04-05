package au.com.zapallo.mappers;

import au.com.zapallo.models.XocSecGrantedAuthority;
import au.com.zapallo.models.XocSecUserDetails;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by aaron.spiteri on 1/03/2016.
 */
public class XocGrantAuth2UserDetailsTest {

    @Test
    public void shouldAssignAuthorities() {

        try {
            List<XocSecGrantedAuthority> xocSecGrantedAuthorityList = new ArrayList<>();

            XocSecGrantedAuthority role = new XocSecGrantedAuthority();
            role.setAuthority("role1");
            xocSecGrantedAuthorityList.add(role);

            role = new XocSecGrantedAuthority();
            role.setAuthority("role2");
            xocSecGrantedAuthorityList.add(role);

            role = new XocSecGrantedAuthority();
            role.setAuthority("role3");
            xocSecGrantedAuthorityList.add(role);

            XocSecUserDetails userDetails = new XocSecUserDetails();
            XocGrantAuth2UserDetails mapper = new XocGrantAuth2UserDetails();

            mapper.mapTo(xocSecGrantedAuthorityList, userDetails);

            List<XocSecGrantedAuthority> xocSecGrantedAuthorityOut = (List<XocSecGrantedAuthority>) userDetails.getAuthorities();

            boolean role1Found = false;
            boolean role2Found = false;
            boolean role3Found = false;

            for (XocSecGrantedAuthority el : xocSecGrantedAuthorityOut) {
                if ("role1".equals(el.getAuthority())) {
                    role1Found = true;
                }

                else if ("role2".equals(el.getAuthority())) {
                    role2Found = true;
                }

                else if ("role3".equals(el.getAuthority())) {
                    role3Found = true;
                }
            }

            assertTrue(role1Found);
            assertTrue(role2Found);
            assertTrue(role3Found);

        }
        catch (Exception e) {
            fail("Unable to create user authorities");
        }

    }
}
