package au.com.zapallo.repositories.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 * Created by aaron.spiteri on 26/02/2016.
 */
@Entity
@Table(name = "user_details_states")
public class XocSecUserDetailsStatesDAO {
    @Id
    @Column(name = "user_details_state_id", insertable = true, updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userDetailsStateId;

    @Column(name = "state_name", insertable = true, updatable = false, unique = true, nullable = true)
    private String stateName;
}
