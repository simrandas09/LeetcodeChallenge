import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        for (int op = 0; op <= (n + 2) / 3; op++) {
            // After removing 3 * op elements from the front
            Set<Integer> seen = new HashSet<>();
            boolean isDistinct = true;
            for (int i = 3 * op; i < n; i++) {
                if (!seen.add(nums[i])) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct) return op;
        }
        return (n + 2) / 3;  // In worst case, all elements removed
    }
}
