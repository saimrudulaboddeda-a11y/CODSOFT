import java.util.*;
public class RandomNumberGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int maxAttempts = 5;
        int totalScore = 0;
        System.out.print("Enter the number of rounds you want to play: ");
        int totalRounds = 30;
        try {
            totalRounds = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ne) {
            System.out.println("Invalid input. Defaulting to 1 round.");
        }
        for (int round = 0; round < totalRounds; round++) {
            int number = r.nextInt(100) + 1;
            int attempts = 0;
            int score = 0;
            System.out.println("\nGuess the number from 1 to 100");
            System.out.println("Round: " + (round + 1));
            while (attempts < maxAttempts) {
                System.out.println("Attempt: " + (attempts + 1) + " enter your guessing number:");
                int guess;
                try {
                    guess = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException ne) {
                    System.out.println("Enter a valid number");
                    continue;
                }
                attempts++;
                if (guess == number) {
                    System.out.println("Correct!! You guessed the correct number");
                    score++;
                    break;
                } else if (guess > number) {
                    System.out.println("It's too high");
                } else {
                    System.out.println("It's too low");
                }
            }
            if (attempts == maxAttempts) {
                System.out.println("Oops! Out of attempts. The correct number was: " + number);
            }
            totalScore += score;
            display(score, round);
        }
        System.out.println("\nGame Over! Your total score after " + totalRounds + " round(s) is: " + totalScore);
        sc.close();
    }

    public static void display(int score, int round) {
        System.out.println("Your score in round " + (round + 1) + " is: " + score);
    }
}



