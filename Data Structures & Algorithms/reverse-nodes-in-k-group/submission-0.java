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
    ListNode kthnode(ListNode curr, int k){
            while(curr != null && k > 0){
                curr = curr.next;
                k--;
            }
            return curr;
    }
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prevgroup = dummy;

            while(true){
                ListNode kth = kthnode(prevgroup ,k);

                if(kth == null) break;

                ListNode nextgroup = kth.next;

                ListNode prev = nextgroup;
                ListNode curr = prevgroup.next;
                while(curr != nextgroup){
                    ListNode temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp; 
                }

                ListNode temp = prevgroup.next;
                prevgroup.next = kth;
                prevgroup = temp;
            }
        return dummy.next;
    }
}
