package au.com.zapallo.repositories.dao;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by aaron.spiteri on 3/03/2016.
 */
@Entity
@Table(name = "bre_resources")
public class XocBreDAO implements  Serializable {
    @Id
    @Column(name = "bre_resources_id", insertable = true, updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bre_resources_id;

    @Column(name = "resource_location", insertable = true, updatable = false, unique = false, nullable = false)
    private String resource_location;

    @Column(name = "class_name", insertable = true, updatable = false, unique = false, nullable = false)
    private String class_name;

    @Column(name = "resource_type", insertable = true, updatable = false, unique = false, nullable = false)
    private String resource_type;

    public Long getBreResourcesId() {
        return bre_resources_id;
    }

    public void setBreResourcesId(Long bre_resources_id) {
        this.bre_resources_id = bre_resources_id;
    }

    public String getResourceLocation() {
        return resource_location;
    }

    public void setResourceLocation(String resource_location) {
        this.resource_location = resource_location;
    }

    public String getClassName() {
        return class_name;
    }

    public void setClassName(String class_name) {
        this.class_name = class_name;
    }

    public void setResourceType(String resourceType) {
        this.resource_type = resourceType;
    }

    public String getResourceType() {
        return resource_type;
    }
}
