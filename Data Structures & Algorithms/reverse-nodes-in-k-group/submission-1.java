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
// recursion 
class Solution {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int group = 0;

        while(curr != null && group< k){
            curr = curr.next;
            group++;
        }

        if(group == k){
            ListNode cur = reverseKGroup(curr ,k);
            
            ListNode prev = cur;
            ListNode current = head;
            while(group-- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head ;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}
