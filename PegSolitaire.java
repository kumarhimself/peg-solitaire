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
        System.out.println("  1. English");
        System.out.println("  2. European");
        System.out.println("  3. Triangle");
        System.out.println("  4. Simple-T");

        char[][] board = createBoard(readValidInt(input, "Choose a board variant (1-4): ", 1, 4));

        displayBoard(board);

        while (true) {
            int[] playerMove = readValidMove(input, board);

            if (isValidMove(board, playerMove[0], playerMove[1], playerMove[2])) {
                performMove(board, playerMove[0], playerMove[1], playerMove[2]);

                if (countPegsRemaining(board) == 1) {
                    System.out.println("Congrats, you won!");
                    break;
                }

                if (countMovesAvailable(board) == 0) {
                    System.out.println("Hehe, you lost (＾▽＾)!");
                    break;
                }
            }
            displayBoard(board);
        }
    }

    // int readValidInt(Scanner input, String prompt, int min, int max)
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
            default:
                return new char[][] {{}};
        }
    }

    // void displayBoard(char[][] board)
    private static void displayBoard(char[][] board) {
        System.out.print("  ");

        for (int i = 0; i < board[0].length; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int j = 0; j < board.length; j++) {
            for (int k = 0; k < board[j].length; k++) {
                if (k == 0) {
                    System.out.print(j + " ");
                }
                System.out.print(board[j][k] + " ");
            }
            System.out.println();
        }
    }

    // int[] readValidMove(Scanner input, char[][] board)
    private static int[] readValidMove(Scanner input, char[][] board) {
        int row, column, direction;

        row = readValidInt(input, "Please enter the row of the peg you would like to move: ", 0, board.length - 1);
        column = readValidInt(input, "Please enter the column of the peg you would like to move: ", 0, board[0].length - 1);
        direction = readValidInt(input, "Direction  \n  1. North \n  2. South \n  3. West \n  4. East \nChoose the direction you would like to move the peg in: ", 0, 4);

        return new int[] {row, column, direction + 1};
    }

    // boolean isValidMove(char[][] board, int row, int column, int direction)
    private static boolean isValidMove(char[][] board, int row, int column, int direction) {
        if (board[row][column] == '@') {
            switch(direction) {
                // North
                case 1:
                    if (board[row + 1][column] == '@' && board[row + 2][column] == '-') return true;
                
                // South
                case 2:
                    if (board[row - 1][column] == '@' && board[row - 2][column] == '-') return true;
                
                // West
                case 3:
                    if (board[row][column - 1] == '@' && board[row][column - 2] == '-') return true;
                
                // East
                case 4:
                    if (board[row][column + 1] == '@' && board[row][column + 2] == '-') return true;
                
                default:
                    return false;
            }
        } else {
            return false;
        }
    }

    // char[][] performMove(char[][] board, int row, int column, int direction)
    private static char[][] performMove(char[][] board, int row, int column, int direction) {
        switch(direction) {
            // North
            case 1:
                board[row][column] = '-';
                board[row + 1][column] = '-';
                board[row + 2][column] = '@';

                return board;
            
            // South
            case 2:
                board[row][column] = '-';
                board[row - 1][column] = '-';
                board[row - 2][column] = '@';

                return board;            
            // West
            case 3:
                board[row][column] = '-';
                board[row][column + 1] = '-';
                board[row][column + 2] = '@';

                return board;            
            // East
            case 4:
                board[row][column] = '-';
                board[row][column - 1] = '-';
                board[row][column - 2] = '@';

                return board;         
        }
        
        return new char[][] {{}};
    }

    // int countPegsRemaining(char[][] board)
    private static int countPegsRemaining(char[][] board) {
        int count = 0;

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == '@') {
                    count++;
                }
            }
        }
        return count;
    }

    // int countMovesAvailable(char[][] board)
    private static int countMovesAvailable(char[][] board) {
        int numValidMoves = 0;

        for (int direction = 1; direction <= 4; direction++) {
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[0].length; column++) {
                    if (isValidMove(board, row, column, direction) == true) {
                        numValidMoves++;
                    }
                }
            }
        }
        
        return numValidMoves;
    }
}