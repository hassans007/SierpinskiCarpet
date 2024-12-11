# Sierpinski Carpet Generator

## Overview
This Java program generates and displays a Sierpinski Carpet, a famous fractal pattern. The program uses recursion to create the fractal structure by progressively removing sub-arrays from a grid.

The Sierpinski Carpet is a self-similar, infinitely recursive shape where at each level of recursion, the middle third of each square is removed, and the process is repeated for the remaining 8 smaller sub-squares.

## Features
- **Recursive Generation**: The program utilizes recursion to remove sub-arrays and create the Sierpinski Carpet pattern.
- **Customization**: The size of the carpet can be customized by setting the dimension of the grid (must be a power of 3 for the recursion to work correctly).
- **Level Visualization**: The program offers an option to show the recursion depth by assigning different characters for each recursion level.

## Classes

### `SierpinskiCarpet`

This is the main class that contains methods to generate the Sierpinski Carpet.

#### Fields:
- `char[][] board`: A 2D array representing the board that stores the carpet pattern.
- `int dimension`: The dimension (size) of the square grid (must be a power of 3).

#### Constructor:
- `SierpinskiCarpet(int dimension)`: Initializes the board with the given dimension.

#### Methods:
- `initializeBoard()`: Initializes the board with a default character `'*'`.
- `printCarpet()`: Prints the generated Sierpinski Carpet.
- `generateCarpet()`: Generates the Sierpinski Carpet by removing the middle sub-array recursively.
- `removeSubarray(char[][] currentBoard, int startX, int startY, int endX, int endY, int subArraySize)`: A recursive function that removes sub-arrays to create the Sierpinski Carpet.
- `generateCarpetWithLevels()`: Generates the carpet and shows the recursion levels by setting cells to the level number.
- `removeSubarrayWithLevels(char[][] currentBoard, int startX, int startY, int endX, int endY, int subArraySize, int level)`: A recursive function that generates the Sierpinski Carpet and assigns a level to each sub-array.

## Usage

To generate the Sierpinski Carpet, create an instance of the `SierpinskiCarpet` class with the desired dimension (must be a power of 3, e.g., 243, 729, etc.). Then, call the `generateCarpet()` method to generate the pattern, and `printCarpet()` to display it.

### Example Usage:
```java
public static void main(String[] args) {
    // Example usage
    SierpinskiCarpet carpet = new SierpinskiCarpet(243);  // Dimension must be a power of 3
    carpet.generateCarpet();   // Generates the Sierpinski Carpet
    carpet.printCarpet();      // Prints the generated carpet to the console
}
```
