package CodeSoftTasks;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static int playGame() {
        Random rand = new Random();
        int targetNumber = rand.nextInt(100) + 1;  // Generate random number between 1 and 100
        int attemptsLeft = 10;  // Maximum 10 attempts
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between 1 and 100. You have " + attemptsLeft + " attempts.");

        while (attemptsLeft > 0) {
            System.out.print("Attempts left: " + attemptsLeft + ". Enter your guess: ");
            int guess = -1;

            // Handle invalid input
            try {
                guess = Integer.parseInt(scanner.nextLine());
                attempts++;
                attemptsLeft--;

                if (guess < targetNumber) {
                    System.out.println("Your guess is too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Your guess is too high!");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    return attempts;  // Return the number of attempts when guessed correctly
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
        return attempts;  // Return attempts even if the user doesn't guess correctly
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalRounds = 0;
        int totalScore = 0;

        while (true) {
            int attempts = playGame();
            totalRounds++;

            // Score based on attempts
            totalScore += Math.max(10 - attempts, 0);  // Score is based on remaining attempts

            System.out.println("Your current score: " + totalScore);
            System.out.print("Would you like to play another round? (y/n): ");
            String playAgain = scanner.nextLine();

            if (!playAgain.equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing! Your total score is " + totalScore);
                break;
            }
        }
    }
}
