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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode t = head;
        while(t!=null){
            arr.add(t.val);
            t=t.next;
        }
        left = left-1;
        right = right-1;
        while(left<right){
            int a = arr.get(left);
            arr.set(left,arr.get(right));
            arr.set(right,a);
            left++;
            right--;
        }
        ListNode ans = new ListNode(-1);
        t=ans;
        for(var a : arr){
            t.next = new ListNode(a);
            t=t.next;
        }
        return ans.next;
    }
}
