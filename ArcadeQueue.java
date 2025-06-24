
/**
 * Write a description of class Queue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;

public class ArcadeQueue {
    Queue<User> lowPriority = new LinkedList<User>();
    Queue<User> highPriority = new LinkedList<User>();

    public void addUser(User user) {
        if (user.isStaff()) {
            highPriority.add(user);
        } else {
            lowPriority.add(user);
        }
    }
    
    public void listUsers() {
          System.out.println("Next queue member: " + highPriority.peek());
          Iterator<User> it = highPriority.iterator();
          while(it.hasNext()){
              System.out.println(it.next());
          }
    }
}
