

public class SierpinskiCarpet {

    private char[][] board;
    private int dimension;

    // Constructor to initialize the board with characters '*'
    public SierpinskiCarpet(int dimension) {
        this.dimension = dimension;
        this.board = new char[dimension][dimension];
        initializeBoard();
    }

    // Initializes the board with characters '*'
    private void initializeBoard() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = '*';
            }
        }
    }

    // Prints the generated Sierpiński carpet
    public void printCarpet() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Calls the recursive function to generate the Sierpiński carpet
    public void generateCarpet() {
        removeSubarray(board, 0, 0, dimension, dimension, dimension / 3);
    }

    // Recursive function to remove sub-arrays and generate the Sierpiński carpet
    private void removeSubarray(char[][] currentBoard, int startX, int startY, int endX, int endY, int subArraySize) {
        if (subArraySize == 0) {
            return;
        }

        int midX = startX + (endX - startX) / 3;
        int midY = startY + (endY - startY) / 3;

        // Remove the middle sub-array
        for (int i = midX; i < midX + subArraySize; i++) {
            for (int j = midY; j < midY + subArraySize; j++) {
                currentBoard[i][j] = ' ';
            }
        }

        // Apply the process recursively on the remaining 8 sub-arrays
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {  // Skip the middle sub-array
                    removeSubarray(currentBoard,
                            startX + i * subArraySize,
                            startY + j * subArraySize,
                            startX + (i + 1) * subArraySize,
                            startY + (j + 1) * subArraySize,
                            subArraySize / 3);
                }
            }
        }
    }

    // Calls another recursive function that removes sub-arrays by setting cells to the level of recursion
    public void generateCarpetWithLevels() {
        removeSubarrayWithLevels(board, 0, 0, dimension, dimension, dimension / 3, 0);
    }

    // Recursive function to remove sub-arrays and set cells to the level of recursion
    private void removeSubarrayWithLevels(char[][] currentBoard, int startX, int startY, int endX, int endY,
                                          int subArraySize, int level) {
        if (subArraySize == 0) {
            return;
        }

        int midX = startX + (endX - startX) / 3;
        int midY = startY + (endY - startY) / 3;

        // Set cells to the level of recursion
        for (int i = midX; i < midX + subArraySize; i++) {
            for (int j = midY; j < midY + subArraySize; j++) {
                currentBoard[i][j] = Character.forDigit(level, 10);
            }
        }

        // Apply the process recursively on the remaining 8 sub-arrays
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {  // Skip the middle sub-array
                    removeSubarrayWithLevels(currentBoard,
                            startX + i * subArraySize,
                            startY + j * subArraySize,
                            startX + (i + 1) * subArraySize,
                            startY + (j + 1) * subArraySize,
                            subArraySize / 3,
                            level + 1);
                }
            }
        }
    }

    // Main function driving events
    public static void main(String[] args) {
        // Example usage
        SierpinskiCarpet carpet = new SierpinskiCarpet(243);
        carpet.generateCarpet();
        carpet.printCarpet();


    }
}
