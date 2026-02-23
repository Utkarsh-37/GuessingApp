/**
 * GameConfig – configuration and rules for a number-guessing game.
 *
 * <p>The constructor initializes a random target number within the
 * configured range.</p>
 */
import java.util.*;
class GameConfig {

    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;
    private final int MAX_HINTS = 3;

    private int targetNumber;

    /**
     * Constructor is automatically called when a GameConfig object is created.
     * It initializes the random target number for the game.
     */
    public GameConfig() {
        Random random = new Random();
        this.targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    public int getMaxHints() {
        return MAX_HINTS;
    }

    public void showRules() {
        System.out.println("-> Guess a number between " + MIN + " and " + MAX + ".");
        System.out.println("-> You have " + MAX_ATTEMPTS + " attempts.");
        System.out.println("-> Hints will be provided after wrong guesses.\n");
    }
}