import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), visited, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] visited, List<List<Integer>> result) {
        // Base Case: A permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Add a deep copy
            return;
        }

        // Recursive Case
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue; // Skip if already used
            
            visited[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, visited, result);
            current.remove(current.size() - 1); // Remove last element for backtracking
            visited[i] = false;
        }
    }
}
