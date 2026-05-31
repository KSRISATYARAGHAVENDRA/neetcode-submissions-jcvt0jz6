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
        Node curr = head;
        while(curr != null){
            Node next = curr.next;

            curr.next = new Node(curr.val);
            curr.next.next = next; 

            curr = next;
        }
        
        curr = head;
        while(curr != null){
            Node copy = curr.next;

            if(curr.random != null){
                copy.random = curr.random.next;
            }

            curr = copy.next;
        }

        Node dummy = new Node(0);
        Node node = dummy;
        curr = head;

        while(curr != null){
            Node copy = curr.next;

            curr.next = copy.next;
            node.next = copy;
            
            node = copy;
            curr = copy.next;
        }
        return dummy.next;
    }
}
