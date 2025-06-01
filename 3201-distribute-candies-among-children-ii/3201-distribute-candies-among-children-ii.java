class Solution {
    public long distributeCandies(int n, int limit) {
        long total = combination(n + 2, 2); // All possible ways

        // Try all combinations of which children go over limit
        for (int mask = 1; mask < 8; mask++) {
            int count = Integer.bitCount(mask); // 1, 2, or 3 children over
            int extra = count * (limit + 1);
            long ways = combination(n - extra + 2, 2);
            if (count % 2 == 1) total -= ways; // Subtract
            else total += ways;                // Add back
        }

        return total;
    }

    // Calculates nCk (combinations)
    private long combination(int n, int k) {
        if (n < 0 || k < 0 || k > n) return 0;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }
}
