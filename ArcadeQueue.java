
/**
 * Class to create the queue
 *
 * @amyamyamyamy
 * @2025-07-15
 */

import java.util.ArrayList;

public class ArcadeQueue {
    ArrayList<User> p1 = new ArrayList<User>();
    ArrayList<User> p2 = new ArrayList<User>();

    public void addUser(User user) {
        switch (user.sidePref()) {
            case 0:
                break;
            case 1:
                if (user.isSolo()) {
                    p1.add(user);
                    //p2.add(
                }
                break;
            case 2:
                break;
        }
    }
    
    public void listUsers() {
          System.out.println("Next players: " + p1.get(0) + p2.get(0));
    }
}
