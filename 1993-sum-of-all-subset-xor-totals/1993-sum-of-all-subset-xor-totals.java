class Solution {
    int totalSum = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return totalSum;
    }

    private void dfs(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            totalSum += currentXOR;
            return;
        }

        // Include nums[index]
        dfs(nums, index + 1, currentXOR ^ nums[index]);

        // Exclude nums[index]
        dfs(nums, index + 1, currentXOR);
    }
}
