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
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode list : lists){
            ListNode current = list;
            while (current != null){
                queue.offer(current.val);
                current = current.next;
            }
        }
        ListNode head = new ListNode();
        ListNode current = head;
        while (!queue.isEmpty()){
            int val = queue.poll();
            current.next = new ListNode(val);
            current = current.next;
        }
        return head.next;
    }
}