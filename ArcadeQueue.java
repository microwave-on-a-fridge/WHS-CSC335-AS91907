
/**
 * Class to create the queue
 *
 * @amyamyamyamy
 * @2025-07-28
 */

import java.util.ArrayList;
import java.util.Random;

public class ArcadeQueue {
    private ArrayList<User> p1 = new ArrayList<User>();
    private ArrayList<User> p2 = new ArrayList<User>();

    User soloDummy = new User("soloDummy", true, false, 0, true); // put this next to someone solo
    //User dummyUser = new User("dummyUser", false, false, 0, true); // put this in an empty spot

    // let me cook

    // note to self: this might be very inefficient, look into replacing the dummy user thng
    public void addUser(User user) {
        int side;
        if (user.sidePref() != 0) {
            side = user.sidePref();
        } else {
            if (p1.size() < p2.size()) {
                side = 1;
                System.out.println("p1 side");
            } else if (p1.size() > p2.size()) {
                side = 2;
                System.out.println("p2 side");
            } else {
                side = (int) Math.round(Math.random() + 1);
                System.out.println("rng " + side);
            }
        }

        // theres no way this works how i want it to but fuck it
        if (side == 1) {
            if (user.isSolo()) {
                p1.add(user);
                //p2.add(soloDummy);
            } else {
                if (p2.size() > p1.size() + 1 && p2.get(p1.size() + 1).isSolo()) {
                    p1.add(soloDummy);
                    p1.add(user);
                } else {
                    p1.add(user);
                }
            }
        } else {
            if (user.isSolo()) {
                //p1.add(soloDummy);
                p2.add(user);
            } else {
                if (p1.size() > p2.size() + 1 && p1.get(p2.size() + 1).isSolo()) {
                    p2.add(soloDummy);
                    p2.add(user);
                } else {
                    p2.add(user);
                }
            }
        }
    }

    // i am coding like piratesoftware right now the fuck am i doing
    public void listUsers() {
        boolean what = false;
        while (!what) {
            String p1Name = "";
            String p2Name = "";
            for (int i=0; i<p1.size(); i++) {
                p1Name = p1.get(i).getUsername();
            }
            for (int i=0; i<p2.size(); i++) {
                p2Name = p2.get(i).getUsername();
            }
            System.out.println(p1Name + ", " + p2Name);
        }
    }
}
