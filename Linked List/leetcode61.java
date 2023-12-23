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
        if (head == null){
            return head;
        }
        ListNode current = head;
        int size = 1;
        while (current.next != null){
            current = current.next;
            size++;
        }
        current = head;
        k = k % size;
        if (k == 0){
            return head;
        }
        for (int i = 0; i < size - k - 1; i++){
            current = current.next;
        }
        ListNode newHead = current.next;
        current.next = null;
        ListNode pointer = newHead;
        while (pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = head;
        return newHead;
    }
}