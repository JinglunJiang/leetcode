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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null){
            return null;
        }
        if (head.next.next == null){
            head.next = null;
            return head;
        }
        ListNode current = head;
        int size = 1;
        while (current.next != null){
            current = current.next;
            size++;
        }
        int index = size / 2;
        ListNode newNode = head;
        while (index > 1){
            newNode = newNode.next;
            index--;
        }
        newNode.next = newNode.next.next;
        return head;
    }
}