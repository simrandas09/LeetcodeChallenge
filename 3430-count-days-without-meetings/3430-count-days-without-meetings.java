import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // Edge case: If there are no meetings, all days are available
        if (meetings.length == 0) return days;
        
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int busyDays = 0;
        int prevStart = meetings[0][0];
        int prevEnd = meetings[0][1];

        // Merging overlapping intervals
        for (int i = 1; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            if (start <= prevEnd + 1) { 
                // Merge intervals
                prevEnd = Math.max(prevEnd, end);
            } else {
                // Count busy days for the previous merged interval
                busyDays += (prevEnd - prevStart + 1);
                // Move to the next interval
                prevStart = start;
                prevEnd = end;
            }
        }

        // Count the last merged interval
        busyDays += (prevEnd - prevStart + 1);

        // Available days = Total days - Busy days
        return days - busyDays;
    }
}
