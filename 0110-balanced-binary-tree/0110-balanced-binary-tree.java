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
    public int findMaxH(TreeNode root){
        if(root == null){
            return 0;

        }
        int left = findMaxH(root.left);
        int right = findMaxH(root.right);
        return  Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftH = findMaxH(root.left);
        int rightH = findMaxH(root.right);
        if(Math.abs(leftH-rightH) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }else{
            return false;
        }
    }
}