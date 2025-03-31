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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);

        int left = 0;
        int right = values.size() - 1;

        // Two-pointer technique
        while (left < right) {
            int sum = values.get(left) + values.get(right);
            if (sum == k) {
                return true; // Pair found
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false; // No such pair exists
    }

    // In-order traversal to get sorted elements
    private void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inOrderTraversal(node.left, values);
        values.add(node.val);
        inOrderTraversal(node.right, values);
    }
}
