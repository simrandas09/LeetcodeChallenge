class Solution {
    public void solveSudoku(char[][] board) {
        // Start solving the puzzle from the first cell
        solve(board);
    }

    // Recursive backtracking function
    private boolean solve(char[][] board) {
        // Loop through each cell on the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Check for empty cell
                if (board[row][col] == '.') {
                    // Try placing digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {
                        // Check if placing this number is valid
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Place the number

                            // Recurse for next cell
                            if (solve(board)) return true;

                            // If not valid, backtrack (undo the move)
                            board[row][col] = '.';
                        }
                    }
                    // If no valid number found, trigger backtracking
                    return false;
                }
            }
        }
        // If all cells are filled correctly, return true
        return true;
    }

    // Function to check whether placing 'num' at board[row][col] is valid
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check the row
            if (board[row][i] == num) return false;

            // Check the column
            if (board[i][col] == num) return false;

            // Check the 3x3 sub-box
            int subRow = 3 * (row / 3) + i / 3; // Row index inside the 3x3 box
            int subCol = 3 * (col / 3) + i % 3; // Column index inside the 3x3 box
            if (board[subRow][subCol] == num) return false;
        }
        // It's safe to place the number
        return true;
    }
}
