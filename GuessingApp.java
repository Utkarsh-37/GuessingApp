/**
 * MAIN CLASS
 *
 * Use Case 4: Error Handling & Validation
 *
 * This class coordinates the game execution while ensuring
 * all user inputs are safely validated before processing.
 *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept user input
 * - Validate input using ValidationService
 * - Handle game flow without crashing on invalid input
 *
 * @author Developer
 * @version 4.0
 */
import java.util.*;
import java.io.*;


public class GuessingApp {

    public static void main(String[] args) throws InvalidInputException {

        System.out.println("Welcome to the Guessing App");
        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();
		
		Scanner scanner  = new Scanner(System.in);
		int attempts = 0;
		int hintsUsed = 0;
		/*
		 * Game loop runs until the player
		 * exhausts the maximum attempts.
		 */
		while (attempts < gameConfig.getMaxAttempts()) {

			System.out.print("Enter your guess: ");
			/*
			 * User input is validated before
			 * being used in the game logic.
			 */
			int guess = ValidationService.validateInput(scanner.nextLine());
			attempts++;

			String result = GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());
			String hint = HintService.generateHint(gameConfig.getTargetNumber(), attempts);
			/*
			 * A hint is generated only after
			 * an incorrect guess and within
			 * the allowed hint limit.
			*/
			
			if (!"CORRECT".equals(result) && hintsUsed < gameConfig.getMaxHints()) {
				hintsUsed++;
				System.out.println(HintService.generateHint(gameConfig.getTargetNumber(), hintsUsed));
			}

			System.out.println(hint);
			System.out.println(result);

			/*
			 * Stop the loop immediately
			 * if the correct number is guessed.
			 */
			if ("CORRECT".equals(result)) {
				break;
			}
		}
    }
}
