package au.com.zapallo.services;

import au.com.zapallo.mappers.XocUserDetailsModel2DAO;
import au.com.zapallo.models.XocSecUserDetails;
import au.com.zapallo.repositories.crud.XocSecUserDetailsCRUD;
import au.com.zapallo.repositories.dao.XocSecUserDetailsDAO;
import au.com.zapallo.exceptions.XocUsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron.spiteri on 2/03/2016.
 */
public class XocSecUserDetailsService extends XocAbstractServiceClass implements UserDetailsService {

    public XocSecUserDetailsService() {
        super();
        xocRulesEngine.buildResources(getClass());
    }

    @Autowired
    XocSecUserDetailsCRUD userDetailsRepository;

    @Override
    public XocSecUserDetails loadUserByUsername(String username) throws XocUsernameNotFoundException {
        XocSecUserDetails userDetails;
        List<XocSecUserDetailsDAO> userDetailsDAOList = userDetailsRepository.findByUsername(username);

        try {
            if (userDetailsDAOList.size() == 0) {
                throw new XocUsernameNotFoundException("username " + username + " can not be found");
            }
            userDetails = new XocSecUserDetails();

            XocUserDetailsModel2DAO.USERNAME.mapFrom(userDetailsDAOList.get(0), userDetails);
            executeBR(userDetails);
        }
        catch (XocUsernameNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            throw new XocUsernameNotFoundException("username " + username + " can not be found", e);
        }

        return userDetails;
    }

    private void executeBR(XocSecUserDetails userDetails) {
        List facts = new ArrayList();
        facts.add(userDetails);
        xocRulesEngine.setFacts(facts);
        xocRulesEngine.executeBusinessRules();
    }
}
