package Practical_20;

// Class representing a Carpet with various design methods
public class Carpet {

    // Method to print the board
    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to design the carpet pattern
    private static void design(char[][] board, char symbol) {

        centerSection(board, symbol);
        cornerCenterSection(board,symbol, board.length);

        // Print the designed carpet
        repeatingPattern(board,symbol, board.length);
        printBoard(board);
    }


    private static void repeatingPattern(char[][] board, char symbol, int size){ // repeat this pattern around the new size x size

        int around = size / 3;
        for (int i = 0; i < around ; i+= around) {
            for (int j = 0; j < around; j+= around) {
                cornerCenterSection(board,symbol, 27);
            }
        }
    }


    private static void cornerCenterSection(char[][] board, char symbol, int size) {

        // Calculate the size of each corner section
        int corner = size / 3;
        // Calculate the size of each 3x3 sub-section within the corner
        int sections = corner / 3;

        // Iterate through the 3x3 grid of 9x9 sections around the center
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Calculate the starting positions for each 9x9 section
                int startX = i * corner;
                int startY = j * corner;

                // Update the center of each 9x9 section around the 27x27 center
                int centerStartX = startX + sections;
                int centerStartY = startY + sections;
                int centerEndX = startX + 2 * sections;
                int centerEndY = startY + 2 * sections;

                // Copy the center design to the 9x9 section
                for (int c = centerStartX; c < centerEndX; c++) {
                    for (int d = centerStartY; d < centerEndY; d++) {
                        // Set the specified symbol for the center of each 9x9 section
                        board[c][d] = symbol;
                    }
                }
            }
        }
    }

    // Method to update the center section of the carpet
    private static void centerSection(char[][] board, char symbol) {
        // Calculate the size of each section
        int sections = board.length / 3;

        // Update the center section of the carpet
        for (int c = sections; c < 2 * sections; c++) {
            for (int d = sections; d < 2 * sections; d++) {
                board[c][d] = symbol;
            }
        }

        // Update the diagonal sections of the carpet
        for (int i = 1; i < board.length; i += 3) {
            for (int j = 1; j < board.length; j += 3) {
                board[i][j] = symbol;
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        char symbol = ' '; // for empty sections
        int size = 81; // Adjust the size accordingly

        // Initialize the board with '*'
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '*'; // border design
            }
        }

        System.out.println("--------------------------------------------");

        // Design and print the carpet pattern
        System.out.println("Designed Carpet:");
        System.out.println( );
        design(board, symbol);
    }
}
