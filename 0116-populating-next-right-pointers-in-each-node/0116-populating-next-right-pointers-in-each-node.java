/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null; // If tree is empty, return

        Node current = root; // Start from root

        // Loop while current has a left child (means more levels exist)
        while (current.left != null) {
            Node temp = current; // Pointer to traverse the current level

            // Connect nodes at the current level
            while (temp != null) {
                temp.left.next = temp.right; // Connect left -> right

                // Connect right child to next node's left child if exists
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }

                temp = temp.next; // Move to the next node on the same level
            }

            current = current.left; // Move to the next level
        }

        return root; // Return the modified tree
    }
}
