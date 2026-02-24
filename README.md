# Guessing App – Use Case Overview

This Java-based Number Guessing Game demonstrates core concepts through six practical use cases.

---

## **Use Case 1 — Game Initialization**

**What This Use Case Does:**
- Creates the game setup when the application starts.
- Generates a random number in a fixed range.
- Initializes attempts, hints, and difficulty.
- Loads all configuration values.
- Displays rules and instructions.

**Purpose:**  
Start the game in a controlled, predictable way.

---

## **Use Case 2 — User Guess Submission**

**What This Use Case Does:**
- Prompts the user to enter a guess.
- Validates that the input is numeric.
- Compares guess with the target number.
- Tells the player if the number is higher, lower, or correct.
- Tracks the number of attempts used.

**Purpose:**  
Handle user input and give immediate feedback.

---

## **Use Case 3 — Hint Generation**

**What This Use Case Does:**
- Gives hints after wrong guesses.
- Limits how many hints can be used.
- Provides clues like even/odd, rough range, divisibility.
- Makes hints progressively useful without revealing the answer.

**Purpose:**  
Keep the game engaging and help the player logically narrow down the answer.

---

## **Use Case 4 — Error Handling & Validation**

**What This Use Case Does:**
- Handles invalid inputs like letters or symbols.
- Prevents guesses outside allowed range.
- Shows user-friendly error messages.
- Uses exception handling and custom validators.

**Purpose:**  
Prevent crashes and maintain smooth gameplay.

---

## **Use Case 5 — Game Result Storage**

**What This Use Case Does:**
- Saves the game result (name, win/loss, attempts).
- Stores data in a file or database.
- Displays past game history.
- Ensures previous results persist after restarting the app.

**Purpose:**  
Introduce real-world persistence with file I/O or JDBC.

---

## **Use Case 6 — Game Restart & Exit**

**What This Use Case Does:**
- Lets the player restart or exit the game.
- Resets all counters and variables for a new round.
- Closes scanner/database resources properly.
- Shows a summary before exiting.

**Purpose:**  
Provide smooth restart support and a clean shutdown.
