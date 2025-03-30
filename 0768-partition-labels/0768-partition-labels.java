import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26]; // Store last index of each character

        // Step 1: Store the last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Greedy approach to create partitions
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']); // Expand the partition

            // When current index reaches the end of the partition
            if (i == end) {
                result.add(end - start + 1); // Record the size of partition
                start = i + 1; // Start a new partition
            }
        }

        return result;
    }
}
