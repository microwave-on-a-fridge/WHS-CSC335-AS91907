
/**
 * Write a description of class Profile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User {
    private String username;
    private boolean isSolo;
    private boolean isStaff;
    private int sidePreference;
    
    public User(String username, boolean isSolo, boolean isStaff, int sidePreference) {
        this.username = username;
        this.isSolo = isSolo;
        this.isStaff = isStaff;
        this.sidePreference = sidePreference;
    }
}
