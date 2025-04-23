/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap based on ListNode's value
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each non-null list to the heap
        for (ListNode list : lists) {
            if (list != null) heap.add(list);
        }

        ListNode dummy = new ListNode(0); // Dummy node to build the merged list
        ListNode tail = dummy;

        while (!heap.isEmpty()) {
            ListNode node = heap.poll(); // Get the node with the smallest value
            tail.next = node;            // Append it to the merged list
            tail = tail.next;

            if (node.next != null) {
                heap.add(node.next); // Push the next node of the current list
            }
        }

        return dummy.next;
    }
}
