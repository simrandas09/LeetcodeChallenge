class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zeros1 = 0, zeros2 = 0;
        long sum1 = 0, sum2 = 0;
        
        for (int num : nums1) {
            if (num == 0) {
                zeros1++;
                sum1 += 1; // treat 0 as 1
            } else {
                sum1 += num;
            }
        }
        
        for (int num : nums2) {
            if (num == 0) {
                zeros2++;
                sum2 += 1; // treat 0 as 1
            } else {
                sum2 += num;
            }
        }
        
        if (sum1 == sum2) return sum1;

        long diff = Math.abs(sum1 - sum2);
        int z = (sum1 < sum2) ? zeros1 : zeros2;

        // Each 0 can be turned into at most Integer.MAX_VALUE (but we want min sum)
        // So minimum required extra sum = diff
        // Each zero gives us extra sum of at most (k - 1), where k ≥ 1
        // To minimize sum, we increase each 0 from 1 to x just enough to make sums equal

        // If we can make up the diff using z zeros:
        if (diff <= (long)z * (Integer.MAX_VALUE - 1)) {
            return Math.max(sum1, sum2);
        }

        return -1;
    }
}
