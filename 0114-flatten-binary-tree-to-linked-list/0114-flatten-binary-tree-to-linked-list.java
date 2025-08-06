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
    private TreeNode prev = null;  // Keep track of the last visited node

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);  // Process right subtree first
        flatten(root.left);   // Process left subtree next

        root.right = prev;  // Set right pointer to the last visited node
        root.left = null;   // Set left pointer to null
        prev = root;       

    }
}


