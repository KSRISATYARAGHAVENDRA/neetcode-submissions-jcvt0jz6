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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>(); 

        ListNode curr = head;

        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }

        ListNode first = head;
        int n = stack.size() / 2;
        // add from stack
        for(int i = 0; i < n; i++){
            ListNode temp = first.next;
            ListNode second = stack.pop();

            first.next = second;
            second.next = temp;

            first = temp; 
        }
        first.next = null;
        return;
    }
}
