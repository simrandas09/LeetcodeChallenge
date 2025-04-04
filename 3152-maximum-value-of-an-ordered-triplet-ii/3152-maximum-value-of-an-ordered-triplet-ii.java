class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        // Build suffix max array
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(nums[i], suffixMax[i + 1]);
        }

        long result = 0;
        int maxLeft = nums[0];

        for (int j = 1; j < n - 1; j++) {
            long leftDiff = maxLeft - nums[j];
            if (leftDiff > 0) {
                result = Math.max(result, leftDiff * (long)suffixMax[j + 1]);
            }
            maxLeft = Math.max(maxLeft, nums[j]);
        }

        return result;
    }
}
