class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        
        for (int num : arr) {
            if (num % 2 != 0) { // Check if the number is odd
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0; // Reset count if an even number is found
            }
        }
        
        return false;
    }
}
