package au.com.zapallo.mappers;

import au.com.zapallo.exceptions.XocMappingException;
import au.com.zapallo.models.XocSecUserDetails;
import au.com.zapallo.repositories.dao.XocSecUserDetailsPermissionsDAO;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 26/02/2016.
 */
public class XocPermsDAO2UserDetailsTest {

    @Test
    public void shouldCorrectlyMapPerms() {
        XocSecUserDetails userDetails = new XocSecUserDetails();
        List<XocSecUserDetailsPermissionsDAO> perms = new ArrayList<>();

        List<String> keys = new ArrayList<>();
        keys.add(XocSecUserDetails.KEY_ACCOUNT_EXPIRED);
        keys.add(XocSecUserDetails.KEY_ACCOUNT_LOCKED);
        keys.add(XocSecUserDetails.KEY_CREDITIALS_EXPIRED);
        keys.add(XocSecUserDetails.KEY_ENABLED);

        for (String key : keys) {
            XocSecUserDetailsPermissionsDAO dao = new XocSecUserDetailsPermissionsDAO();
            dao.setPerm_key(key);
            dao.setIs_allowed(true);
            perms.add(dao);
        }

        assertThat(userDetails.isAccountNonExpired(), is(true));
        assertThat(userDetails.isAccountNonLocked(), is(true));
        assertThat(userDetails.isCredentialsNonExpired(), is(true));
        assertThat(userDetails.isEnabled(), is(false));
        XocPermsDAO2UserDetails mapper = new XocPermsDAO2UserDetails();
        try {
            mapper.performMap(perms, userDetails);
        } catch (XocMappingException e) {
            fail("Could not perform mapping" + e.getMessage());
        }

        assertThat(userDetails.isAccountNonExpired(), is(false));
        assertThat(userDetails.isAccountNonLocked(), is(false));
        assertThat(userDetails.isCredentialsNonExpired(), is(false));
        assertThat(userDetails.isEnabled(), is(true));
    }
}
