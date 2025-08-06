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
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> qs = new LinkedList<>();
        qs.offer(root);
        boolean flag = true;
        while(!qs.isEmpty()){
            int size = qs.size();
            int[] arr = new int[size];
            for(int i=0;i<size;i++){
                TreeNode node = qs.poll();
                int idx = flag ? i : size-i-1;
                arr[idx] = node.val;
                if(node.left != null){
                    qs.offer(node.left);
                }if(node.right != null){
                    qs.offer(node.right);
                }
            }
            flag = !flag;
            List<Integer> rootans = new ArrayList<>();
                for (int num : arr) {
                    rootans.add(num);
                }
            result.add(rootans);
        }
        return result;
        
    }
}
