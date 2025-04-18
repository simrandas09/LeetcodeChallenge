class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String res = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char prev = res.charAt(0);

            for (int j = 1; j < res.length(); j++) {
                char curr = res.charAt(j);
                if (curr == prev) {
                    count++;
                } else {
                    sb.append(count).append(prev);
                    count = 1;
                    prev = curr;
                }
            }
            sb.append(count).append(prev);  // append the last run
            res = sb.toString();
        }

        return res;
    }
}
