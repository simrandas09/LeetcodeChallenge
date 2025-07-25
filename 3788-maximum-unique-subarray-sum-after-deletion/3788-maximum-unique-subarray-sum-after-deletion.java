import java.util.Arrays;

class Solution {
    public int maxSum(int[] numbers) {
        Arrays.sort(numbers); // \U0001f503 Step 1: Sort the array
        int previous = numbers[numbers.length - 1]; // Largest number
        int result = previous; // Initialize result with largest
        for (int index = numbers.length - 2; index >= 0; index--) {
            int currentValue = numbers[index];
            if (currentValue <= 0) return result; // \U0001f6ab Stop at zero or negative
            if (currentValue != previous) result += currentValue; // ✅ Add if unique
            previous = currentValue; // Update previous
        }
        return result; // \U0001f3af Return final result
    }
}