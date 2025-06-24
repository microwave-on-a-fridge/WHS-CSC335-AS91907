
/**
 * Write a description of class Profile here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    
    public int getSidePref() {
        return(this.sidePreference);
    }
}
