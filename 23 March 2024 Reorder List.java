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
    ListNode reverseLL(ListNode node) {
        if (node == null || node.next == null)
            return node;
        ListNode last = reverseLL(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revHalf = reverseLL(slow);
        ListNode curr = head;
        while (revHalf.next != null) {
            ListNode tempFront = curr.next;
            curr.next = revHalf;
            ListNode tempBack = revHalf.next;
            revHalf.next = tempFront;
            revHalf = tempBack;
            curr = tempFront;
        }
    }
}
