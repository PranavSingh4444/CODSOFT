import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRange = 100;
        int maxAttempts = 7;
        int score = 0;
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI have picked a number between 1 and " + maxRange + ". Try to guess it!");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number in " + attempts + " attempt(s).");
                    score += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println(" Too low!");
                } else {
                    System.out.println(" Too high!");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println(" You've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }

        System.out.println("\n Game Over. Your final score is: " + score);
        scanner.close();
    }
}