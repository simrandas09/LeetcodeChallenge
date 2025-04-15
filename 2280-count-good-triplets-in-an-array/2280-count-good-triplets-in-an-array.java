class Solution {
    class BIT {
        int[] tree;
        int n;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 2]; // 1-based indexing
        }

        void update(int i, int delta) {
            for (i++; i < tree.length; i += i & -i)
                tree[i] += delta;
        }

        int query(int i) {
            int sum = 0;
            for (i++; i > 0; i -= i & -i)
                sum += tree[i];
            return sum;
        }

        int queryRange(int l, int r) {
            return query(r) - query(l - 1);
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            position[i] = pos2[nums1[i]];
        }

        long[] prefix = new long[n];
        BIT bit1 = new BIT(n);
        for (int i = 0; i < n; i++) {
            prefix[i] = bit1.query(position[i] - 1); // # of smaller elements before i
            bit1.update(position[i], 1);
        }

        long[] suffix = new long[n];
        BIT bit2 = new BIT(n);
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = bit2.queryRange(position[i] + 1, n);
            bit2.update(position[i], 1);
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += prefix[i] * suffix[i];
        }

        return total;
    }
}
