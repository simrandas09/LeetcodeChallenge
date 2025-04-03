class Solution {
    public List<List<String>> solveNQueens(int n) {
        // This will hold all the valid board configurations
        List<List<String>> result = new ArrayList<>();

        // Initialize the board with empty cells ('.')
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');  // Fill each row with '.'
        }

        // Start solving from the first row
        solve(0, board, result, n);

        // Return the final list of valid configurations
        return result;
    }

    // Backtracking function to try placing queens row by row
    private void solve(int row, char[][] board, List<List<String>> result, int n) {
        // If we've placed queens in all rows, it's a valid solution
        if (row == n) {
            result.add(construct(board));  // Convert board to List<String> and add to result
            return;
        }

        // Try placing a queen in every column of the current row
        for (int col = 0; col < n; col++) {
            // Check if it's safe to place a queen at (row, col)
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';        // Place queen
                solve(row + 1, board, result, n); // Recurse to the next row
                board[row][col] = '.';        // Backtrack and remove the queen
            }
        }
    }

    // Function to check if placing a queen at (row, col) is safe
    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check vertically above (same column)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        // It's safe to place the queen here
        return true;
    }

    // Convert the 2D board to a list of strings (each row becomes a string)
    private List<String> construct(char[][] board) {
        List<String> config = new ArrayList<>();

        // Convert each row of the board to a String and add to the list
        for (char[] row : board) {
            config.add(new String(row));
        }

        return config;
    }
}
