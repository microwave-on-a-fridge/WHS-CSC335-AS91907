
/**
 * Class to create individual profiles (members of a queue)
 *
 * @AMYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
 * @2025-07-28
 */

public class User {
    private String username;
    private boolean solo;
    private boolean staff;
    private int sidePreference;
    
    private boolean dummy; // not set by the user
    
    public User(String username, boolean solo, boolean staff, int sidePreference, boolean dummy) {
        this.username = username;
        this.solo = solo;
        this.staff = staff;
        this.dummy = dummy;
        this.sidePreference = sidePreference;
    }
    
    public String getUsername() {
        return(this.username);
    }
    
    public boolean isSolo() {
        return(this.solo);
    }
    
    public boolean isStaff() {
        return(this.staff);
    }
    
    public int sidePref() {
        return(this.sidePreference);
    }
    
    public boolean isDummy() { // if someone is solo queueing or if there is a free space use this
        return(this.dummy);
    }
}
