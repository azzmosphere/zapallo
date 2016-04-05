package au.com.zapallo.repositories.crud;

import au.com.zapallo.repositories.dao.XocSecGrantedAuthorityDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Created by aaron.spiteri on 1/03/2016.
 */
public interface XocSecGrantedAuthorityCRUD extends JpaRepository<XocSecGrantedAuthorityDAO, Long> {
    List<XocSecGrantedAuthorityDAO> findByGrantAuthorityId(Long grantAuthorityId);
}
