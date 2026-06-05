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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0 ) return null;

        return divide(lists , 0, n -1);
    }
    ListNode divide(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        int mid = left + ((right - left) / 2);
        ListNode a = divide(lists , left ,mid);
        ListNode b = divide(lists ,mid + 1 ,right);

        return merge(a , b);
    }
    
    ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }
            else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if(l1 != null){
            node.next = l1;
        }
        else{
            node.next = l2;
        }
        return dummy.next;
    }
}
