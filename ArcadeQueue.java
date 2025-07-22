
/**
 * Class to create the queue
 *
 * @amyamyamyamy
 * @2025-07-22
 */

import java.util.ArrayList;
import java.util.Random;

public class ArcadeQueue {
    private ArrayList<User> p1 = new ArrayList<User>();
    private ArrayList<User> p2 = new ArrayList<User>();

    User soloDummy = new User("soloDummy", true, false, 0, true); // put this next to someone solo
    User dummyUser = new User("dummyUser", false, false, 0, true); // put this in an empty spot

    // let me cook
    
    // note to self: this might be very inefficient, look into replacing the dummy user thng
    public void addUser(User user) {
        int side;
        if (user.sidePref() != 0) {
            side = user.sidePref();
        } else {
            boolean lock = false;
            int p1Number = 0;
            int p2Number = 0;
            for (int i=0; i<p1.size(); i++) {
                if (p1.get(i).isDummy() && !p1.get(i).isSolo()) {
                    if (!lock) {
                        p1Number = i;
                        lock = true;
                        System.out.println("p1 length " + p1Number);
                    }
                }
            }
            lock = false;
            for (int i=0; i<p2.size(); i++) {
                if (p2.get(i).isDummy() && !p2.get(i).isSolo()) {
                    if (!lock) {
                        p2Number = i;
                        lock = true;
                        System.out.println("p2 length " + p2Number);
                    }
                }
            }

            if (p1Number < p2Number) {
                side = 1;
                System.out.println("p1 side");
            } else if (p1Number > p2Number) {
                side = 2;
                System.out.println("p2 side");
            } else {
                side = (int) Math.round(Math.random() + 1);
                System.out.println("rng " + side);
            }
        }

        if (side == 1) {
            if (user.isSolo()) {
                p1.add(user);
                p2.add(soloDummy);
            } else {
                boolean found = false;
                for (int i=0; i<p1.size(); i++) {
                    if (p1.get(i).isDummy() && !p1.get(i).isSolo()) {
                        p1.set(i, user);
                        found = true;
                        return;
                    }
                }
                if (!found) {
                    p1.add(user);
                    p2.add(dummyUser);
                }
            }
        } else {
            if (user.isSolo()) {
                p1.add(soloDummy);
                p2.add(user);
            } else {
                boolean found = false;
                for (int i=0; i<p2.size(); i++) {
                    if (p2.get(i).isDummy() && !p2.get(i).isSolo()) {
                        p2.set(i, user);
                        found = true;
                        return;
                    }
                }
                if (!found) {
                    p1.add(dummyUser);
                    p2.add(user);
                }
            }
        }
    }

    public void listUsers() {
        for (int i=0; i<p1.size(); i++) {
            if (p1.get(i).isDummy() || p2.get(i).isDummy()) {
                System.out.println(p1.get(i).getUsername() + p2.get(i).getUsername());
            } else {
                System.out.println(p1.get(i).getUsername() + ", " + p2.get(i).getUsername());
            }
        }
    }
}
