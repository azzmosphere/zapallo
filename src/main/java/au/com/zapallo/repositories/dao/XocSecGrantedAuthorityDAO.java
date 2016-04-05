package au.com.zapallo.repositories.dao;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by aaron.spiteri on 1/03/2016.
 */
@Entity
@Table(name = "grant_authority")
public class XocSecGrantedAuthorityDAO  implements Serializable {
    @Id
    @Column(name = "grant_authority_id", insertable = true, updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grantAuthorityId;

    @Column(name = "authority", insertable = true, updatable = false, unique = false, nullable = false)
    private String authority;
}
