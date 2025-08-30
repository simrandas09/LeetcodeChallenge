class Solution {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, maxReach = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == curEnd) {
                jumps++;
                curEnd = maxReach;

                if (curEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }
}