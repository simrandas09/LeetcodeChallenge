

class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;

        // Step 1: Group indices by value
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        // Step 2: For each list of indices, check valid (i, j)
        for (List<Integer> indices : map.values()) {
            int size = indices.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int idx1 = indices.get(i);
                    int idx2 = indices.get(j);
                    if ((idx1 * idx2) % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
