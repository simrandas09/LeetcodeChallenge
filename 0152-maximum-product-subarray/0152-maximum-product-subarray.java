class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        int prefix = 1, suffix = 1;

        // Left to right (prefix)
        for (int i = 0; i < n; i++) {
            prefix *= nums[i];
            maxProduct = Math.max(maxProduct, prefix);
            if (prefix == 0) prefix = 1; // reset when product becomes zero
        }

        // Right to left (suffix)
        for (int i = n - 1; i >= 0; i--) {
            suffix *= nums[i];
            maxProduct = Math.max(maxProduct, suffix);
            if (suffix == 0) suffix = 1; // reset when product becomes zero
        }

        return maxProduct;
    }
}
