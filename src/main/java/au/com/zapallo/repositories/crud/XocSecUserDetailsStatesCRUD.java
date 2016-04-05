package au.com.zapallo.repositories.crud;

import au.com.zapallo.repositories.dao.XocSecUserDetailsStatesDAO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aaron.spiteri on 1/03/2016.
 */
public interface XocSecUserDetailsStatesCRUD extends JpaRepository<XocSecUserDetailsStatesDAO, Long> {
}
