class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops[0], tops, bottoms);
        if (result != -1 || tops[0] == bottoms[0]) return result;
        return check(bottoms[0], tops, bottoms);
    }

    // Try to make all values in tops or bottoms equal to "target"
    private int check(int target, int[] tops, int[] bottoms) {
        int rotateTop = 0;
        int rotateBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1; // impossible to make target here
            } else if (tops[i] != target) {
                rotateTop++; // rotate to bring target to top
            } else if (bottoms[i] != target) {
                rotateBottom++; // rotate to bring target to bottom
            }
        }

        return Math.min(rotateTop, rotateBottom);
    }
}
