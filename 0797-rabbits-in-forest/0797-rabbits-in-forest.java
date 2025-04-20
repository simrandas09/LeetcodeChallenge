import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count frequency of each answer
        for (int ans : answers) {
            countMap.put(ans, countMap.getOrDefault(ans, 0) + 1);
        }

        int totalRabbits = 0;

        for (int k : countMap.keySet()) {
            int count = countMap.get(k);
            int groupSize = k + 1;
            int numberOfGroups = (int) Math.ceil((double) count / groupSize);
            totalRabbits += numberOfGroups * groupSize;
        }

        return totalRabbits;
    }
}
