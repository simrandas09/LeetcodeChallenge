class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long minPrefix = 0;
        long maxPrefix = 0;
        long prefixSum = 0;

        for (int diff : differences) {
            prefixSum += diff;
            minPrefix = Math.min(minPrefix, prefixSum);
            maxPrefix = Math.max(maxPrefix, prefixSum);
        }

        // Calculate bounds for initial value x
        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;

        if (minStart > maxStart) {
            return 0;
        }

        return (int)(maxStart - minStart + 1);
    }
}
