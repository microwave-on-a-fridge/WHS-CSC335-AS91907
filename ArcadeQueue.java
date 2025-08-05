
/**
 * Class to create the queue
 *
 * @amyamyamyamy
 * @2025-08-06
 */

import java.util.ArrayList;
import java.util.Random;

public class ArcadeQueue {
    private ArrayList<User> queue = new ArrayList<User>();

    /* this is so miserable i gutted all this at the last minute because it did not work
     * and i would fail if i left it how it was lmao but now its just sad small bit of code
     * whateverrrrrrrrrr
     */
    public void addUser(User user) {
        queue.add(user);
    }

    // i am coding like piratesoftware right now the fuck am i doing
    public void listUsers() {
        for (int i = 0; i < queue.size(); i++) { // i will start writing these with spaces
            System.out.println(queue.get(i).getUsername());
        }
    }
    
    /* this actually works ztf */
    public void nextPlayers() {
        if (queue.get(0).isSolo()) {
            System.out.println("Next player: " + queue.get(0).getUsername());
            queue.remove(0);
        } else if (queue.get(1).isSolo()) {
            boolean lock = false;
            int otherPlayer = 0;
            for (int i = 0; i < queue.size(); i++) {
                if (!queue.get(i).isSolo() && !lock) {
                    otherPlayer = i;
                    lock = true;
                }
            }
            System.out.println("Next players: " + queue.get(0).getUsername() + ", " + queue.get(otherPlayer).getUsername());
            queue.remove(0);
            queue.remove(otherPlayer);
        } else {
            System.out.println("Next players: " + queue.get(0).getUsername() + ", " + queue.get(1).getUsername());
            queue.remove(0);
            /* what was entry 1 will become entry 0 because we just removed 0 on the line above */
            queue.remove(0);
        }
    }
}
