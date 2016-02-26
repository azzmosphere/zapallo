package au.com.zapallo.repositories.dao;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by aaron.spiteri on 26/02/2016.
 */
@Entity
@Table(name = "user_details_permissions")
public class XocSecUserDetailsPermissionsDAO implements Serializable {
    @Id
    @Column(name = "permissions_id", insertable = true, updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissions_id;

    @Column(name = "account_id", insertable = true, updatable = false, unique = false, nullable = false)
    private Long account_id;

    @Column(name = "perm_key", insertable = true, updatable = false, unique = false, nullable = false)
    private String perm_key;

    @Column(name = "is_allowed", insertable = true, updatable = false, unique = false, nullable = false)
    private Boolean is_allowed;

    public Long getPermissions_id() {
        return permissions_id;
    }

    public void setPermissions_id(Long permissions_id) {
        this.permissions_id = permissions_id;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public String getPerm_key() {
        return perm_key;
    }

    public void setPerm_key(String perm_key) {
        this.perm_key = perm_key;
    }

    public Boolean getIs_allowed() {
        return is_allowed;
    }

    public void setIs_allowed(Boolean is_allowed) {
        this.is_allowed = is_allowed;
    }
}
