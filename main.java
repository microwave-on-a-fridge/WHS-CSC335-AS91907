
/**
 * Main class for my AS91907 arcade game "maimai" queue project.
 * 
 * if i could control rewind, i would want... fortnite. and marques brownlee
 *
 * @AMY!!!!!!
 * @2025-08-06
 */

public class main {
    public static void main(String[] args) {
        final String[] MENU_OPTIONS = {"n", "a", "r", "v", "q"};
        String option;
        boolean running = true;

        ArcadeQueue queue = new ArcadeQueue();

        while (running) {
            System.out.println("maimai Queue System");
            System.out.println("-------------------");
            System.out.println("N: Display the next players and remove them from the queue");
            System.out.println("A: Add someone to the queue");
            System.out.println("R: Remove someone from the queue");
            System.out.println("V: View the whole queue");
            System.out.println("Q: Quit");

            option = Input.menu("", MENU_OPTIONS);
            
            switch (option) {
                case "n":
                    Input.clear();
                    queue.nextPlayers();
                    break;
                case "a":
                    Input.clear();
                    queue.addUser(createUser());
                    break;
                case "r":
                    Input.clear();
                    // removal stuff
                    break;
                case "v":
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
        String username = Input.stringNoChar("Please input a username 8 characters or less.", 8, ILLEGAL);
        boolean solo = Input.yesNo("Are you solo queueing? (y/N)", false);
        User user = new User(username, solo);
        return(user);
    }
}
