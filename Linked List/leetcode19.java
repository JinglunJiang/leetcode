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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int num = 1;
        ListNode pointer = head;
        while (pointer.next != null){
            num++;
            pointer = pointer.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        int count = 0;
        pointer = dummy;
        while (count < num - n){
            pointer = pointer.next;
            count++;
        }
        pointer.next = pointer.next.next;
        return dummy.next;
    }
}