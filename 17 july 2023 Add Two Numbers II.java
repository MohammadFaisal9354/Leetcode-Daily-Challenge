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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode temp = new ListNode(0), head = temp;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0){
            int sum = 0;
            sum+= (l1 != null) ? l1.val : 0;
            sum+= (l2 != null) ? l2.val : 0;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;

            sum+=carry;
            carry = sum/10;
            ListNode n = new ListNode(sum%10);
            temp.next = n;
            temp = temp.next;
        }

        ListNode ans = reverse(head.next);
        return ans;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev=null, curr=head;
        while(curr != null){
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        return prev;
    }
}
