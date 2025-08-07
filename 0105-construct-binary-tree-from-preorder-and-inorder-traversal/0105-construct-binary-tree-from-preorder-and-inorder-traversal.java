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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer,Integer>();

        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i], i);
        }

        TreeNode root = func(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
        return root;
    }

    public TreeNode func(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inMap){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = inMap.get(root.val);

        int numsLeft = idx-inStart;
        root.left = func(preorder, preStart+1, preStart+numsLeft, inorder, inStart, idx-1, inMap);
        root.right = func(preorder, preStart+numsLeft+1, preEnd, inorder, idx+1, inEnd, inMap);
        return root;
    }
}