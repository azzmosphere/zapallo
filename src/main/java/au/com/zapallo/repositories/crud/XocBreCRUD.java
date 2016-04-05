package au.com.zapallo.repositories.crud;

import au.com.zapallo.repositories.dao.XocBreDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by aaron.spiteri on 3/03/2016.
 */
public interface XocBreCRUD extends JpaRepository<XocBreDAO, Long>  {
    List<XocBreDAO> findByClassName(String class_name);
}
