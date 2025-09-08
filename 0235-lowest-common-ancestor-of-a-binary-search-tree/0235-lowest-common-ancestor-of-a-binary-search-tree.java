/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        while (root != null) {
            // If both values are smaller, move left
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both values are larger, move right
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } 
            // If split happens, we found the LCA
            else {
                return root;
            }
        }
        return null; // In case no LCA is found
    }
}
