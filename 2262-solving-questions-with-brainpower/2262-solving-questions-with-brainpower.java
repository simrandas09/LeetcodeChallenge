class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // dp[n] = 0 by default

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int nextQuestion = i + brainpower + 1;

            long solve = points + (nextQuestion < n ? dp[nextQuestion] : 0);
            long skip = dp[i + 1];

            dp[i] = Math.max(solve, skip);
        }

        return dp[0];
    }
}
