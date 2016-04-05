package au.com.zapallo.repositories.dao;

import au.com.zapallo.models.XocSecGrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by aaron.spiteri on 2/03/2016.
 */
@Entity
@Table(name = "grant_authority_userdetails")
public class XocSecGrantedAuthUserDetails implements  Serializable {
    @Id
    @Column(name = "grant_authority_user_details_id", insertable = true, updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grantAuthorityUserDetailsId;

    @Column(name = "authority", insertable = true, updatable = false, unique = false, nullable = false)
    private XocSecGrantedAuthority authority;

    @Column(name = "account_id", insertable = true, updatable = false, unique = false, nullable = false)
    private long account_id;
}
