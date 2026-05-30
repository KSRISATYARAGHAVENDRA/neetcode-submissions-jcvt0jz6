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
        ListNode curr = head;
        ArrayList<ListNode> seen = new ArrayList<>();

        while(curr != null){
            seen.add(curr);
            curr = curr.next;
        }
        
        int l = 0;
        int r = seen.size() - 1;
        while(l < r){
            seen.get(l).next = seen.get(r);
            l++;

            if(l == r){
                break;
            }

            seen.get(r).next = seen.get(l);
            r--;
        }
        seen.get(l).next = null;
        return;
    }
}
