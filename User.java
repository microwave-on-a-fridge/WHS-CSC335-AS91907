
/**
 * Class to create individual profiles (members of a queue)
 *
 * @AMYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
 * @2025-07-28
 */

public class User {
    private String username;
    private boolean solo;
    
    public User(String username, boolean solo) {
        this.username = username;
        this.solo = solo;
    }
    
    public String getUsername() {
        return(this.username);
    }
    
    public boolean isSolo() {
        return(this.solo);
    }
}
