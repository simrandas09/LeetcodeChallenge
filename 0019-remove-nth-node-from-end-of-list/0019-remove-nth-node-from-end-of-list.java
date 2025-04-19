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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Initialize two pointers
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step 3: Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 4: Move both fast and slow until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 5: Remove the nth node from end
        slow.next = slow.next.next;

        // Step 6: Return the new head
        return dummy.next;
    }
}
