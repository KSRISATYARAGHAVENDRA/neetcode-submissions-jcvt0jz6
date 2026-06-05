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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);

        for(ListNode list : lists){
            pq.offer(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll();

            head.next = node;
            head = head.next;

            if(node.next != null){
            pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
