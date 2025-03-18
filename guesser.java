import java.util.Scanner;

public class Guesser {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menuLoop(sc);
        sc.close();
    }

    // Menu and Main Loop
    public static void menuLoop(Scanner sc) {
        int choice;
        do {
            System.out.println("\n0) Exit");
            System.out.println("1) Human Guesser");
            System.out.println("2) Computer Guesser");
            System.out.print("\nPlease enter 0-2: ");
            
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number (0-2): ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    humanGuesser(sc);
                    break;
                case 2:
                    computerGuesser(sc);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    // Human tries to guess the computer's number
    public static void humanGuesser(Scanner sc) {
        int secretNumber = (int) (Math.random() * 100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("\nHuman Guesser Mode");
        System.out.println("(I'm thinking of a number between 1 and 100)");

        do {
            System.out.print("Please enter a number: ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                sc.next();
            }
            guess = sc.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("too low...");
            } else if (guess > secretNumber) {
                System.out.println("too high...");
            } else {
                System.out.println("got it!");
                System.out.println("Very good! You guessed it in " + attempts + " tries.");
            }
        } while (guess != secretNumber);
    }

    // Computer tries to guess the human's number
    public static void computerGuesser(Scanner sc) {
        int low = 1;
        int high = 100;
        int guess;
        String feedback;
        int guessCount = 1;

        System.out.println("\nComputer Guesser Mode");
        System.out.println("Think of a number between 1 and 100. I'll guess it!");

        while (low <= high) {
            guess = (low + high) / 2;
            System.out.println(guessCount + ") I guess " + guess);
            System.out.print("Too (H)igh, too (L)ow, or (C)orrect? ");
            feedback = sc.next().toLowerCase();

            if (feedback.equals("h")) {
                high = guess - 1;
            } else if (feedback.equals("l")) {
                low = guess + 1;
            } else if (feedback.equals("c")) {
                System.out.println("I got it in " + guessCount + " tries!");
                break;
            } else {
                System.out.println("Invalid input. Please respond with H, L, or C.");
                continue;  // Repeat the same guess if input is invalid
            }
            guessCount++;
        }
    }
}
