package au.com.zapallo.repositories.crud;

import au.com.zapallo.repositories.dao.XocSecUserDetailsDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Created by aaron.spiteri on 1/03/2016.
 */
public interface XocSecUserDetailsCRUD  extends JpaRepository<XocSecUserDetailsDAO, Long> {
    List<XocSecUserDetailsDAO> findByAccountId(Long accountId);

    List<XocSecUserDetailsDAO> findByUsername(String username);
}
