import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]); // pre[1] -> pre[0]
        }

        // Step 2: Calculate in-degrees
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int course : adjList.get(i)) {
                inDegree[course]++;
            }
        }

        // Step 3: Queue for nodes with 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 4: BFS (Kahn’s Algorithm)
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int next : adjList.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // If we processed all courses → no cycle
        return count == numCourses;
    }
}
