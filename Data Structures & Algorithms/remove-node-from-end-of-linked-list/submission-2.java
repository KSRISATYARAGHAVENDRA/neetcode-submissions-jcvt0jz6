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
        ArrayList<ListNode> list = new ArrayList<>();
        
        ListNode curr = head;
        while(curr != null){
            list.add(curr);
            curr = curr.next;
        }

        int removeIndex = list.size() - n;

        if(removeIndex == 0){
            return list.get(removeIndex).next;
        }
        else{
            list.get(removeIndex - 1).next = list.get(removeIndex + 1);
        }

        return head;
    }
}
