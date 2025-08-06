/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maximum = Integer.MIN_VALUE; // Initialize with smallest possible value

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maximum;
    }

    private int maxPath(TreeNode node) {
        if (node == null) return 0;

        // Compute left and right max sum, but ignore negative values
        int leftSum = Math.max(0, maxPath(node.left));
        int rightSum = Math.max(0, maxPath(node.right));

        // Update the global maximum path sum (including both left and right)
        maximum = Math.max(maximum, leftSum + rightSum + node.val);

        // Return the maximum sum of a path extending to the parent
        return node.val + Math.max(leftSum, rightSum);
    }
}
