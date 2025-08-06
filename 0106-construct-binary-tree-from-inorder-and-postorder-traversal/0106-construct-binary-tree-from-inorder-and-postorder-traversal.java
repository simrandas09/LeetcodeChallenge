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
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        return buildTreeNode(postorder, postorder.length - 1, 0, inorder, 0, inorder.length - 1, mp);
    }

    private TreeNode buildTreeNode(int[] postorder, int postEnd, int postStart,
                                   int[] inorder, int inStart, int inEnd,
                                   Map<Integer, Integer> mp) {
        if (postEnd < postStart || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = mp.get(root.val);
        int rightTreeSize = inEnd - inIndex;

        // Build right subtree
        root.right = buildTreeNode(postorder, postEnd - 1, postEnd - rightTreeSize,
                                   inorder, inIndex + 1, inEnd, mp);

        // Build left subtree
        root.left = buildTreeNode(postorder, postEnd - rightTreeSize - 1, postStart,
                                  inorder, inStart, inIndex - 1, mp);

        return root;
    }
    }
