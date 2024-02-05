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
        for (ListNode head : lists){
            ListNode current = head;
            while (head != null){
                queue.offer(head.val);
                head = head.next;
            }
        }
        ListNode head = new ListNode();
        ListNode current = head;
        while (!queue.isEmpty()){
            current.next = new ListNode(queue.poll());
            current = current.next;
        }
        return head.next;
    }
}