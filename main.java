
/**
 * Main class for my AS91907 arcade game "maimai" queue project.
 * 
 * if i could control rewind, i would want... fortnite. and marques brownlee
 *
 *
 * i dont know what happened here i feel like i was working on this and i blinked and
 * then all of a sudden it was due in 3 days
 * i had to remove a lot of stuff unfortunately due to time constraints and stuff
 * very sad! not proud of my work at all for this one but whatever i did my best :p
 * the idea of doing your best isnt very helpful though because whoever marks your work
 * isnt going to give you a better grade if you tell them you tried really hard
 * whatever
 * 
 * 
 * 
 * @amy
 * @2025-08-06
 */

public class main {
    public static void main(String[] args) {
        final String[] MENU_OPTIONS = {"n", "a", "r", "v", "q"};
        String read;
        String write;
        String option;
        boolean running = true;

        /* take command line argument for optional different csv to use */
        if (args.length == 1) {
            System.out.println("Using \"" + args[0] + "\" as CSV file.");
            read = args[0];
            write = args[0];
        } else if (args.length == 2) { // if 2 csv are provided, read csv 1 and write to csv2
            System.out.println("Reading from \"" + args[0] + "\" and writing to \"" + args[1] + "\".");
            read = args[0];
            write = args[1];
        } else if (args.length > 2) { // if too many args, fallback to default
            System.out.println("Too many arguments, please input either one CSV or two (one to read from one to write to).");
            System.out.println("Falling back to default CSV (queueData.csv).");
            read = "queueData.csv";
            write = "queueData.csv";
        } else {
            read = "queueData.csv";
            write = "queueData.csv";
        }
        
        ArcadeQueue queue = new ArcadeQueue();
        queue.readCSV(read);

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
                    queue.removeUser(Input.string("Please input a user to remove.", 8));
                    break;
                case "v":
                    Input.clear();
                    queue.listUsers();
                    break;
                case "q":
                    queue.writeCSV(write);
                    System.out.println("Exiting...");
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
