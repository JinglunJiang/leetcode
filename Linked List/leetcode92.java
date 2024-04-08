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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left >= right){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode preLeft = dummy;
        for (int i = 1; i < left && preLeft != null; i++){
            preLeft = preLeft.next;
        }
        ListNode leftNode = preLeft.next;
        ListNode current = leftNode;
        ListNode previous = preLeft;
        for (int i = left; i <= right && leftNode != null; i++){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        leftNode.next = current;
        preLeft.next = previous;
        return dummy.next;
    }
}