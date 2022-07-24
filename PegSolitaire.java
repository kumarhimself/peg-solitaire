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

        System.out.println("2D PEG SOLITAIRE");
        System.out.println("================");

        System.out.println("Board Variant Menu");
        System.out.println("    1. English");
        System.out.println("    2. European");
        System.out.println("    3. Triangle");
        System.out.println("    4. Simple-T");

        char[][] board = createBoard(readValidInt(input, "Choose a board variant (1-4)", 1, 4));
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

    // char[][] createBoard(int boardType)
    private static char[][] createBoard(int boardType) {
        switch (boardType) {

            // English Variant
            case 1:
                return new char[][] {
                    {'#', '#', '#', '@', '@', '@', '#', '#', '#'},
                    {'#', '#', '#', '@', '@', '@', '#', '#', '#'},
                    {'@', '@', '@', '@', '@', '@', '@', '@', '@'},
                    {'@', '@', '@', '@', '-', '@', '@', '@', '@'},
                    {'@', '@', '@', '@', '@', '@', '@', '@', '@'},
                    {'#', '#', '#', '@', '@', '@', '#', '#', '#'},
                    {'#', '#', '#', '@', '@', '@', '#', '#', '#'}
                };

            // European Variant
            case 2:
                return new char[][] {
                    {'#', '-', '@', '@', '-', '#'},
                    {'-', '@', '@', '@', '@', '-'},
                    {'@', '@', '@', '@', '@', '@'},
                    {'@', '@', '@', '@', '@', '@'},
                    {'-', '@', '@', '@', '@', '-'},
                    {'#', '-', '@', '@', '-', '#'},
                };

            // Triangle Variant
            case 3:
                return new char[][] {
                    {'#', '#', '#', '-', '@', '-', '#', '#', '#'},
                    {'#', '#', '-', '@', '@', '@', '-', '#', '#'},
                    {'#', '-', '@', '@', '-', '@', '@', '-', '#'},
                    {'-', '@', '@', '@', '@', '@', '@', '@', '-'},
                };
            case 4:
                return new char[][] {
                    {'-', '-', '-', '-', '-'},
                    {'-', '@', '@', '@', '-'},
                    {'-', '-', '@', '-', '-'},
                    {'-', '-', '@', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                };
        }

        return new char[][] {{}};
    }

    // void displayBoard(char[][] board)

    // int[] readValidMove(Scanner in, char[][] board)

    // boolean isValidMove(char[][] board, int row, int column, int direction)

    // char[][] performMove(char[][] board, int row, int column, int direction)

    // int countPegsRemaining(char[][] board)

    // int countMovesAvailable(char[][] board)

}