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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;
        while (current != null && current.next != null && current.next.next != null){
            ListNode next = current.next;
            current.next = current.next.next;
            current = current.next;
            ListNode third = current.next;
            current.next = next;
            next.next = third;
            current = current.next;
        }
        return dummy.next;
    }
}