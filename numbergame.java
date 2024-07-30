import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            playRound(scanner);
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Game over! Your final score is: " + score);
        scanner.close();
    }

    private static void playRound(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attemptsLeft = MAX_ATTEMPTS;
        boolean hasGuessedCorrectly = false;

        System.out.println("A number between " + MIN_NUMBER + " and " + MAX_NUMBER + " has been generated.");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

        while (attemptsLeft > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attemptsLeft--;

            if (userGuess == numberToGuess) {
                hasGuessedCorrectly = true;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            System.out.println("Attempts left: " + attemptsLeft);
        }

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You've guessed the number.");
            score += (MAX_ATTEMPTS - attemptsLeft);
        } else {
            System.out.println("Sorry, you've run out of attempts. The number was: " + numberToGuess);
        }
    }
}
