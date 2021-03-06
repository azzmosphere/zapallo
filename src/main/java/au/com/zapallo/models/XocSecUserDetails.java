package au.com.zapallo.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.mail.internet.InternetAddress;
import java.util.Date;
import java.util.Locale;
import java.util.Collection;
import java.util.HashMap;


/**
 * Created by aaron.spiteri on 22/02/2016.
 */
public class XocSecUserDetails implements UserDetails, XocSecPermsInterface {
    private Long account_id;
    private String username;
    private String encrypted_password;
    private Date cdate;
    private Date mdate;
    private Locale locale;
    private InternetAddress email_address;
    private XocSecUserDetailsStates account_state;
    private String longitude_cord;
    private String latitude_cord;
    private Collection<? extends GrantedAuthority> grantedAuthorities;
    private final XocSecPermsBase xocSecPermsBase = new XocSecPermsBase();

    public static final String KEY_ACCOUNT_EXPIRED = "account_expired";
    public static final String KEY_ACCOUNT_LOCKED = "account_locked";
    public static final String KEY_CREDITIALS_EXPIRED = "creditals_expired";
    public static final String KEY_ENABLED = "enabled";

    // Account truth attrbutes
    private HashMap<String, String>  accountAttributes = new HashMap<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }
    @Override
    public String getPassword() {
        return encrypted_password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isPermitted(KEY_ACCOUNT_EXPIRED);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isPermitted(KEY_ACCOUNT_LOCKED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isPermitted(KEY_CREDITIALS_EXPIRED);
    }

    @Override
    public boolean isEnabled() {
        return isPermitted(KEY_ENABLED);
    }

    public void setGrantedAuthorities(Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    public Long getAccountId() {
        return account_id;
    }

    public void setAccountId(Long account_id) {
        this.account_id = account_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return getPassword();
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

    public void setLongitudeCord(String longitude_cord) {
        this.longitude_cord = longitude_cord;
    }

    public String getLatitudeCord() {
        return latitude_cord;
    }

    public void setLatitudeCord(String latitude_cord) {
        this.latitude_cord = latitude_cord;
    }

    public String getLongitudeCord() {
        return longitude_cord;
    }

    public void setAccountAttributes(String key, String attr) {
        accountAttributes.put(key, attr);
    }

    public Object getAccountAttribute(String key) {
        return accountAttributes.get(key);
    }

    /**
     *
     * Checks the userDetails objects first for right, if it is permitted then
     * will
     * @param right
     * @return true if permitted otherwise false
     */
    @Override
    public Boolean isPermitted(String right) {
        Boolean permitted =  xocSecPermsBase.isPermitted(right);

        if (!(permitted || xocSecPermsBase.hasPermission(right))) {
            for (XocSecGrantedAuthority authority : (Collection<XocSecGrantedAuthority>) grantedAuthorities) {
                if (authority.hasPermission(right)) {
                    permitted = authority.isPermitted(right);
                    break;
                }
            }
        }
        return permitted;
    }

    @Override
    public void setIsPermitted(String right, Boolean value) {
        xocSecPermsBase.setIsPermitted(right, value);
    }
}
