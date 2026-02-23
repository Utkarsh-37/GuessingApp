/**
 * MAIN CLASS
 *
 * Use Case 6: Game Restart & Exit
 *
 * This class coordinates the complete game lifecycle,
 * allowing the player to replay or exit gracefully.
 *
 * Responsibilities:
 * - Start a new game session
 * - Execute the guessing flow
 * - Persist game results
 * - Restart or exit based on user choice
 *
 * @author Developer
 * @version 6.0
 */
import java.util.*;
import java.io.*;


public class GuessingApp {

    public static void main(String[] args) throws InvalidInputException {

		Scanner scanner  = new Scanner(System.in);
		boolean restart;
		
		System.out.println("===========================");
		System.out.println("Welcome to the Guessing App");
		System.out.println("===========================\n");
		/*
		* Player name is captured once
		* and stored along with game results.
		*/
		
		do
		{
		
			System.out.print("Enter Player Name: ");
			String player = scanner.nextLine();


			GameConfig gameConfig = new GameConfig();
			gameConfig.showRules();
			
			int attempts = 0;
			int hintsUsed = 0;
			/*
			 * Tracks wether the player successfully guessed the number.
			*/
			boolean win = false;
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
			StorageService.saveResult(player, attempts, win);
			restart = GameController.restartGame(scanner);
		}while(restart);
    }
}
