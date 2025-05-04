class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];

            // Normalize the pair so (1,2) and (2,1) become the same key: "1_2"
            String key = a <= b ? a + "_" + b : b + "_" + a;

            int freq = map.getOrDefault(key, 0);
            count += freq;  // Current domino forms a pair with all previous identical dominoes
            map.put(key, freq + 1);
        }

        return count;
    }
}
