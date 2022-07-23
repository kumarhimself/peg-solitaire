/*
 * Program Name: Peg Solitaire
 * Author: Ayush Kumar
 * Description: This Java program allows you to play Peg Solitaire on the CLI.
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class PegSolitaire {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        readValidInt(input, "Enter a number between 1 and 4: ", 1, 4);
    }

    // int readValidInt(Scanner in, String prompt, int min, int max)
    private static int readValidInt(Scanner input, String prompt, int min, int max) {
        int answer;
        System.out.print(prompt);

        while (true) {
            try {
                answer = input.nextInt();

                if(answer >= min && answer <= max) {
                    return answer;
                } else {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a numerical value: ");
                input.next();
            }
        }
    }

    // char[][] createBoard(char[][] board)
    private static char[][] createBoard(char[][] board) {}

    // void displayBoard(char[][] board)

    // int[] readValidMove(Scanner in, char[][] board)

    // boolean isValidMove(char[][] board, int row, int column, int direction)

    // char[][] performMove(char[][] board, int row, int column, int direction)

    // int countPegsRemaining(char[][] board)

    // int countMovesAvailable(char[][] board)

}