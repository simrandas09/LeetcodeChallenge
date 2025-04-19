import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); // Step 1
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int low = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int high = upperBound(nums, i + 1, n - 1, upper - nums[i]);
            count += (high - low);
        }

        return count;
    }

    // Lower bound: first index with value >= target
    private int lowerBound(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    // Upper bound: first index with value > target
    private int upperBound(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
