/*
* Use Case 1: Game Initialization
*
* This class is responsible for:
* - Setting game boundaries
* - Generating a random target number
* - Displaying game rules
*
* Demonstrates:
* - Encapsulation
* - Constructor initialization
* - Random number generation
* @author Developer
* @version 1.0
*/
import java.util.*;

public class GuessingApp {

    public static void main(String[] args){
        System.out.println("Welcome to the Guessing App");
        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();
    }
}




