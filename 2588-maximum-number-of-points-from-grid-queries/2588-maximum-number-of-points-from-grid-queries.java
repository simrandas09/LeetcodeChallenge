import java.util.*;

class Solution {
    // Directions for moving in 4 directions (up, down, left, right)
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int k = queries.length;
        int[] result = new int[k];

        // Store (query value, index) and sort by value
        int[][] queryWithIndex = new int[k][2];
        for (int i = 0; i < k; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }
        Arrays.sort(queryWithIndex, Comparator.comparingInt(a -> a[0]));

        // Min-Heap to perform BFS with (value, x, y)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int points = 0;
        int cellsVisited = 0;

        // Process queries in ascending order
        for (int[] query : queryWithIndex) {
            int queryValue = query[0];
            int index = query[1];

            // Explore cells while the top of the heap is smaller than queryValue
            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryValue) {
                int[] current = minHeap.poll();
                int value = current[0], x = current[1], y = current[2];
                
                // Valid cell, increase count
                cellsVisited++;

                // Explore neighboring cells
                for (int[] dir : DIRECTIONS) {
                    int nx = x + dir[0], ny = y + dir[1];
                    
                    // Check bounds and if already visited
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        minHeap.offer(new int[]{grid[nx][ny], nx, ny});
                    }
                }
            }
            // Store result for this query
            result[index] = cellsVisited;
        }

        return result;
    }
}
