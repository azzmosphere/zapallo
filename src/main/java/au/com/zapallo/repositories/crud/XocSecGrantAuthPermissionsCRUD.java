package au.com.zapallo.repositories.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Created by aaron.spiteri on 1/03/2016.
 */
public interface XocSecGrantAuthPermissionsCRUD extends JpaRepository<XocSecGrantAuthPermissionsDAO, Long> {
    List<XocSecGrantAuthPermissionsDAO> findByPermissionID(Long permissionId);
}
