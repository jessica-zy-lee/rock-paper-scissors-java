import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String args[]) {
        playGame();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to play again? (Y/N)");
        String playAgainInput = scanner.nextLine().toUpperCase();

        playAgain(playAgainInput);
    } // end of main method

    public static void playAgain(String playAgainInput) {
        Scanner scanner = new Scanner(System.in);

        while(playAgainInput.equals("Y")) {
            playGame();
            System.out.println("Do you want to play again? (Y/N)");
            playAgainInput = scanner.nextLine().toUpperCase();
        }

        if (playAgainInput.equals("N")) {
            System.out.println("Thanks for playing!");
        } else {
            System.out.println("Do you want to play again? (Y/N)");
            String playAgainOrNot = scanner.nextLine().toUpperCase();
            playAgain(playAgainOrNot);
        }
    } //end of playAgain method

    public static void playGame() {
        String choices [] = {"ROCK", "PAPER", "SCISSORS"}; //string array of choices

        Scanner scanner = new Scanner(System.in); // scanner object

        System.out.println("How many rounds do you want to play? (enter integer value between 1 and 10)");
        int numOfRounds = Integer.valueOf(scanner.nextLine()); //program stops and waits to take an input from user

        if (numOfRounds < 1 || numOfRounds > 10) {
            System.out.println("Error: Value provided isn't between 1 and 10.");
            return;
        }

        int currentRound = 0;
        int userScore = 0;
        int computerScore = 0;
        int tieScore = 0;

        while (currentRound < numOfRounds) {
            System.out.println("Rock, Paper or Scissors?");
            String userChoice = scanner.nextLine().toUpperCase();
            String computerChoice = choices[(int) Math.round(Math.random() * 2)];
            System.out.println("Computer chose: " + computerChoice);

            if (userChoice.equals("ROCK")) {
                if (computerChoice.equals("PAPER")) {
                    computerScore++;
                }

                if (computerChoice.equals("SCISSORS")) {
                    userScore++;
                }

                if (computerChoice.equals("ROCK")) {
                    tieScore++;
                }
            }

            if (userChoice.equals("PAPER")) {
                if (computerChoice.equals("ROCK")) {
                    userScore++;
                }

                if (computerChoice.equals("SCISSORS")) {
                    computerScore++;
                }

                if (computerChoice.equals("PAPER")) {
                    tieScore++;
                }
            }

            if (userChoice.equals("SCISSORS")) {
                if (computerChoice.equals("ROCK")) {
                    computerScore++;
                }

                if (computerChoice.equals("PAPER")) {
                    userScore++;
                }

                if (computerChoice.equals("SCISSORS")) {
                    tieScore++;
                }
            }
            System.out.println("User score: " + userScore);
            System.out.println("Computer score: " + computerScore);
            System.out.println("Ties: " + tieScore);

            currentRound++;
        }

        printResult(userScore, computerScore);
    } // end of playGame method

    public static void printResult(int userScore, int computerScore) {
        System.out.println("The result is:");
        if (userScore > computerScore) {
            System.out.println("User wins!");
        } else if (computerScore > userScore) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("Draw!");
        }
    } // end of printResult method
} // end of class
