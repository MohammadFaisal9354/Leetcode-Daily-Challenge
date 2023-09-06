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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = length(head);
        ListNode[] nodes = new ListNode[k];
        nodes[0] = head;
        int q = length / k;
        int r = length % k;
        recursion(head,1,r,q,nodes,1);
        return   nodes;
    }
    private int length(ListNode head){
        if(head==null) return 0;
        else return 1 + length(head.next);
    }
    private void recursion(ListNode node ,int i, int r,int q, ListNode[] nodes,int index){
        if(index>=nodes.length || node==null) return;
        if(q==0 || i%q==0){
            if(q==0){
                ListNode temp = node.next;
                node.next = null;
                nodes[index] = temp;
                recursion(temp,1,r-1,q,nodes,index+1);   
            }
            else if(r==0){
                ListNode temp = node.next;
                node.next = null;
                nodes[index] = temp;
                recursion(temp,1,r,q,nodes,index+1);   
            }
            else if(r>0){
                ListNode temp = node.next.next;
                node.next.next = null;
                nodes[index] = temp;
                recursion(temp,1,r-1,q,nodes,index+1);     
            }
        }else
             recursion(node.next,i+1,r,q,nodes,index);   
    } 
}
