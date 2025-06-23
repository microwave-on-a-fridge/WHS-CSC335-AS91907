
/**
 * Main class for my AS91907 arcade game "maimai" queue project.
 * 
 * if i could control rewind, i would want... fortnite. and marques brownlee
 *
 * @AMY!!!!!!
 * @2025-06-23
 */

public class main {
    public static void main(String[] args) {
        final String[] MENU_OPTIONS = {"o", "c", "l", "g", "d", "w", "q"};
        String option;
        boolean running = true;

        ArcadeQueue queue = new ArcadeQueue();

        while (running) {
            System.out.println("maimai Queue System");
            System.out.println("-------------------");
            System.out.println("A: Add someone to the queue");
            System.out.println("R: Remove someone from the queue");
            System.out.println("C: Check the queue");

            option = Input.menu("", MENU_OPTIONS);
            
            switch (option) {
                case "a":
                    Input.clear();
                    //queue.addUser(createUser());
            }
        }
    }
    
    public static User createUser() {
        final String[] ILLEGAL = {","};
        String username = Input.stringNoChar("Please input a username less than 8 characters.", 8, ILLEGAL);
        boolean isSolo = Input.yesNo("Are you solo queueing? (y/N)", false);
        boolean isStaff = Input.yesNo("Are you a staff member? (y/N)", false);
        int sidePreference = Input.integer("Please choose a side [placeholder add more text]", 2);
        User user = new User(username, isSolo, isStaff, sidePreference);
        return(user);
    }
}
