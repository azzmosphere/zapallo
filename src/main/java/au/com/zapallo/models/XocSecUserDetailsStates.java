package au.com.zapallo.models;

/**
 * Created by aaron.spiteri on 22/02/2016.
 */
public class XocSecUserDetailsStates {
    private long userDetailsStateId;
    private String stateName;

    public long getUserDetailsStateId() {
        return userDetailsStateId;
    }

    public void setUserDetailsStateId(long userDetailsStateId) {
        this.userDetailsStateId = userDetailsStateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public XocSecUserDetailsStates(long userDetailsStateId, String stateName) {
        this.userDetailsStateId = userDetailsStateId;
        this.stateName = stateName;
    }
}
