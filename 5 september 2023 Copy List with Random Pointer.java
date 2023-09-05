/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr=head,next=null;
        for(curr=head;curr!=null;)
        {
             next=curr.next;
            curr.next=new Node(curr.val);
            curr.next.next=next;
            curr=next;
        }
        for(curr=head;curr!=null;curr=curr.next.next)
        {
            if(curr.random!=null)
            {
                curr.next.random=curr.random.next;
            }
            else
            {
                curr.next.random=null;
            }
        }
        Node dummy=new Node(0);
        Node help=dummy;
        while(head!=null)
        {
            help.next=head.next;
            help=help.next;
            head.next=head.next.next;
            head=head.next;
        }
        return dummy.next;

        
    }
}
