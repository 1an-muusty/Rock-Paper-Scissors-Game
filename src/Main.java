import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Choices
        String[] choices = {"rock", "paper", "scissors", "lizard", "spock"};

        // Score tracking
        int playerScore = 0, computerScore = 0, ties = 0, round = 0;
        String playAgain = "yes";

        // AI trash talk
        String[] insults = {"Too easy! 🤡", "You call that a move? 😂", "I'm built different. 💀"};
        String[] losingResponses = {"Noooo! You got lucky! 😭", "Okay, that was just a warm-up. 😏", "What? That was rigged! 🤨"};

        do {
            round++;
            System.out.print("Enter your move (rock, paper, scissors, lizard, spock): ");
            String playerChoice = scanner.nextLine().toLowerCase().trim();

            // Validate input
            boolean validChoice = false;
            for (String choice : choices) {
                if (playerChoice.equals(choice)) {
                    validChoice = true;
                    break;
                }
            }
            if (!validChoice) {
                System.out.println("Invalid choice 🙄 Try again.");
                continue;
            }

            // Mystery Mode - AI cheats every 5 rounds
            String computerChoice = choices[random.nextInt(choices.length)];
            if (round % 5 == 0) {
                System.out.println("⚠️ Mystery Mode Activated! Computer is making a secret move... 🤯");
                computerChoice = choices[random.nextInt(choices.length)];
            }

            System.out.println("Computer chose: " + computerChoice);

            // Determine winner
            boolean playerWins = (playerChoice.equals("rock") && (computerChoice.equals("scissors") || computerChoice.equals("lizard"))) ||
                    (playerChoice.equals("paper") && (computerChoice.equals("rock") || computerChoice.equals("spock"))) ||
                    (playerChoice.equals("scissors") && (computerChoice.equals("paper") || computerChoice.equals("lizard"))) ||
                    (playerChoice.equals("lizard") && (computerChoice.equals("spock") || computerChoice.equals("paper"))) ||
                    (playerChoice.equals("spock") && (computerChoice.equals("scissors") || computerChoice.equals("rock")));

            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie! 👔");
                ties++;
            } else if (playerWins) {
                System.out.println("You win! 🥳 " + losingResponses[random.nextInt(losingResponses.length)]);
                playerScore++;
            } else {
                System.out.println("You lose! 🤧 " + insults[random.nextInt(insults.length)]);
                computerScore++;
            }

            // Show score
            System.out.println("Score: You [" + playerScore + "] - Computer [" + computerScore + "] - Ties [" + ties + "]");

            // Check for match winner (first to 5 wins)
            if (playerScore == 5) {
                System.out.println("🏆 You won the match! Champion vibes! 🎉");
                break;
            } else if (computerScore == 5) {
                System.out.println("💀 The computer won the match... get good. 🤖");
                break;
            }

            // Play again?
            System.out.print("Play again (yes/no)? ");
            playAgain = scanner.nextLine().toLowerCase().trim();

        } while (playAgain.equals("yes"));

        scanner.close();
        System.out.println("Thanks for playing! 🌞");
    }
}

