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
    static class Pair {
        TreeNode node;
        int row, col;
        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store nodes in sorted order (column -> List of (row, value))
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        // BFS queue (node, row, col)
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            // Add to TreeMap (column -> List of [row, value])
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.val});

            // Enqueue left & right children with updated row and column
            if (node.left != null) queue.add(new Pair(node.left, row + 1, col - 1));
            if (node.right != null) queue.add(new Pair(node.right, row + 1, col + 1));
        }

        // Extract sorted values
        for (List<int[]> list : map.values()) {
            // Sort by row first, then by value
            Collections.sort(list, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
            List<Integer> colValues = new ArrayList<>();
            for (int[] pair : list) colValues.add(pair[1]);
            result.add(colValues);
        }

        return result;
    }
}
