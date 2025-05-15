class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> r = new ArrayList<>();
        if (groups.length == 0) 
        {
            return r;
        }
        r.add(words[0]);
        int lastGroup = groups[0];
        for (int i = 1; i < groups.length; i++) 
        {
            if (groups[i] != lastGroup) 
            {
                r.add(words[i]);
                lastGroup = groups[i];
            }
        }
        return r;
    }
}