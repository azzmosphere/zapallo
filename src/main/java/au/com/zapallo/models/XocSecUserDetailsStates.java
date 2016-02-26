package au.com.zapallo.models;

/**
 * Created by aaron.spiteri on 22/02/2016.
 */
public enum XocSecUserDetailsStates {
    /**
     * Account is pending deletion.
     */
    ACCOUNT_DELETED,

    /**
     * Locked pending a modification.
     */
    ACCOUNT_LOCKED,

    /**
     * Account has been suspended by a administrator
     */
    ACCOUNT_SYSTEM_SUSPENDED,

    /**
     * Disabled at user request
     */
    ACCOUNT_USER_DISABLED,

    /**
     * Disabled at the by admin
     */
    ACCOUNT_SYSTEM_DISABLED,

    /**
     * Pending activation
     */
    ACCOUNT_PENDING,

    /**
     * Active.
     */
    ACCOUNT_ACTIVE,

    /**
     * Needs verification before active
     */
    ACCOUNT_PENDING_VERIFICATION,

    /**
     * Expired due to inactivity
     */
    ACCOUNT_EXPIRED,

    /**
     * Creditials have expired.
     */
    ACCOUNT_CREDITIALS_EXPIRED;
}
