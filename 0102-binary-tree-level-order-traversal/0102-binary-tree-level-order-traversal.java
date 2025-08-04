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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();

        if(root == null) return levelOrder;
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int levelSize = queue.size(); 
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); 
                currentLevel.add(node.val); 

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
        }
        levelOrder.add(currentLevel);
        }
        return levelOrder;
    }
}