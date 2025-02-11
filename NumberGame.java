import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int score = 0; 
        String playAgain;

        do {
            int number = rand.nextInt(10) + 1;
            int attempts = 7;
            
            System.out.println("\nGuess a number between 1 and 10.");
            System.out.println("You have " + attempts + " attempts to guess it!");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts--;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number!");
                    score++;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts > 0) {
                    System.out.println("Attempts left: " + attempts);
                }
            }

            if (attempts == 0) {
                System.out.println("you're out of attempts! The number was: " + number);
            }

            System.out.println("Rounds won: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Game over! Your final score: " + score);
        sc.close();
    }
}
