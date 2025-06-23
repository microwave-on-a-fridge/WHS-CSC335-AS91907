
/**
 * Write a description of class Queue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Queue;
import java.util.LinkedList;

public class ArcadeQueue {
    Queue<User> lowPriority = new LinkedList<User>();
    Queue<User> highPriority = new LinkedList<User>();
    
    public void addUser() {
        
        /**
         * pseudocode
         * if (user == staff) {
         *     highPriority.add(user);
         * } else {
         *     lowPriority.add(user);
         * }
         */
    }
}
