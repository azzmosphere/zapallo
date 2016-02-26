package au.com.zapallo.mappers;

import java.util.Date;
import java.util.Locale;
import au.com.zapallo.models.XocSecUserDetails;
import au.com.zapallo.models.XocSecUserDetailsStates;
import au.com.zapallo.repositories.dao.XocSecUserDetailsDAO;
import org.junit.Test;


import static org.junit.Assert.fail;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import javax.mail.internet.InternetAddress;

/**
 * Created by aaron.spiteri on 24/02/2016.
 */
public class XocUserDetailsModel2DAOTest {
    @Test
    public void shouldMapModelToDAO() {

        try {
            XocSecUserDetailsDAO xocSecUserDetailsDAO = new XocSecUserDetailsDAO();
            XocSecUserDetails xocSecUserDetails = new XocSecUserDetails();
            Date nowDate = new Date();
            XocMapperUtility<XocSecUserDetails, XocSecUserDetailsDAO, XocUserDetailsModel2DAO>
                    xocMapperUtility = new XocMapperUtility<>(XocUserDetailsModel2DAO.ACCOUNT_ID);

            xocSecUserDetails.setAccount_id(112L);
            xocSecUserDetails.setUsername("foobar");
            xocSecUserDetails.setEncrypted_password("XYZ");
            xocSecUserDetails.setCdate(nowDate);
            xocSecUserDetails.setMdate(nowDate);
            xocSecUserDetails.setLocale(new Locale.Builder().setLanguage("EN").setRegion("AU").build());
            xocSecUserDetails.setEmail_address(new InternetAddress("aaron@example.com"));
            xocSecUserDetails.setAccount_state(XocSecUserDetailsStates.ACCOUNT_ACTIVE);
            xocSecUserDetails.setLongitude_cord("35.89421911");
            xocSecUserDetails.setLatitude_cord("139.94637467");

            xocMapperUtility.mapTo(xocSecUserDetails, xocSecUserDetailsDAO);

            assertThat(xocSecUserDetailsDAO.getAccount_id(), is(xocSecUserDetails.getAccount_id()));

        }
        catch (Exception e) {
            fail("exception was thrown " + e.getMessage());
        }
    }
}
