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
    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        ListNode prev = head = new ListNode(0, head);

        while(temp != null && temp.val < x){
            prev = prev.next;
            temp = temp.next;
        }
        ListNode node = prev;
        while(temp != null){
            if(temp.val < x){
                node.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
                prev = temp;
                temp = node.next;
                continue;

            }
            node = node.next;
            temp = temp.next;
        }
       return head.next;
    }
}
