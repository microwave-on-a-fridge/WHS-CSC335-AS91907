
/**
 * Class to create the queue
 *
 * @amyamyamyamy
 * @2025-07-15
 */

import java.util.ArrayList;

public class ArcadeQueue {
    private ArrayList<User> p1 = new ArrayList<User>();
    private ArrayList<User> p2 = new ArrayList<User>();

    User soloDummy = new User("", true, false, 0, true); // put this next to someone solo
    User dummyUser = new User("", false, false, 0, true); // put this in an empty spot
    
    public void addUser(User user) {
        switch (user.sidePref()) {
            case 0:
                break;
            case 1:
                if (user.isSolo()) {
                    p1.add(user);
                    p2.add(soloDummy);
                } else {
                    boolean found = false;
                    for (int i=0; i<p1.size(); i++) {
                        if (p1.get(i).isDummy() && !p1.get(i).isSolo()) {
                            p1.set(i, user);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        p1.add(user);
                        p2.add(dummyUser);
                    }
                }
                break;
            case 2:
                if (user.isSolo()) {
                    p1.add(soloDummy);
                    p2.add(user);
                } else {
                    boolean found = false;
                    for (int i=0; i<p1.size(); i++) {
                        if (p2.get(i).isDummy() && !p2.get(i).isSolo()) {
                            p2.set(i, user);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        p1.add(dummyUser);
                        p2.add(user);
                    }
                }
                break;
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
