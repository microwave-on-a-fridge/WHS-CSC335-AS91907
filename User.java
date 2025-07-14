
/**
 * Class to create individual profiles (members of a queue)
 *
 * @AMYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
 * @2025-07-15
 */

public class User {
    private String username;
    private boolean solo;
    private boolean staff;
    private int sidePreference;
    
    public User(String username, boolean solo, boolean staff, int sidePreference) {
        this.username = username;
        this.solo = solo;
        this.staff = staff;
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
}
