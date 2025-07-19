import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); // Step 1: Sort folders
        List<String> ans = new ArrayList<>();

        for (String s : folder) {
            // Step 2: Check if current folder is not a sub-folder
            if (ans.isEmpty() || !s.startsWith(ans.get(ans.size() - 1) + "/")) {
                ans.add(s); // Add top-level folder
            }
        }

        return ans;
    }
}