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
/*
recursive
class Solution {
    private TreeNode prev = null;  // Keep track of the last visited node

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);  // Process right subtree first
        flatten(root.left);   // Process left subtree next

        root.right = prev;  // Set right pointer to the last visited node
        root.left = null;   // Set left pointer to null
        prev = root;        // Update last visited node
    }
}

*/
/* iterative
import java.util.Stack;

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }

            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }
            current.left = null;  // Set left child to null
        }
    }
}

*/
//morris
class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode predecessor = current.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                predecessor.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
