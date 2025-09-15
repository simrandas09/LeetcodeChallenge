import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]); // pre[1] -> pre[0]
        }

        // Step 2: Calculate in-degree
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int next : adjList.get(i)) {
                inDegree[next]++;
            }
        }

        // Step 3: Add all courses with in-degree 0 into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 4: Process queue (BFS)
        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            for (int next : adjList.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // Step 5: Check if cycle exists
        if (index == numCourses) {
            return order; // valid topological order
        } else {
            return new int[0]; // cycle detected
        }
    }
}
