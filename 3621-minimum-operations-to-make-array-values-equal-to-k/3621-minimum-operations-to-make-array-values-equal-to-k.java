import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        // Step 1: Check for any number less than k
        for (int num : nums) {
            if (num < k) return -1;
            if (num > k) set.add(num); // Only care about values > k
        }

        // Step 2: Count unique values > k
        return set.size();
    }
}
