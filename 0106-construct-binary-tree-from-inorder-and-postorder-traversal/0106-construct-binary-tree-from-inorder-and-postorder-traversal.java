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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public TreeNode build(int[] postorder, int postStart, int postEnd,
                          int[] inorder, int inStart, int inEnd,
                          Map<Integer, Integer> inMap) {

        if (postStart > postEnd || inStart > inEnd) return null;

        // Last element in postorder is the root
        TreeNode root = new TreeNode(postorder[postEnd]);

        int inIndex = inMap.get(root.val);
        int numsLeft = inIndex - inStart;

        // Build right subtree first, then left
        root.right = build(postorder, postStart + numsLeft, postEnd - 1, inorder, inIndex + 1, inEnd, inMap);
        root.left = build(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inIndex - 1, inMap);

        return root;
    }
}
