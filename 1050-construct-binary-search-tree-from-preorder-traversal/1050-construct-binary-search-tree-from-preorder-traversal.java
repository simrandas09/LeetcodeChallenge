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
    public TreeNode bstFromPreorder(int[] preorder) {
        // Pass an array to keep track of index (using array to handle pass-by-reference behavior)
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreorder(int[] preorder, int bound, int[] index) {
        // Base condition: index out of bounds or current value exceeds bound
        if (index[0] == preorder.length || preorder[index[0]] > bound) return null;

        // Create root node and increment index
        TreeNode root = new TreeNode(preorder[index[0]++]);

        // Recursively construct the left and right subtrees
        root.left = bstFromPreorder(preorder, root.val, index);
        root.right = bstFromPreorder(preorder, bound, index);

        return root;
    }
}
