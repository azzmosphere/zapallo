package au.com.zapallo.repositories.dao;

import au.com.zapallo.models.XocSecUserDetailsStates;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import javax.mail.internet.InternetAddress;
/**
 * Created by aaron.spiteri on 22/02/2016.
 */
@Entity
@Table(name = "user_details")
public class XocSecUserDetailsDAO implements Serializable {
    @Id
    @Column(name = "account_id", insertable = true, updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;

    @Column(name = "username", insertable = true, updatable = true, unique = true, nullable = false)
    private String username;

    @Column(name = "encrypted_password", insertable = true, updatable = true, unique = false, nullable = false)
    private String encrypted_password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cdate", insertable = true, updatable = false, unique = false, nullable = false)
    private Date cdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mdate", insertable = true, updatable = true, unique = false, nullable = false)
    private Date mdate;

    @Column(name = "local_string", insertable = true, updatable = true, unique = false, nullable = false)
    private Locale locale;

    @Column(name = "email_address", insertable = true, updatable = true, unique = false, nullable = false)
    private InternetAddress email_address;

    @Column(name = "account_state", insertable = true, updatable = true, unique = false, nullable = false)
    private XocSecUserDetailsStates account_state;

    @Column(name = "longitude_cord", insertable = true, updatable = true, unique = false, nullable = true)
    private String longitude_cord;

    @Column(name = "latitude_cord", insertable = true, updatable = true, unique = false, nullable = true)
    private String latitude_cord;

    public Long getAccountId() {
        return account_id;
    }

    public void setAccountId(Long account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encrypted_password;
    }

    public void setEncryptedPassword(String encrypted_password) {
        this.encrypted_password = encrypted_password;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public InternetAddress getEmailAddress() {
        return email_address;
    }

    public void setEmailAddress(InternetAddress email_address) {

        this.email_address = email_address;
    }

    public XocSecUserDetailsStates getAccountState() {
        return account_state;
    }

    public void setAccountState(XocSecUserDetailsStates account_state) {
        this.account_state = account_state;
    }

    public String getLongitudeCord() {
        return longitude_cord;
    }

    public void setLongitudeCord(String longitude_cord) {
        this.longitude_cord = longitude_cord;
    }

    public String getLatitudeCord() {
        return latitude_cord;
    }

    public void setLatitudeCord(String latitude_cord) {
        this.latitude_cord = latitude_cord;
    }
}
