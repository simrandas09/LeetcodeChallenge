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
    int  maxDiameter = 0; //global variable
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }
    private int depth(TreeNode node){
        if(node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        maxDiameter = Math.max(maxDiameter,leftDepth+rightDepth);
        return Math.max(leftDepth,rightDepth) + 1; 
        
    }
    
}