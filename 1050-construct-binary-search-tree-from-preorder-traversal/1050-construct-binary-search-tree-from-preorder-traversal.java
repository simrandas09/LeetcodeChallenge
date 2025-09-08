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
    private int idx = 0; // global index tracker

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = build(preorder, root.val);   // left subtree
        root.right = build(preorder, bound);     // right subtree
        return root;
    }
}
