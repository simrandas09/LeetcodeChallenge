import java.util.*;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        List<Integer> pairSums = new ArrayList<>();

        // Step 1: Generate all adjacent pair sums
        for (int i = 0; i < n - 1; i++) {
            pairSums.add(weights[i] + weights[i + 1]);
        }

        // Step 2: Sort pair sums
        Collections.sort(pairSums);

        long minScore = 0, maxScore = 0;
        int cuts = k - 1;

        // Step 3: Take k - 1 smallest for min score
        for (int i = 0; i < cuts; i++) {
            minScore += pairSums.get(i);
        }

        // Step 4: Take k - 1 largest for max score
        for (int i = pairSums.size() - cuts; i < pairSums.size(); i++) {
            maxScore += pairSums.get(i);
        }

        return maxScore - minScore;
    }
}
