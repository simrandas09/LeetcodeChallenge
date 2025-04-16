import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        long res = 0;
        int left = 0;
        long pairs = 0;

        for (int right = 0; right < n; right++) {
            int curr = nums[right];
            int count = freq.getOrDefault(curr, 0);
            pairs += count;
            freq.put(curr, count + 1);

            while (pairs >= k) {
                res += (n - right);
                int leftNum = nums[left];
                int leftCount = freq.get(leftNum);
                pairs -= (leftCount - 1);
                freq.put(leftNum, leftCount - 1);
                left++;
            }
        }
        return res;
    }
}
