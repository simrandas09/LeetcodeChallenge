import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        
        // Step 1: Construct the graph (adjacency list)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // Step 2: Dijkstra's Algorithm
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        long[] dist = new long[n];
        int[] ways = new int[n];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1; // 1 way to reach the start node
        
        pq.offer(new long[]{0, 0}); // {node, distance}
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long timeTaken = curr[1];
            
            if (timeTaken > dist[node]) continue; // Skip outdated paths
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long edgeTime = neighbor[1];
                
                long newTime = timeTaken + edgeTime;
                
                // Found a shorter path to nextNode
                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    ways[nextNode] = ways[node]; // Carry forward path count
                    pq.offer(new long[]{nextNode, newTime});
                } 
                // Found another shortest path
                else if (newTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return ways[n - 1];
    }
}
