import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> values = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        
        // Flatten the grid and check divisibility condition
        for (int[] row : grid) {
            for (int num : row) {
                values.add(num);
            }
        }
        
        // Check feasibility: All values must have the same remainder when divided by x
        int remainder = values.get(0) % x;
        for (int num : values) {
            if (num % x != remainder) {
                return -1; // Not possible to make the grid uni-value
            }
        }

        // Sort to find the median
        Collections.sort(values);
        int median = values.get(values.size() / 2);
        
        // Compute minimum operations
        int operations = 0;
        for (int num : values) {
            operations += Math.abs(num - median) / x;
        }
        
        return operations;
    }
}
