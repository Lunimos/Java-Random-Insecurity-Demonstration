import java.util.Random;
import java.util.Scanner;

public class Random_insecure {
    public static void main(String[] args) {
        Random number = new Random(12L); // random seed change number for different seed
        int gold = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I've selected a number between 0 and 20. Can you guess it?");
        
        int targetNumber = number.nextInt(21); // Generate the target number
        
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        
        while (true) {
            System.out.print("Enter your guess (between 0 and 20): ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess < targetNumber) {
                System.out.println("Too low. Try again!");
            } else if (guess > targetNumber) {
                System.out.println("Too high. Try again!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                gold += 10; // Add 10 gold for each correct guess
                System.out.println("You earned 10 gold! Total gold: " + gold);
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next();
                if (playAgain.equalsIgnoreCase("yes")) {
                    targetNumber = number.nextInt(21); // Generate a new target number
                    attempts = 0;
                } else {
                    break;
                }
            }
        }
        
        scanner.close();
    }
}
