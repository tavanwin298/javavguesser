# javavguesser

1. Program Start
   
Import java.util.Scanner
Create a class called Guesser
Create a main method that:
Initializes Scanner
Calls a method to display the menu and handle the main loop

2. Menu and Main Loop
   
Loop until the user selects Exit (option 0):
Print the menu:
vbnet
Copy
Edit
0) Exit
1) Human Guesser
2) Computer Guesser
Prompt user for choice
Use a switch or if-else:
If 1, call humanGuesser()
If 2, call computerGuesser()
If 0, exit with a goodbye message
Else, print "Invalid choice. Try again."

3. Human Guesser Algorithm
   
Purpose: The computer picks a random number, and the human tries to guess.
Generate a random number between 1 and 100 using Math.random()
Initialize a counter for attempts
Repeat until the user guesses correctly:
Prompt the user to enter a number
If the guess is too low, print "too low..."
If the guess is too high, print "too high..."
If correct, print "got it!" and the number of tries

4. Computer Guesser Algorithm (Binary Search)
   
Purpose: Human thinks of a number (1-100), and the computer guesses using binary search.
Initialize low = 1, high = 100
Initialize guessCount = 1
Loop until user confirms the computer is correct:
Calculate guess = (low + high) / 2
Print "I guess [guess]"
Prompt user: "Too (H)igh, too (L)ow, or (C)orrect?"
If the user input is:
H: set high = guess - 1
L: set low = guess + 1
C: print "Got it in [guessCount] tries!" and exit the loop
Increment guessCount
