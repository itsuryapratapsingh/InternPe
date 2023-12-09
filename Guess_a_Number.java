import java.util.Random;
import java.util.Scanner;

public class Guess_a_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to Guess the Number game!");
        System.out.println("Try to guess the number between " + lowerBound + " and " + upperBound);

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == secretNumber) {
                hasGuessedCorrectly = true;
            } else if (userGuess < secretNumber) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        }

        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        scanner.close();
    }
}
