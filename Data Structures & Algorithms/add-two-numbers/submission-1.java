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
    public ListNode add(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        int v1 = 0;
        int v2 = 0;
        int sum = 0;

        if(l1 != null){
            v1 = l1.val;
        }
        if(l2 != null){
            v2 = l2.val;
        }

        sum = v1 + v2 + carry;
        int nodevalue = sum % 10;
        int newcarry = sum / 10;

        ListNode nextnode = add((l1 != null)? l1.next : null,
                                (l2 != null)? l2.next : null,
                                newcarry);
        return new ListNode(nodevalue, nextnode); 
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }
}
