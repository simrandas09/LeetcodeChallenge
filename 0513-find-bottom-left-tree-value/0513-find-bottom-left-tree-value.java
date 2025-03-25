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
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1; // Base case

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        Map<Integer, Integer> map = new TreeMap<>();
        
        while (!q.isEmpty()) {
            Pair temp = q.remove();
            TreeNode node = temp.node;
            int hd = temp.hd;

            // Store the leftmost value for each level
            map.putIfAbsent(hd, node.val);

            if (node.left != null) {
                q.add(new Pair(node.left, hd + 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        // Get the leftmost value at the last row
        return map.get(Collections.max(map.keySet()));
    }
    
    // Helper class to store TreeNode with its level
    static class Pair {
        TreeNode node;
        int hd;
        
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
