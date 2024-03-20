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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        int index=0;
        while(list1!=null){
            if(index==a){
                while(list2!=null){
                    temp.next=list2;
                    list2=list2.next;
                    temp=temp.next;
                }
            }
            if(index<a || index>b){
                temp.next=list1;
                temp=temp.next;
                }
            list1=list1.next;
            index++;
        }
        return ans.next;
        
    }
}
