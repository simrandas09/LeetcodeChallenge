
class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        // 1) Generate all valid column‐patterns
        List<int[]> cols = new ArrayList<>();
        dfsGen(m, 0, new int[m], cols);
        int A = cols.size();

        // 2) Precompute which patterns are pairwise compatible
        List<List<Integer>> next = new ArrayList<>(A);
        for (int i = 0; i < A; i++) {
            next.add(new ArrayList<>());
        }
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                if (compatible(cols.get(i), cols.get(j))) {
                    next.get(i).add(j);
                }
            }
        }

        // 3) DP across columns
        int[] dp = new int[A], dp2 = new int[A];
        Arrays.fill(dp, 1);  // first column: each pattern counts once

        for (int col = 2; col <= n; col++) {
            Arrays.fill(dp2, 0);
            for (int i = 0; i < A; i++) {
                int ways = dp[i];
                if (ways == 0) continue;
                for (int j : next.get(i)) {
                    dp2[j] = (dp2[j] + ways) % MOD;
                }
            }
            // swap dp arrays
            int[] tmp = dp;
            dp = dp2;
            dp2 = tmp;
        }

        // 4) sum up all ways for the last column
        long ans = 0;
        for (int x : dp) ans = (ans + x) % MOD;
        return (int)ans;
    }

    // DFS to generate all length-m sequences with no two equal adjacent
    private void dfsGen(int m, int idx, int[] cur, List<int[]> out) {
        if (idx == m) {
            out.add(cur.clone());
            return;
        }
        for (int c = 0; c < 3; c++) {
            if (idx > 0 && cur[idx-1] == c) continue;
            cur[idx] = c;
            dfsGen(m, idx+1, cur, out);
        }
    }

    // Check that two columns have no same color in any row
    private boolean compatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}
