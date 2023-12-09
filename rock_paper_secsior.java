//Make a Rock Paper Scissor game With the help of JAVA 

import java.util.Random;
import java.util.Scanner;

public class rock_paper_secsior {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};

        System.out.println("Welcome to Rock, Paper, Scissors Game!");

        
        while (true) {
            System.out.println("Enter your choice (Rock, Paper, Scissors) or type 'end' to quit: ");
            String userChoice = scanner.nextLine();

        
            if (userChoice.equalsIgnoreCase("end")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;  // Exit the loop if the user chooses to end the game
            }

            
            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please choose Rock, Paper, or Scissors.");
                continue;  
            }

            
            int computerChoiceIndex = random.nextInt(choices.length);
            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Computer chose: " + computerChoice);

            
            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);
        }
    }

   
    private static boolean isValidChoice(String choice) {
        return choice.equalsIgnoreCase("Rock") || choice.equalsIgnoreCase("Paper") || choice.equalsIgnoreCase("Scissors");
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a tie!";
        } else if (
                (userChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
                        (userChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock")) ||
                        (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper"))
        ) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
    
