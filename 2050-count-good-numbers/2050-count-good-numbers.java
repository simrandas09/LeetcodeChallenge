class Solution {
    static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2; // even indices
        long oddCount = n / 2;        // odd indices

        long evenWays = power(5, evenCount, MOD); // 5 choices for even indices
        long oddWays = power(4, oddCount, MOD);   // 4 choices for odd indices

        return (int)((evenWays * oddWays) % MOD);
    }

    private long power(long base, long exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}
