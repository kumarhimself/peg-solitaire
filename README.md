# Peg Solitaire
### By: Ayush Kumar
Peg Solitaire is a puzzle that involves the movement and capturing of pegs on a board with the goal of only having one peg left. This Java program allows you to play a bare bone version of Peg Solitaire on the CLI. Here are the important symbols:
- '@' - represents a peg
- '-' - represents an empty space
- '#' - represents a void space (you cannot do anything with it as it is not a part of the board)

## Method Definitions
### void main (String[] args)
- Combines all the methods mentioned below to create Peg Solitaire game
### int readValidInt(Scanner input, String prompt, int min, int max)
- Centralized method for capturing input from the user
- States the prompt
- Checks whether input is of the type int using the try-catch structure
- Checks whether input is within the range of min and max
### char[][] createBoard(int boardType)
- Uses readValidInt method to generate a board variation of the user's preference
- Option of choosing between the English, European, Triangle, and Simple T board variants
- Returns representation of board variant in form of a 2d array
### void displayBoard(char[][] board)
- Takes board parameter and prints each element out in a readable format
- Uses nested for loops to print out each element
### int[] readValidMove(Scanner input, char[][] board)
- Uses readValidInt method three times (row, column, direction) to ask the user which peg to move and in what direction to move the peg
- Returns an integer array of the row, column, and direction
### boolean isValidMove(char[][] board, int row, int column, int direction)
- Takes in output from readValidMove method and checks if the move is valid
- Specifically, the method checks if there is a neighboring peg between the peg you want to move and an empty space
- Returns true if the above conditions are met, otherwise, returns false
### char[][] performMove(char[][] board, int row, int column, int direction)
- Takes in output from isValidMove, and executes the move
- Assigns a '-' to the current and neighboring position, and a '@' to the position two spots away from the current position
### int countPegsRemaining(char[][] board)
- Checks how many pegs ('@') are remaining by using a nested for loop to traverse through all the indexes of the 2d array board
- Returns the number of pegs remaining
### int countMovesAvailable(char[][] board)
- Checks how many moves are available by implementing three nested for loops to traverse through all the directions, rows, and columns, and inserting them as parameters of the method isValidMove (I am sorry for creating such an abomination. As soon as I finish my computer science class at college, I will demolish that nested for loop structure!)
- Returns the number of moves available
