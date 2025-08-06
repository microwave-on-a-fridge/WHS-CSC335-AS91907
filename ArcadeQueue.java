
/**
 * Class to create the queue
 *
 * @amyamyamyamy
 * @2025-08-06
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; // for file reading
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
            if (queue.get(i).isSolo()) {
                System.out.println(queue.get(i).getUsername() + " (solo)");
            } else {
                System.out.println(queue.get(i).getUsername());
            }
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
    
    public void removeUser(String username) {
        boolean found = false;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getUsername().equals(username)) {
                queue.remove(i);
                System.out.println("Successfully removed " + username);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Unable to find \"" + username + "\", please make sure this user exists.");
        }
    }
    
    /* file stuff below */

    public void readCSV(String fileName) {
        File csvFile = new File(fileName);
        try {
            Scanner reader = new Scanner(csvFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] separated = line.split(",");
                /* add the values from the array of comma separated items to a new account */
                this.queue.add(new User(separated[0], Boolean.parseBoolean(separated[1])));
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
    }

    /* write the queue info to a CSV */
    public void writeCSV(String fileName) {
        File csvFile = new File(fileName);
        try {
            FileWriter writer = new FileWriter(csvFile);
            for (User user : queue) {
                writer.write(user.getUsername() + ",");
                writer.write(user.isSolo() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}
