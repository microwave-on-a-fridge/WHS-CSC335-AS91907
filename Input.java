
/**
 * Class to handle different kinds of input.
 *
 * @Amy Hina
 * @2025-04-11
 */

import java.util.Scanner; // for keyboard input

public class Input {
    /* handle input selecting from an array of options (menu input) */
    public static String menu(String textPrompt, String[] MENU_OPTIONS) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean found = false;

        while (!found) {
            System.out.println(textPrompt);
            input = keyboard.nextLine().toLowerCase();
            for (int i=0; i<MENU_OPTIONS.length; i++) {
                if (input.equals(MENU_OPTIONS[i])) {
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Invalid input.");
            }
        }
        return(input);
    }

    /* check for a number, basically menu input but number instead of item */
    public static int numCheck(String textPrompt, String[] MENU_OPTS) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        int output = -1;
        boolean found = false;

        while (!found) {
            System.out.println(textPrompt);
            input = keyboard.nextLine().toLowerCase();
            for (int i=0; i<MENU_OPTS.length; i++) {
                if (input.equals(MENU_OPTS[i])) {
                    output = i;
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Invalid input.");
            }
        }
        return(output);
    }

    /* simple string input, can specify a max length */
    public static String string(String textPrompt, int stringLength) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        System.out.println(textPrompt);
        boolean found = false;
        while (!found) {
            input = keyboard.nextLine();
            if (input.equals("")) {
                System.out.println("Please enter something.");
                keyboard.nextLine();
            } else if (input.length() > stringLength) {
                System.out.println("Too long, please enter something less than " + stringLength + " characters long.");
                keyboard.nextLine();
            } else {
                found = true;
            }
        }
        return(input);
    }

    /* string input but remove illegal characters */
    public static String stringNoChar(String textPrompt, int stringLength, String[] illegal) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        System.out.println(textPrompt);
        boolean found = false;
        while (!found) {
            input = keyboard.nextLine();
            if (input.equals("")) {
                System.out.println("Please enter something.");
                keyboard.nextLine();
            } else if (input.length() > stringLength) {
                System.out.println("Too long, please enter something less than " + stringLength + " characters long.");
                keyboard.nextLine();
            } else {
                boolean duplicate = false;
                int illegalNum = -1;
                for (int i=0; i<illegal.length; i++) {
                    if (input.contains(illegal[i])) {
                        illegalNum = i;
                        duplicate = true;
                    }
                }
                if (!duplicate) {
                    found = true;
                } else {
                    System.out.println("Please make sure your input does not contain \"" + illegal[illegalNum] + "\".");
                    keyboard.nextLine();
                }
            }
        }
        return(input);
    }

    /* simple integer input */
    public static int integer(String textPrompt, int intLength) {
        Scanner keyboard = new Scanner(System.in);
        int input = -1;
        boolean found = false;
        System.out.println(textPrompt);
        while (!found) {
            if (keyboard.hasNextInt()) {
                input = keyboard.nextInt();
                if (input <= 0) {
                    System.out.println("Please enter something.");
                    keyboard.nextLine();
                } else if (input > intLength) {
                    System.out.println("Option " + input + " does not exist.");
                    keyboard.nextLine();
                } else {
                    found = true;
                }
            } else {
                System.out.println("Please enter a valid number.");
                keyboard.nextLine();
            }
        }
        return(input);
    }

    /* simple double input */
    public static double doub(String textPrompt, double doubleLength) {
        Scanner keyboard = new Scanner(System.in);
        double input = -1;
        boolean found = false;
        System.out.println(textPrompt);
        while (!found) {
            if (keyboard.hasNextDouble()) {
                input = keyboard.nextDouble();
                if (input <= 0) {
                    System.out.println("Please enter a positive number.");
                    keyboard.nextLine();
                } else if (input > doubleLength) {
                    System.out.println("Too big, please enter something less than " + doubleLength + ".");
                    keyboard.nextLine();
                } else {
                    found = true;
                }
            } else {
                System.out.println("Please enter a valid number.");
                keyboard.nextLine();
            }
        }
        System.out.println(input);
        return(input);
    }

    /** 
     * yes/no input, if nothing is entered it defaults to the customizable default option
     * e.g. if the prompt is y/N, defaultValue = false, and then if enter is hit without
     * specifying it will be the defaultValue (in this case, no/false). this was inspired
     * by the command like programs i use on the daily because lots of them have this
     * feature which i think is a good thing to add for convenience and usability
     * 
     * for the actual functionality, the array is alternating between yes or no options
     * so that when it runs input % 2 (basically checking if its even or odd), then it can
     * base what the input is off that. this means if i wanted to i could add more words
     * that would work in the future, like "yeah" and "nah" (but i dont want to add those)
     */
    public static boolean yesNo(String textPrompt, boolean defaultValue) {
        Scanner keyboard = new Scanner(System.in);
        final String[] YES_NO_INPUTS = {"yes", "no", "y", "n", ""};
        System.out.println(textPrompt);
        int input = numCheck("", YES_NO_INPUTS);
        if (defaultValue == true && input == YES_NO_INPUTS.length-1) {
            return(true);
        } else if (!defaultValue && input == YES_NO_INPUTS.length-1) {
            return(false);
        } else if (input % 2 == 0) {
            return(true);
        } else {
            return(false);
        }
    }
    
    /* this isn't input obviously but it just feels like the right place to put it */
    public static void clear() {
        System.out.print("\u000c"); // clear the screen
    }
}
