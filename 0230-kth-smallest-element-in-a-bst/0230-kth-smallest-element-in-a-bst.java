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
    public int kthSmallest(TreeNode root, int k) {
        // Array to store the result
        int[] result = new int[1]; // Stores the kth smallest value
        int[] count = new int[1];  // Counter for in-order traversal
        inOrderTraversal(root, k, count, result);
        return result[0];
    }

    private void inOrderTraversal(TreeNode node, int k, int[] count, int[] result) {
        if (node == null) return;

        // Traverse left subtree
        inOrderTraversal(node.left, k, count, result);

        // Visit current node
        count[0]++;
        if (count[0] == k) {
            result[0] = node.val;
            return; // Stop recursion when kth element is found
        }

        // Traverse right subtree
        inOrderTraversal(node.right, k, count, result);
    }
}
