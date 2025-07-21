
/**
 * Main class for my AS91907 arcade game "maimai" queue project.
 * 
 * if i could control rewind, i would want... fortnite. and marques brownlee
 *
 * @AMY!!!!!!
 * @2025-07-22
 */

public class main {
    public static void main(String[] args) {
        final String[] MENU_OPTIONS = {"n", "a", "r", "c", "q"};
        String option;
        boolean running = true;

        ArcadeQueue queue = new ArcadeQueue();

        while (running) {
            System.out.println("maimai Queue System");
            System.out.println("-------------------");
            System.out.println("N: Move to next entry in the queue");
            System.out.println("A: Add someone to the queue");
            System.out.println("R: Remove someone from the queue");
            System.out.println("C: Check the queue");
            System.out.println("Q: Quit");

            option = Input.menu("", MENU_OPTIONS);
            
            switch (option) {
                case "n":
                    Input.clear();
                    // next user
                    break;
                case "a":
                    Input.clear();
                    queue.addUser(createUser());
                    break;
                case "r":
                    Input.clear();
                    // removal stuff
                    break;
                case "c":
                    Input.clear();
                    queue.listUsers();
                    break;
                case "q":
                    Input.clear();
                    System.exit(0);
                    break;
            }
        }
    }
    
    public static User createUser() {
        final String[] ILLEGAL = {","};
        String username = Input.stringNoChar("Please input a username less than 8 characters.", 8, ILLEGAL);
        boolean solo = Input.yesNo("Are you solo queueing? (y/N)", false);
        boolean staff = Input.yesNo("Are you a staff member? (y/N)", false);
        boolean hasSidePreference = Input.yesNo("Do you have a side preference? (Y/n)", true);
        int sidePreference = 0;
        if (hasSidePreference) {
            sidePreference = Input.integer("Do you prefer player 1 or player 2 side?", 2);
        }
        User user = new User(username, solo, staff, sidePreference, false);
        return(user);
    }
}
