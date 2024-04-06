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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        ListNode current = head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        int steps = k % count;
        if (steps == 0){
            return head;
        }
        ListNode pointer = head;
        for (int i = 0; i < count - steps - 1; i++){
            pointer = pointer.next;
        }
        ListNode newHead = pointer.next;
        pointer.next = null;
        ListNode pointer2 = newHead;
        while (pointer2.next != null){
            pointer2 = pointer2.next;
        }
        pointer2.next = head;
        return newHead;
    }
}